package com.example.software_technology;

import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MessageChoice extends Application {
    private static Connection connection;
    private static Stage primary_stage;
    private static Scene[] scenes = new Scene[20];


    /*static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteliday_db", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    private static FXMLLoader[] loaders = {new FXMLLoader(MessageChoice.class.getResource("MessageChoice.fxml")),
            new FXMLLoader(MessageChoice.class.getResource("AnnounceList.fxml")),
            new FXMLLoader(MessageChoice.class.getResource("Message.fxml")),
            new FXMLLoader(MessageChoice.class.getResource("MessageList.fxml")),
            new FXMLLoader(MessageChoice.class.getResource("employee.fxml"))};


    static {
        try {
            scenes[0] = new Scene(loaders[0].load());
            scenes[1] = new Scene(loaders[1].load());
            scenes[2] = new Scene(loaders[2].load());
            scenes[3] = new Scene(loaders[3].load());
            scenes[4] = new Scene(loaders[4].load());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void start(Stage stage) throws IOException, SQLException {

        primary_stage = stage;
        primary_stage.setResizable(true);
        stage.setScene(scenes[0]);
        stage.show();
    }

    public static void change_scene(int i)throws IOException {

        primary_stage.setScene(scenes[i]);
        primary_stage.show();
    }

    public static Connection get_connection(){
        return connection;
    }

    public static Stage get_stage(){
        return primary_stage;
    }

    public static Scene[] get_scenes(){
        return scenes;
    }



    public static void main(String[] args) {
        launch();
    }
}