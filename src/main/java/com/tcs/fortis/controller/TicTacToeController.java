package com.tcs.fortis.controller;

import com.tcs.fortis.constants.TicTacToeConstants;
import com.tcs.fortis.models.TicTacToeResponse;
import com.tcs.fortis.service.TicTacToeService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TicTacToeController extends JFrame implements ItemListener, ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static TicTacToeService service = new TicTacToeService();
    TicTacToeResponse ticTacToeResponse = new TicTacToeResponse();

    private int rowIndex, columnIndex;
    public Checkbox playWithComputer, playWithFriend;
    public JButton resetThePlay;

    public void showButton() {
        int x_coordinate = TicTacToeConstants.TEN;
        int y_coordinate = TicTacToeConstants.TEN;
        columnIndex = TicTacToeConstants.ZERO;
        for (rowIndex = TicTacToeConstants.ZERO; rowIndex <= TicTacToeConstants.EIGHT; rowIndex++,
                x_coordinate += TicTacToeConstants.HUNDRED, columnIndex++) {
            TicTacToeConstants.positions[rowIndex] = new JButton();
            if (columnIndex == TicTacToeConstants.THREE) {
                columnIndex = TicTacToeConstants.ZERO;
                y_coordinate += TicTacToeConstants.HUNDRED;
                x_coordinate = TicTacToeConstants.TEN;
            }
            TicTacToeConstants.positions[rowIndex].setBounds(x_coordinate, y_coordinate,
                    TicTacToeConstants.HUNDRED, TicTacToeConstants.HUNDRED);
            TicTacToeConstants.positions[rowIndex].setFont(TicTacToeConstants.fontPlain);
            add(TicTacToeConstants.positions[rowIndex]);
            TicTacToeConstants.positions[rowIndex].addActionListener(this);
        }

        resetThePlay = new JButton(TicTacToeConstants.RESET);
        resetThePlay.setBounds(TicTacToeConstants.HUNDRED, TicTacToeConstants.THREE_FIFTY,
                TicTacToeConstants.HUNDRED, TicTacToeConstants.FIFTY);
        add(resetThePlay);
        resetThePlay.addActionListener(this);

    }

    public TicTacToeController() {
        super(TicTacToeConstants.TIC_TAC_TOE);
        CheckboxGroup cbg = new CheckboxGroup();
        playWithComputer = new Checkbox(TicTacToeConstants.COMPUTER, cbg, false);
        playWithFriend = new Checkbox(TicTacToeConstants.FRIEND, cbg, false);
        playWithComputer.setBounds(TicTacToeConstants.ONE_TWENTY, TicTacToeConstants.EIGHTY,
                TicTacToeConstants.HUNDRED, TicTacToeConstants.FORTY);
        playWithFriend.setBounds(TicTacToeConstants.ONE_TWENTY, TicTacToeConstants.ONE_FIFTY,
                TicTacToeConstants.HUNDRED, TicTacToeConstants.FORTY);
        add(playWithComputer);
        add(playWithFriend);
        playWithComputer.addItemListener(this);
        playWithFriend.addItemListener(this);
        TicTacToeConstants.state = true;
        TicTacToeConstants.type = true;
        TicTacToeConstants.set = true;
        for (int row = TicTacToeConstants.ZERO; row <= TicTacToeConstants.EIGHT; row++) {
            TicTacToeConstants.playedPosition[row] = false;
        }
        setLayout(null);
        setSize(TicTacToeConstants.THREE_THIRTY, TicTacToeConstants.FOUR_FIFTY);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void itemStateChanged(ItemEvent e) {
        if (playWithComputer.getState()) {
            TicTacToeConstants.type = false;
        } else if (playWithFriend.getState()) {
            TicTacToeConstants.type = true;
        }
        remove(playWithComputer);
        remove(playWithFriend);
        repaint(TicTacToeConstants.ZERO, TicTacToeConstants.ZERO, TicTacToeConstants.THREE_THIRTY,
                TicTacToeConstants.FOUR_FIFTY);
        showButton();
    }

    public void actionPerformed(ActionEvent e) {
        if (TicTacToeConstants.type)// logicfriend
        {
            if (e.getSource() == resetThePlay) {
                for (rowIndex = TicTacToeConstants.ZERO; rowIndex <= TicTacToeConstants.EIGHT; rowIndex++) {
                    TicTacToeConstants.positions[rowIndex].setText(TicTacToeConstants.EMPTY_STRING);
                    TicTacToeConstants.state = true;
                }
            } else {
                for (rowIndex = TicTacToeConstants.ZERO; rowIndex <= TicTacToeConstants.EIGHT; rowIndex++) {
                    if (e.getSource() == TicTacToeConstants.positions[rowIndex]) {
                        if (!service.populatePlayerKeyInScreen(rowIndex))
                            break;
                    }
                }
            }
        } else if (!TicTacToeConstants.type) { // complogic
            if (e.getSource() == resetThePlay) {
                for (rowIndex = TicTacToeConstants.ZERO; rowIndex <= TicTacToeConstants.EIGHT; rowIndex++) {
                    TicTacToeConstants.positions[rowIndex].setText(TicTacToeConstants.EMPTY_STRING);
                }
                for (rowIndex = TicTacToeConstants.ZERO; rowIndex <= TicTacToeConstants.SEVEN; rowIndex++)
                    for (columnIndex = TicTacToeConstants.ZERO; columnIndex <= TicTacToeConstants.FOUR; columnIndex++)
                        TicTacToeConstants.ticTacToeCoordinates[rowIndex][columnIndex]
                                = TicTacToeConstants.ticTacToeSuccessCoordinatesBackUp[rowIndex][columnIndex];
            } else {
                for (rowIndex = TicTacToeConstants.ZERO; rowIndex <= TicTacToeConstants.EIGHT; rowIndex++) {
                    if (e.getSource() == TicTacToeConstants.positions[rowIndex]) {
                        if (TicTacToeConstants.positions[rowIndex].getText().equals(TicTacToeConstants.playerOneKey)
                                || TicTacToeConstants.positions[rowIndex].getText()
                                .equals(TicTacToeConstants.playerTwoKey)) {
                            break; // don't overwrite the jbutton label
                        }
                        if (TicTacToeConstants.positions[rowIndex].getText().equals(TicTacToeConstants.EMPTY_STRING)) {
                            TicTacToeConstants.positions[rowIndex].setText(TicTacToeConstants.playerOneKey);
                            TicTacToeConstants.playedPosition[rowIndex] = true;
                            if (TicTacToeConstants.positions[TicTacToeConstants.FOUR].getText()
                                    .equals(TicTacToeConstants.EMPTY_STRING)) {
                                TicTacToeConstants.positions[TicTacToeConstants.FOUR]
                                        .setText(TicTacToeConstants.playerTwoKey);
                                TicTacToeConstants.playedPosition[TicTacToeConstants.FOUR] = true;
                                service.validateCoordinate(TicTacToeConstants.FIVE);
                            } else {
                                service.computerPlayLogic(rowIndex);
                            }
                        }
                    }
                }
            }
        }

        if (service.checkWhetherMatchDrawOrNot()) {
            ticTacToeResponse.setResponse(TicTacToeConstants.MATCH_TIE);
            if (TicTacToeConstants.showDialog) {
                JOptionPane.showMessageDialog(this, ticTacToeResponse.getResponse());
            }
            service.resetBoard();
            TicTacToeConstants.state = true;
        }

        for (rowIndex = TicTacToeConstants.ZERO; rowIndex <= TicTacToeConstants.SEVEN; rowIndex++) {
            String icon1Str = TicTacToeConstants.positions[
                    (TicTacToeConstants.ticTacToeCoordinates[rowIndex][TicTacToeConstants.ONE]
                            - TicTacToeConstants.ONE)].getText();
            String icon2Str = TicTacToeConstants.positions[
                    (TicTacToeConstants.ticTacToeCoordinates[rowIndex][TicTacToeConstants.TWO]
                            - TicTacToeConstants.ONE)].getText();
            String icon3Str = TicTacToeConstants.positions[
                    (TicTacToeConstants.ticTacToeCoordinates[rowIndex][TicTacToeConstants.THREE]
                            - TicTacToeConstants.ONE)].getText();
            if ((icon1Str.equals(icon2Str)) && (icon2Str.equals(icon3Str))
                    && (!TicTacToeConstants.EMPTY_STRING.equals(icon1Str))) {
                if (TicTacToeConstants.playerTwoKey.equals(icon1Str)) {
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.ONE]
                            - TicTacToeConstants.ONE)].setText(TicTacToeConstants.playerTwoKey);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.ONE]
                            - TicTacToeConstants.ONE)].setFont(TicTacToeConstants.fontBold);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.TWO]
                            - TicTacToeConstants.ONE)].setText(TicTacToeConstants.playerTwoKey);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.TWO]
                            - TicTacToeConstants.ONE)].setFont(TicTacToeConstants.fontBold);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.THREE]
                            - TicTacToeConstants.ONE)].setText(TicTacToeConstants.playerTwoKey);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.THREE]
                            - TicTacToeConstants.ONE)].setFont(TicTacToeConstants.fontBold);
                    if (TicTacToeConstants.type) {
                        ticTacToeResponse.setResponse(TicTacToeConstants.PLAYER2_WON_CLICK_RESET);
                        if (TicTacToeConstants.showDialog) {
                            JOptionPane.showMessageDialog(this, ticTacToeResponse.getResponse());
                        }
                    } else {
                        ticTacToeResponse.setResponse(TicTacToeConstants.COMPUTER_WON_CLICK_RESET);
                        if (TicTacToeConstants.showDialog) {
                            JOptionPane.showMessageDialog(this, ticTacToeResponse.getResponse());
                        }
                    }
                    service.resetBoard();
                    service.resetButtonFont();
                    TicTacToeConstants.state = true;
                    break;
                } else if (TicTacToeConstants.playerOneKey.equals(icon2Str)) {
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.ONE]
                            - TicTacToeConstants.ONE)].setText(TicTacToeConstants.playerOneKey);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.ONE]
                            - TicTacToeConstants.ONE)].setFont(TicTacToeConstants.fontBold);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.TWO]
                            - TicTacToeConstants.ONE)].setText(TicTacToeConstants.playerOneKey);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.TWO]
                            - TicTacToeConstants.ONE)].setFont(TicTacToeConstants.fontBold);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.THREE]
                            - TicTacToeConstants.ONE)].setText(TicTacToeConstants.playerOneKey);
                    TicTacToeConstants.positions[(TicTacToeConstants.ticTacToeCoordinates[rowIndex]
                            [TicTacToeConstants.THREE]
                            - TicTacToeConstants.ONE)].setFont(TicTacToeConstants.fontBold);
                    if (!TicTacToeConstants.type) {
                        ticTacToeResponse.setResponse(TicTacToeConstants.YOU_WON_CLICK_RESET);
                        if (TicTacToeConstants.showDialog) {
                            JOptionPane.showMessageDialog(this, ticTacToeResponse.getResponse());
                        }
                    } else {
                        ticTacToeResponse.setResponse(TicTacToeConstants.PLAYER1_WON_CLICK_RESET);
                        if (TicTacToeConstants.showDialog) {
                            JOptionPane.showMessageDialog(this, ticTacToeResponse.getResponse());
                        }
                    }
                    service.resetBoard();
                    service.resetButtonFont();
                    TicTacToeConstants.state = true;
                    break;
                }
            }
        }
    }
}