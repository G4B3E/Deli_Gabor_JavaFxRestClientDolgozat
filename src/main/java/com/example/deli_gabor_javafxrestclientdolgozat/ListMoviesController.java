package com.example.deli_gabor_javafxrestclientdolgozat;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

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
        movieCol.setCellValueFactory(new PropertyValueFactory<>("movies"));
        yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        prizeCol.setCellValueFactory(new PropertyValueFactory<>("prizes"));
        Platform.runLater(() -> {
            try {
                LoadMoviesFromServer();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hiba!");
                alert.setHeaderText("Hiba történt az adatok lekérdezése során!");
                alert.setContentText(e.getMessage());

                    alert.showAndWait();
                    Platform.exit();

                }
        });

    }

    private void LoadMoviesFromServer() throws IOException {
        Response response  = RequestHandler.get(App.BASE_URL);
        String content = response.getContent();
        Gson converter = new Gson();
        Movie[] movies = converter.fromJson(content, Movie[].class);
        moviesTable.getItems().clear();
        for (Movie movie: movies){
            moviesTable.getItems().add(movie);
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
        Movie selected = moviesTable.getSelectionModel().getSelectedItem();
        if (selected == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Figyelem!");
            alert.setHeaderText("A törléshez kérem válasszon ki egy elemet!");
            alert.showAndWait();
            return;
        }
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Figyelem!");
        confirmation.setHeaderText("Biztosan törölni szeretné?");
        Optional<ButtonType> optionalButtonType = confirmation.showAndWait();
        if (optionalButtonType.isPresent() && optionalButtonType.get().equals(ButtonType.OK)
        ) {
            String url = App.BASE_URL + "/" + selected.getId();
            try {
                RequestHandler.delete(url);
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hiba!");
                alert.setHeaderText("Nem sikerült csatlakozni a szerverhez!");
                alert.showAndWait();
            }
        }
    }
}