module com.example.deli_gabor_javafxrestclientdolgozat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.deli_gabor_javafxrestclientdolgozat to javafx.fxml;
    exports com.example.deli_gabor_javafxrestclientdolgozat;
}