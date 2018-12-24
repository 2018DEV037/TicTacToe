package com.tcs.fortis.service;

import com.tcs.fortis.constants.TicTacToeConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicTacToeServiceTest {

    private TicTacToeService ticTacToeService;

    @Before
    public void initialize() {
        ticTacToeService = new TicTacToeService();
    }

    @Test
    public void testResetMethodToResetTheBoard() {
        ticTacToeService.resetBoard();
        Assert.assertEquals(TicTacToeConstants.positions[TicTacToeConstants.ONE].getText(), TicTacToeConstants.EMPTY_STRING);
    }

    @Test
    public void testResetFontMethodToResetTheFont() {
        ticTacToeService.resetBoard();
        Assert.assertEquals(TicTacToeConstants.positions[TicTacToeConstants.ONE].getFont(), TicTacToeConstants.fontPlain);
    }

    @Test
    public void testCheckWhetherMatchDrawOrNot() {
        TicTacToeConstants.positions[TicTacToeConstants.ZERO].setText(TicTacToeConstants.EMPTY_STRING);
        Assert.assertFalse(ticTacToeService.checkWhetherMatchDrawOrNot());
    }

    @Test
    public void testPopulatePlayerKeyInScreenReturnsTrueAsCoordinateAlreadyPopulatedPlayerOneKey() {
        TicTacToeConstants.positions[2].setText(TicTacToeConstants.playerOneKey);
        Assert.assertTrue(ticTacToeService.populatePlayerKeyInScreen(2));
    }

    @Test
    public void testPopulatePlayerKeyInScreenReturnsTrueAsCoordinateAlreadyPopulatedPlayerTwoKey() {
        TicTacToeConstants.positions[2].setText(TicTacToeConstants.playerTwoKey);
        Assert.assertTrue(ticTacToeService.populatePlayerKeyInScreen(2));
    }

}