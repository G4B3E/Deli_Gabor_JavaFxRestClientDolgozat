package com.example.deli_gabor_javafxrestclientdolgozat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
    private void initialize(){
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0,2022,1970);
        YearField.setValueFactory(valueFactory);
    }

    @FXML
    public void SubmitClick(ActionEvent actionEvent) {
    }
}
