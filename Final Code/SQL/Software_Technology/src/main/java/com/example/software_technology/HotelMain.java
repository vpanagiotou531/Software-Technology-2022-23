package com.example.software_technology;

import java.sql.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            scenes.put("AdminMessageChoice.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("AdminMessageChoice.fxml"))).load()));//7
            scenes.put("AnnounceList.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("AnnounceList.fxml"))).load()));//7
            scenes.put("Admin_Message.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("Admin_Message.fxml"))).load()));//7
            scenes.put("AdminMessageList.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("AdminMessageList.fxml"))).load()));//7
            scenes.put("AnnounceAdminSelect.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("AnnounceAdminSelect.fxml"))).load()));//7
            scenes.put("Announce.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("Announce.fxml"))).load()));//7
            scenes.put("MessageChoice.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("MessageChoice.fxml"))).load()));//7
            scenes.put("MessageList.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("MessageList.fxml"))).load()));//7
            scenes.put("Message.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("Message.fxml"))).load()));//7
            scenes.put("available_rooms.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("available_rooms.fxml"))).load()));//7
            scenes.put("ratingPage.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("ratingPage.fxml"))).load()));//7
            scenes.put("reservation.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("reservation.fxml"))).load()));//7
            scenes.put("AdminAnnounceList.fxml",new Scene((new FXMLLoader(HotelMain.class.getResource("AdminAnnounceList.fxml"))).load()));

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

    public static ObservableList<EmployeeMessage> getMessages(String email){    //Function to Get Employee-Employee Messages from Database
        ObservableList<EmployeeMessage> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from employee_message where receiver_email= ?"); //
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new EmployeeMessage(Integer.parseInt(rs.getString("message_id")),
                        rs.getString("sender_email"),
                        rs.getString("receiver_email"),
                        rs.getString("title"), rs.getString("content")));
            }
        } catch (Exception e) {
        }
        System.out.println("Inbox Reading: "+email);
        return list;
    }
    public static ObservableList<AdminMessage> getAdminMessages(String email){  //Function to Get Admin-Employee Messages from Database
        ObservableList<AdminMessage> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from admin_message where receiver_email= ?");  //
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new AdminMessage(Integer.parseInt(rs.getString("message_id")), rs.getString("sender_email"), rs.getString("receiver_email"), rs.getString("title"), rs.getString("content")));
            }
        } catch (Exception e) {
        }
        System.out.println("Inbox Reading: "+email);
        return list;
    }

    public static ObservableList<Announcement> getAnnouncements(){
        ObservableList<Announcement> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from announcement");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Announcement(Integer.parseInt(rs.getString("announcement_id")), rs.getString("title"), rs.getString("content")));
            }
        } catch (Exception e) {
        }
        System.out.println("Announcement Reading...");
        return list;
    }

    public static ObservableList<Announcement> getAdminAnnouncements(){
        ObservableList<Announcement> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from announcement");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(new Announcement(Integer.parseInt(rs.getString("announcement_id")), rs.getString("title"), rs.getString("content")));
            }
        } catch (Exception e) {
        }
        System.out.println("Announcement Reading...");
        return list;
    }


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
