module se.iths.tictactoee {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.tictactoee to javafx.fxml;
    exports se.iths.tictactoee;
    exports se.iths.tictactoee.controller;
    opens se.iths.tictactoee.controller to javafx.fxml;
}