package com.example.software_technology;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onLabelMouseClicked() {
        welcomeText.setText("Label clicked.");
    }

    @FXML
    protected void onHelloButtonDragDetectedProperty() {
        welcomeText.setText("Drag detected.");
    }

    @FXML
    protected void newScene() throws IOException {
        HelloApplication.change_stage();
    }
}