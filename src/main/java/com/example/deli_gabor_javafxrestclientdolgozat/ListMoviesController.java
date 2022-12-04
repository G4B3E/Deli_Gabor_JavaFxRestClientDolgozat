package com.example.deli_gabor_javafxrestclientdolgozat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ListMoviesController {

    @FXML
    private Button insertButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView<Movie> moviesTable;
    @FXML
    private TableColumn<Movie, Integer> idCol;
    @FXML
    private TableColumn<Movie, String> movieCol;
    @FXML
    private TableColumn<Movie, Integer> yearCol;
    @FXML
    private TableColumn<Movie, String> prizeCol;


    @FXML
    private void initialize(){
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        movieCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        prizeCol.setCellValueFactory(new PropertyValueFactory<>("prize"));
        try {
            RequestHandler.get(App.BASE_URL);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText("Hiba történt az adatok lekérdezése során!");
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }
    @FXML
    public void insertClick(ActionEvent actionEvent) {
    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
    }

    @FXML
    public void deleteClick(ActionEvent actionEvent) {
    }
}