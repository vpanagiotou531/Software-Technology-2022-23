package com.example.software_technology;

import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HotelMain extends Application {
    private static Connection connection;
    private static Stage primary_stage;
    private static Map<String, Scene> scenes = new HashMap<>();

    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String STATUS;
    private static String ID;
    private static String EMAIL;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteliday_db", "root", "tinos");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            scenes.put("login.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("login.fxml"))).load()));//0
            scenes.put("register.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("register.fxml"))).load()));//1
            scenes.put("customer.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("customer.fxml"))).load()));//2
            scenes.put("admin.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("admin.fxml"))).load()));//2
            scenes.put("employee.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("employee.fxml"))).load()));//3
            scenes.put("staff_check.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("staff_check.fxml"))).load()));//4
            scenes.put("room_avail.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("room_avail.fxml"))).load()));//5
            scenes.put("order.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("order.fxml"))).load()));//6
            scenes.put("day_off.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("day_off.fxml"))).load()));//7

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getSTATUS() {
        return STATUS;
    }

    public static void setSTATUS(String STATUS) {
        HotelMain.STATUS = STATUS;
    }

    public static String getLastName() {
        return LAST_NAME;
    }

    public static void setLastName(String lastName) {
        LAST_NAME = lastName;
    }

    public static String getFirstName() {
        return FIRST_NAME;
    }

    public static void setFirstName(String firstName) {
        FIRST_NAME = firstName;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        HotelMain.ID = ID;
    }

    public static String getEmail() {return EMAIL; }

    public static void setEmail(String Email) {HotelMain.EMAIL = Email; }

    @Override
    public void start(Stage stage) throws IOException, SQLException {

        primary_stage = stage;
        primary_stage.setResizable(true);
        stage.setScene(scenes.get("login.fxml"));
        stage.show();
    }

    public static void change_scene(String i)throws IOException {

        primary_stage.setScene(scenes.get(i));
        primary_stage.show();
    }

    public static Connection get_connection(){
        return connection;
    }

    public static Stage get_stage(){
        return primary_stage;
    }

    public static Map<String, Scene> get_scenes(){
        return scenes;
    }

    public static void main(String[] args) {
        launch();
    }
}
