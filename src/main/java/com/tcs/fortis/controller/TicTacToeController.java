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

    private int rowIndex, columnIndex;
    public Checkbox playWithComputer, playWithFriend;
    public JButton resetThePlay;
    private static TicTacToeService service = new TicTacToeService();
    TicTacToeResponse ticTacToeResponse = new TicTacToeResponse();


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
        CheckboxGroup checkboxGroup = new CheckboxGroup();
        playWithComputer = new Checkbox(TicTacToeConstants.COMPUTER, checkboxGroup, false);
        playWithFriend = new Checkbox(TicTacToeConstants.FRIEND, checkboxGroup, false);
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

    }
}