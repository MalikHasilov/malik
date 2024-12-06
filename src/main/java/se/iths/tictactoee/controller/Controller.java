package se.iths.tictactoee.controller;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import se.iths.tictactoee.model.Model;
import se.iths.tictactoee.model.Computer;


public class Controller {
    private final Model model;
    private final Computer computer; // initierar model computer och player
    private final GridPane board;

    public Controller(Model model, GridPane board) {
        this.model = model;
        this.computer = new Computer();
        this.board = board;
    }

    public void handleMove(int row, int col, Button button) {
        if (model.makeMove(row, col)) {
            button.setText(String.valueOf(model.getCurrentPlayer() == 'O' ? 'X' : 'O'));

            char winner = model.checkWinner();
            if (winner != '\0') {
                System.out.println("Winner: " + winner);
                return;
            }
            if (model.isFull()) {
                System.out.println("Draw!");
                return;
            }

            if (model.getCurrentPlayer() == 'O') {
                int[] computerMove = computer.getMove(model.getBoard());
                Button computerButton = (Button) board.getChildren()
                        .get(computerMove[0] * 3 + computerMove[1]);
                handleMove(computerMove[0], computerMove[1], computerButton);
            }
        }
    }
}
