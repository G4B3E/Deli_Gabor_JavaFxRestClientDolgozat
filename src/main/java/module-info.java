module com.example.deli_gabor_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.deli_gabor_javafxrestclientdolgozat to javafx.fxml,com.google.gson;
    exports com.example.deli_gabor_javafxrestclientdolgozat;
}