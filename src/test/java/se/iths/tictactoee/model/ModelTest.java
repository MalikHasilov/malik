package se.iths.tictactoee.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new Model();
    }

    @Test
    public void testInitialCurrentPlayer() {
        assertEquals('X', model.getCurrentPlayer(), "Initial player should be X");
    }

    @Test
    public void testMakeMove() {
        assertTrue(model.makeMove(0, 0), "Move should be valid");
        assertEquals('X', model.getBoard()[0][0], "Board should have X at (0, 0)");
        assertEquals('O', model.getCurrentPlayer(), "Next player should be O");
    }

    @Test
    public void testInvalidMove() {
        model.makeMove(0, 0);
        assertFalse(model.makeMove(0, 0), "Move should be invalid");
    }

    @Test
    public void testCheckWinnerRow() {
        model.makeMove(0, 0);
        model.makeMove(1, 0);
        model.makeMove(0, 1);
        model.makeMove(1, 1);
        model.makeMove(0, 2);
        assertEquals('X', model.checkWinner(), "Player X should win");
    }
        @Test
        public void testNoWinnerYet() {
            model.makeMove(0, 0);
            model.makeMove(1, 0);
            model.makeMove(0, 1);
            model.makeMove(1, 1);

            assertEquals('\0', model.checkWinner(), "Player X should win");

    }



    @Test
    public void testCheckWinnerColumn() {
        model.makeMove(0, 0);
        model.makeMove(0, 1);
        model.makeMove(1, 0);
        model.makeMove(1, 1);
        model.makeMove(2, 0);
        assertEquals('X', model.checkWinner(), "Player X should win");
    }

    @Test
    public void testCheckWinnerDiagonal() {
        model.makeMove(0, 0);
        model.makeMove(0, 1);
        model.makeMove(1, 1);
        model.makeMove(0, 2);
        model.makeMove(2, 2);
        assertEquals('X', model.checkWinner(), "Player X should win");
    }
        @Test
        public void testCheckWinnerDiagonaltwo() {
            model.makeMove(0, 2);
            model.makeMove(0, 1);
            model.makeMove(1, 1);
            model.makeMove(1, 2);
            model.makeMove(2, 0);
            assertEquals('X', model.checkWinner(), "Player X should win");
        }


    @Test
    public void testIsFull() {
        model.makeMove(0, 0);
        model.makeMove(0, 1);
        model.makeMove(0, 2);
        model.makeMove(1, 0);
        model.makeMove(1, 1);
        model.makeMove(1, 2);
        model.makeMove(2, 0);
        model.makeMove(2, 1);
        model.makeMove(2, 2);
        assertTrue(model.isFull(), "Board should be full");
    }

    @Test
    public void testReset() {
        model.makeMove(0, 0);
        model.reset();
        assertEquals('X', model.getCurrentPlayer(), "Player should be reset to X");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('\0', model.getBoard()[i][j], "Board should be empty");
            }
        }
    }
}