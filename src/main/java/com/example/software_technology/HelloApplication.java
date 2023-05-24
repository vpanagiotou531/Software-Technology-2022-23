package com.example.software_technology;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class HelloApplication extends Application {

    public FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    public static FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("new.fxml"));

    public static Stage primary_stage;

    @Override
    public void start(Stage stage) throws IOException {


        primary_stage = stage;
        Scene scene = new Scene(fxmlLoader1.load(), 320, 240);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void change_stage() throws IOException {
        Scene scene = new Scene(fxmlLoader2.load(), 320, 240);

        primary_stage.setTitle("Hello!");
        primary_stage.setScene(scene);
        primary_stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}