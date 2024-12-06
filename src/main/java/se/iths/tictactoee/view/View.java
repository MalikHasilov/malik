package se.iths.tictactoee.view;

import se.iths.tictactoee.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class View {
    @FXML
    private GridPane board; // spelbrädan

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller; // sätter kontrollen som anävnds av view, mellan view och controller
    }

    @FXML
    public void handleButtonClick(javafx.event.ActionEvent event) {
        Button button = (Button) event.getSource();
        int row = GridPane.getRowIndex(button); // knapptryck hantering brädan
        int col = GridPane.getColumnIndex(button); // column

        controller.handleMove(row, col, button);
    }

    public GridPane getBoard() {
        return board;
    }
}