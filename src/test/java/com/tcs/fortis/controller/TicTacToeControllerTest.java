package com.tcs.fortis.controller;

import com.tcs.fortis.constants.TicTacToeConstants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import static org.junit.Assert.*;

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

    @Test
    public void playerShouldNotPlayinPlayedPosition() {
        actionEvent.setSource(TicTacToeConstants.positions[0]);
        assertFalse(TicTacToeConstants.playedPosition[0]);
        ticTacToeController.actionPerformed(actionEvent);
        assertTrue(TicTacToeConstants.playedPosition[0]);
    }

    @Test
    public void playerShouldGetTieIfBoardIsFullWithNoWin() {


        TicTacToeConstants.showDialog = false;
        tieGameEvents();
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.MATCH_TIE, ticTacToeController.ticTacToeResponse.getResponse());

        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    @Test
    public void playerShouldGetTieIfBoardIsFullWithNoWinAndReset() {


        TicTacToeConstants.showDialog = false;
        tieGameEvents();
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.MATCH_TIE, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.resetThePlay.doClick();
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    @Test
    public void playerShouldGetTieIfBoardIsFullWithNoWinAndResetWithTypeFalse() {

        TicTacToeConstants.type = false;
        TicTacToeConstants.showDialog = false;
        tieGameEvents();
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.COMPUTER_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.resetThePlay.doClick();
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    @Test
    public void playerShouldGetTieIfBoardIsFullWithNoWinAndResetWithTypeTrue() {

        TicTacToeConstants.type = false;
        TicTacToeConstants.showDialog = true;
        tieGameEvents();
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.COMPUTER_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.resetThePlay.doClick();
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }


    private void tieGameEvents() {
        actionEvent.setSource(TicTacToeConstants.positions[0]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[1]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[3]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[5]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[2]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[4]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[8]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[6]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[7]);
    }

    @Test
    public void playerShouldGetTieIfBoardIsFullWithNoWinWithShowDialogTrue() {


        TicTacToeConstants.showDialog = true;
        tieGameEvents();
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.MATCH_TIE, ticTacToeController.ticTacToeResponse.getResponse());

        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    @Test
    public void playerShouldWinForHorizontal() {
        TicTacToeConstants.showDialog = false;
        actionEvent.setSource(TicTacToeConstants.positions[0]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[7]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[1]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[5]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[2]);
        ticTacToeController.actionPerformed(actionEvent);
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.PLAYER1_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    @Test
    public void playerShouldWinForVertical() {

        TicTacToeConstants.showDialog = false;
        actionEvent.setSource(TicTacToeConstants.positions[0]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[2]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[3]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[5]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[6]);
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.PLAYER1_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    @Test
    public void playerShouldWinForDiagonal() {

        TicTacToeConstants.showDialog = false;
        playerOneDiagonalEvents();

        assertEquals(TicTacToeConstants.PLAYER1_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    @Test
    public void playerShouldWinForDiagonalWithShowDialogTrue() {

        TicTacToeConstants.showDialog = true;
        playerOneDiagonalEvents();

        assertEquals(TicTacToeConstants.PLAYER1_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    private void playerOneDiagonalEvents() {
        actionEvent.setSource(TicTacToeConstants.positions[0]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[2]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[4]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[5]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[8]);
        ticTacToeController.actionPerformed(actionEvent);
    }

    @Test
    public void player2ShouldWinForDiagonal() {
        TicTacToeConstants.type = true;
        TicTacToeConstants.showDialog = false;
        player2WonActions();
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.PLAYER2_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    private void player2WonActions() {
        actionEvent.setSource(TicTacToeConstants.positions[0]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[1]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[3]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[6]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[4]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[7]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[2]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[8]);
    }

    @Test
    public void player2ShouldWinForDiagonalWithShowDialogTrue() {
        TicTacToeConstants.type = true;
        TicTacToeConstants.showDialog = true;
        player2WonActions();
        ticTacToeController.actionPerformed(actionEvent);

        assertEquals(TicTacToeConstants.PLAYER2_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    @Test
    public void testItemStateChanged() {
        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox checkbox1 = new Checkbox("vs computer", cbg, true);
        checkbox1.setBounds(120, 80, 100, 40);
        ticTacToeController.itemStateChanged(new ItemEvent(checkbox1, 1, null, ItemEvent.SELECTED));
        assertTrue(TicTacToeConstants.type);
    }

    @Test
    public void playWithComputerAndYouWon() {
        TicTacToeConstants.type = false;
        TicTacToeConstants.showDialog = false;
        playWithComputerEvents();

        assertEquals(TicTacToeConstants.YOU_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

    private void playWithComputerEvents() {
        actionEvent.setSource(TicTacToeConstants.positions[6]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[4]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[7]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[2]);
        ticTacToeController.actionPerformed(actionEvent);
        actionEvent.setSource(TicTacToeConstants.positions[8]);
        ticTacToeController.actionPerformed(actionEvent);
    }

    @Test
    public void playWithComputerAndYouWonShowDialog() {
        TicTacToeConstants.type = false;
        TicTacToeConstants.showDialog = true;
        playWithComputerEvents();

        assertEquals(TicTacToeConstants.YOU_WON_CLICK_RESET, ticTacToeController.ticTacToeResponse.getResponse());
        ticTacToeController.setVisible(false);
        ticTacToeController.dispose();
    }

}