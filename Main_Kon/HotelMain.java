package com.example.software_technology;

import java.sql.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private static Scene[] scenes = new Scene[21];

    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String STATUS;
    private static String ID;
    private static String EMAIL;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteliday_db", "root", "root");
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
            new FXMLLoader(HotelMain.class.getResource("day_off.fxml")),
            new FXMLLoader(HotelMain.class.getResource("room_info.fxml")),
            new FXMLLoader(HotelMain.class.getResource("AdminMessageChoice.fxml")),
            new FXMLLoader(HotelMain.class.getResource("AnnounceList.fxml")),
            new FXMLLoader(HotelMain.class.getResource("Admin_Message.fxml")),
            new FXMLLoader(HotelMain.class.getResource("AdminMessageList.fxml")),
            new FXMLLoader(HotelMain.class.getResource("employee.fxml")),
            new FXMLLoader(HotelMain.class.getResource("AnnounceAdminSelect.fxml")),
            new FXMLLoader(HotelMain.class.getResource("Announce.fxml")),
            new FXMLLoader(HotelMain.class.getResource("MessageChoice.fxml")),
            new FXMLLoader(HotelMain.class.getResource("MessageList.fxml")),
            new FXMLLoader(HotelMain.class.getResource("Message.fxml")),
            new FXMLLoader(HotelMain.class.getResource("AdminAnnounceList.fxml"))};


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
            scenes[9] = new Scene(loaders[9].load());
            scenes[10] = new Scene(loaders[10].load());
            scenes[11] = new Scene(loaders[11].load());
            scenes[12] = new Scene(loaders[12].load());
            scenes[13] = new Scene(loaders[13].load());
            scenes[14] = new Scene(loaders[14].load());
            scenes[15] = new Scene(loaders[15].load());
            scenes[16] = new Scene(loaders[16].load());
            scenes[17] = new Scene(loaders[17].load());
            scenes[18] = new Scene(loaders[18].load());
            scenes[19] = new Scene(loaders[19].load());
            scenes[20] = new Scene(loaders[20].load());

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

    public static String getEmail() {
        return EMAIL;
    }

    public static void setEmail(String Email) {
        HotelMain.EMAIL = Email;
    }

    public static ObservableList<EmployeeMessage> getMessages(){
        ObservableList<EmployeeMessage> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from employee_messages where receiver_email= ? ");
            ps.setString(1, getEmail());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new EmployeeMessage(Integer.parseInt(rs.getString("message_id")), rs.getString("sender_email"), rs.getString("receiver_email"), rs.getString("title"), rs.getString("content")));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static ObservableList<AdminMessage> getAdminMessages(){
        ObservableList<AdminMessage> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from admin_messages where receiver_email= ? ");
            ps.setString(1, getEmail());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new AdminMessage(Integer.parseInt(rs.getString("message_id")), rs.getString("sender_email"), rs.getString("receiver_email"), rs.getString("title"), rs.getString("content")));
            }
        } catch (Exception e) {
        }
        return list;
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
