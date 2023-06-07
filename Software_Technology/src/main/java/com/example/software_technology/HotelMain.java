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

public class HotelMain extends Application {
    private static Connection connection;
    private static Stage primary_stage;
    private static Scene[] scenes = new Scene[20];


    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteliday_db", "root", "tinos");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static FXMLLoader[] loaders = {new FXMLLoader(HotelMain.class.getResource("login.fxml")),
            new FXMLLoader(HotelMain.class.getResource("register.fxml")),
            new FXMLLoader(HotelMain.class.getResource("customer.fxml")),
            new FXMLLoader(HotelMain.class.getResource("admin.fxml")),
            new FXMLLoader(HotelMain.class.getResource("employee.fxml")),
            new FXMLLoader(HotelMain.class.getResource("staff_check.fxml")),
            new FXMLLoader(HotelMain.class.getResource("room_avail.fxml")),
            new FXMLLoader(HotelMain.class.getResource("order.fxml")),
            new FXMLLoader(HotelMain.class.getResource("day_off.fxml"))};


    static {
        try {
            scenes[0] = new Scene(loaders[0].load());
            scenes[1] = new Scene(loaders[1].load());
            scenes[2] = new Scene(loaders[2].load());
            scenes[3] = new Scene(loaders[3].load());
            scenes[4] = new Scene(loaders[4].load());
            scenes[5] = new Scene(loaders[5].load());
            scenes[6] = new Scene(loaders[6].load());
            scenes[7] = new Scene(loaders[7].load());
            scenes[8] = new Scene(loaders[8].load());

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
