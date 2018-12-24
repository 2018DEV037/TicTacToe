package com.tcs.fortis.controller;

import com.tcs.fortis.constants.TicTacToeConstants;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TicTacToeControllerTest {

    private TicTacToeController ticTacToeController;

    private ActionEvent actionEvent;

    @Before
    public void initialize() {
        ticTacToeController = new TicTacToeController();
        new TicTacToeConstants();
        ticTacToeController.showButton();
        int uniqueId = (int) System.currentTimeMillis();
        String commandName = "";
        actionEvent = new ActionEvent(this, uniqueId, commandName);
    }

    @Test
    public void xShouldAlwaysGoesFirst() {
        actionEvent.setSource(TicTacToeConstants.positions[0]);
        ticTacToeController.actionPerformed(actionEvent);
        assertEquals("X", TicTacToeConstants.positions[0].getText());
    }

    @Test
    public void oShouldNotAlwaysGoesFirst() {
        actionEvent.setSource(TicTacToeConstants.positions[0]);
        ticTacToeController.actionPerformed(actionEvent);
        assertNotEquals("O", TicTacToeConstants.positions[0].getText());
    }
}