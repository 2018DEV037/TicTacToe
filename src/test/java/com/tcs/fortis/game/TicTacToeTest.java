package com.tcs.fortis.game;

import org.junit.Before;
import org.junit.Test;


public class TicTacToeTest {

    @Before
    public void initialize() {
        TicTacToe ticTacToe = new TicTacToe();
    }

    @Test
    public void testMainMethod() {
        TicTacToe.main(new String[]{});
    }
}