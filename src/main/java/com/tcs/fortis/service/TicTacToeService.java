package com.tcs.fortis.service;

import com.tcs.fortis.constants.TicTacToeConstants;

public class TicTacToeService {

    /**
     * This method is used to check whether the given co-ordinate is already filled or not.
     *
     * @param coordinate - co-ordinate selected by player or computer
     */
    public void validateCoordinate(int coordinate) {
        for (int boardCell = TicTacToeConstants.ZERO; boardCell <= TicTacToeConstants.SEVEN; boardCell++) {
            for (int boardRow = TicTacToeConstants.ONE; boardRow <= TicTacToeConstants.THREE; boardRow++) {
                if (TicTacToeConstants.ticTacToeCoordinates[boardCell][boardRow] == coordinate) {
                    TicTacToeConstants.ticTacToeCoordinates[boardCell][TicTacToeConstants.FOUR]
                            = TicTacToeConstants.ELEVEN;
                }
            }
        }
    }

    /**
     * This method contains the logic when we want the computer to play.
     *
     * @param position - The position which computer chooses from the grid.
     */
    public void computerPlayLogic(int position) {
        int row, column, not_Empty_Position = TicTacToeConstants.ZERO;
        for (row = TicTacToeConstants.ZERO; row <= TicTacToeConstants.SEVEN; row++) {
            for (column = TicTacToeConstants.ONE; column <= TicTacToeConstants.THREE; column++) {
                if (TicTacToeConstants.ticTacToeCoordinates[row][column] == position) {
                    TicTacToeConstants.ticTacToeCoordinates[row][TicTacToeConstants.ZERO] = TicTacToeConstants.ELEVEN;
                    TicTacToeConstants.ticTacToeCoordinates[row][TicTacToeConstants.FOUR] = TicTacToeConstants.TEN;
                }
            }
        }
        for (row = TicTacToeConstants.ZERO; row <= TicTacToeConstants.SEVEN; row++) {
            TicTacToeConstants.set = true;
            if (TicTacToeConstants.ticTacToeCoordinates[row][TicTacToeConstants.FOUR] == TicTacToeConstants.TEN) {
                int count = TicTacToeConstants.ZERO;
                for (column = TicTacToeConstants.ONE; column <= TicTacToeConstants.THREE; column++) {
                    if (!TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[row][column]
                            - TicTacToeConstants.ONE)].getText().equals(TicTacToeConstants.EMPTY_STRING)) {
                        count++;
                    } else {
                        not_Empty_Position = TicTacToeConstants.ticTacToeCoordinates[row][column];
                    }
                }
                if (count == TicTacToeConstants.TWO) {
                    TicTacToeConstants.positions[not_Empty_Position - TicTacToeConstants.ONE]
                            .setText(TicTacToeConstants.playerTwoKey);
                    TicTacToeConstants.playedPosition[not_Empty_Position - TicTacToeConstants.ONE] = true;
                    validateCoordinate(not_Empty_Position);
                    TicTacToeConstants.set = false;
                    break;
                }
            } else if (TicTacToeConstants.ticTacToeCoordinates[row][TicTacToeConstants.ZERO]
                    == TicTacToeConstants.TEN) {
                for (column = TicTacToeConstants.ONE; column <= TicTacToeConstants.THREE; column++) {
                    if (TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[row][column]
                            - TicTacToeConstants.ONE)].getText().equals(TicTacToeConstants.EMPTY_STRING)) {
                        TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[row][column]
                                - TicTacToeConstants.ONE)].setText(TicTacToeConstants.playerTwoKey);
                        TicTacToeConstants.playedPosition[
                                (TicTacToeConstants.ticTacToeCoordinates[row][column] - TicTacToeConstants.ONE)] = true;
                        validateCoordinate(TicTacToeConstants.ticTacToeCoordinates[row][column]);
                        TicTacToeConstants.set = false;
                        break;
                    }
                }
                if (!TicTacToeConstants.set)
                    break;
            }
            if (!TicTacToeConstants.set)
                break;
        }
    }

    /**
     * This method is used to populate the players Key in the Screen for the given co-ordinate.
     *
     * @param coordinate - Co-ordinate selected
     * @return boolean - returns whether the player key is populated or not.
     */
    public boolean populatePlayerKeyInScreen(int coordinate) {
        String btnLbl;
        boolean exitFlag = false;
        if (TicTacToeConstants.positions[coordinate].getText().equals(TicTacToeConstants.playerOneKey)
                || TicTacToeConstants.positions[coordinate].getText().equals(TicTacToeConstants.playerTwoKey)) {
            exitFlag = true; // don't overwrite the jbutton label
        }
        if (TicTacToeConstants.positions[coordinate].getText().equals(TicTacToeConstants.EMPTY_STRING)) {
            if (TicTacToeConstants.state) {
                btnLbl = TicTacToeConstants.playerOneKey;
                TicTacToeConstants.state = false;
            } else {
                btnLbl = TicTacToeConstants.playerTwoKey;
                TicTacToeConstants.state = true;
            }
            TicTacToeConstants.positions[coordinate].setText(btnLbl);
            TicTacToeConstants.playedPosition[coordinate] = true;
        }
        return exitFlag;
    }

    /**
     * This method is used to compare the player co-ordinates to check whether match is draw.
     *
     * @return boolean
     */
    public boolean checkWhetherMatchDrawOrNot() {
        boolean exitFlag = true;
        for (int row = TicTacToeConstants.ZERO; row <= TicTacToeConstants.EIGHT; row++) {
            if (TicTacToeConstants.EMPTY_STRING.equals(TicTacToeConstants.positions[row].getText())) {
                exitFlag = false;
            }
        }
        return exitFlag;
    }


    /**
     * This method is used to reset the board values
     */
    public void resetBoard() {
        for (int row = TicTacToeConstants.ZERO; row <= TicTacToeConstants.EIGHT; row++) {
            TicTacToeConstants.positions[row].setText(TicTacToeConstants.EMPTY_STRING);
        }
    }

    /**
     * This method is used to reset the board font
     */
    public void resetButtonFont() {
        for (int row = TicTacToeConstants.ZERO; row <= TicTacToeConstants.EIGHT; row++) {
            TicTacToeConstants.positions[row].setFont(TicTacToeConstants.fontPlain);
        }
    }
}
