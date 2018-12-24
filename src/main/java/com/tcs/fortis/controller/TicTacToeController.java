package com.tcs.fortis.controller;

import com.tcs.fortis.constants.TicTacToeConstants;

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
    }

    public void itemStateChanged(ItemEvent e) {

    }

    public void actionPerformed(ActionEvent e) {

    }
}