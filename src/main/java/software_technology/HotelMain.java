package com.example.software_technology;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class HotelMain extends Application {

    static FXMLLoader fxmlLoader1 = new FXMLLoader(HotelMain.class.getResource("login.fxml"));
    static FXMLLoader fxmlLoader2 = new FXMLLoader(HotelMain.class.getResource("register.fxml"));
    static Stage login_stage;
    static Scene login_scene;
    static Scene register_scene;

    static {
        try {
            login_scene = new Scene(fxmlLoader1.load(), 500, 420);
            register_scene = new Scene(fxmlLoader2.load(), 500, 420);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {

        login_stage = stage;

        stage.setScene(login_scene);
        stage.show();
    }

    public static void change_register() throws IOException {

        login_stage.setScene(register_scene);
        login_stage.show();
    }

    public static void change_login() throws IOException {

        login_stage.setScene(login_scene);
        login_stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

