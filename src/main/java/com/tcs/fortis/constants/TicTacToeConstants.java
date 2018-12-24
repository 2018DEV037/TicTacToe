package com.tcs.fortis.constants;

import javax.swing.*;
import java.awt.*;

public class TicTacToeConstants {

    public static final String PLAYER2_WON_CLICK_RESET = "Player2 won!!! click reset";
    public static final String COMPUTER_WON_CLICK_RESET = "COMPUTER won!!! click reset";
    public static final String RESET = "RESET";
    public static final String COMPUTER = "vs computer";
    public static final String FRIEND = "vs friend";
    public static final String MATCH_TIE = "Match Tie!!!";
    public static final String YOU_WON_CLICK_RESET = "You won!!! click reset";
    public static final String PLAYER1_WON_CLICK_RESET = "Player1 won!!! click reset";
    public static final String TIC_TAC_TOE = "Tic Tac Toe";
    public static final String EMPTY_STRING = "";

    public static final int TEN = 10;
    public static final int ZERO = 0;
    public static final int EIGHT = 8;
    public static final int HUNDRED = 100;
    public static final int THREE = 3;
    public static final int THREE_FIFTY = 350;
    public static final int FIFTY = 50;
    public static final int ONE_TWENTY = 120;
    public static final int EIGHTY = 80;
    public static final int ONE_FIFTY = 150;
    public static final int FORTY = 40;
    public static final int THREE_THIRTY = 330;
    public static final int FOUR_FIFTY = 450;
    public static final int SEVEN = 7;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int ELEVEN = 11;

    public static String playerOneKey = "X";
    public static String playerTwoKey = "O";

    public static int ticTacToeCoordinates[][] = {{10, 1, 2, 3, 11}, {10, 1, 4, 7, 11},
            {10, 1, 5, 9, 11}, {10, 2, 5, 8, 11},
            {10, 3, 5, 7, 11}, {10, 3, 6, 9, 11}, {10, 4, 5, 6, 11}, {10, 7, 8, 9, 11}};

    public static int ticTacToeSuccessCoordinatesBackUp[][] = {{10, 1, 2, 3, 11}, {10, 1, 4, 7, 11},
            {10, 1, 5, 9, 11}, {10, 2, 5, 8, 11},
            {10, 3, 5, 7, 11}, {10, 3, 6, 9, 11}, {10, 4, 5, 6, 11}, {10, 7, 8, 9, 11}};

    public static Font fontPlain = new Font("Serif", Font.PLAIN, 14);
    public static Font fontBold = new Font("Serif", Font.BOLD, 14);

    public static JButton positions[] = new JButton[9];

    public static boolean state, type, set, showDialog = true;

    public static boolean playedPosition[] = new boolean[9];
}
