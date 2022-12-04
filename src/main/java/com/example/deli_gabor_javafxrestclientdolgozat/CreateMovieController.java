package com.example.deli_gabor_javafxrestclientdolgozat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class CreateMovieController {

    @FXML
    private TextField NameField;
    @FXML
    private TextField PrizeField;
    @FXML
    private Spinner<Integer> YearField;
    @FXML
    private Button SubmitButton;

    @FXML
    public void SubmitClick(ActionEvent actionEvent) {
    }
}
