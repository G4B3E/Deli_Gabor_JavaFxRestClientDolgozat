package com.example.deli_gabor_javafxrestclientdolgozat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

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
        String name = NameField.getText();
        int year = YearField.getValue();
        String prize = PrizeField.getText();
        if (name.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Figyelem!");
            alert.setHeaderText("Kérem töltse ki a 'Name' minden mezőt!");
            alert.showAndWait();
            return;
        }
        if (prize.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Figyelem!");
            alert.setHeaderText("Kérem töltse ki a 'Year' minden mezőt!");
            alert.showAndWait();
            return;
        }
        Movie newMovie = new Movie(0,year,name,prize);
        Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = converter.toJson(newMovie);
        try {
            Response response = RequestHandler.post(App.BASE_URL,json);
            if (response.getResponseCode() == 201){
                YearField.getValueFactory().setValue(1970);
                NameField.setText("");
                PrizeField.setText("");
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hiba!");
                alert.setHeaderText("Ismeretlen hiba történt ;( !");
                alert.showAndWait();
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba!");
            alert.setHeaderText("Nem sikerült csatlakozni a szerverhez!");
            alert.showAndWait();
        }
    }
}
