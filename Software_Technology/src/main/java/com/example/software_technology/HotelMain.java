package com.example.software_technology;

import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HotelMain extends Application {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteliday_db", "root", "tinos");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stage login_stage;

    private static FXMLLoader[] loaders = {new FXMLLoader(HotelMain.class.getResource("login.fxml")),
            new FXMLLoader(HotelMain.class.getResource("register.fxml")),
            new FXMLLoader(HotelMain.class.getResource("customer.fxml")),
            new FXMLLoader(HotelMain.class.getResource("admin.fxml")),
            new FXMLLoader(HotelMain.class.getResource("employee.fxml")),
            new FXMLLoader(HotelMain.class.getResource("staff_check.fxml")),
            new FXMLLoader(HotelMain.class.getResource("room_avail.fxml")),
            new FXMLLoader(HotelMain.class.getResource("order.fxml")),
            new FXMLLoader(HotelMain.class.getResource("day_off.fxml"))};

    private static Scene[] scenes = new Scene[20];

    static {
        try {
            scenes[0] = new Scene(loaders[0].load(), 500, 420);
            scenes[1] = new Scene(loaders[1].load(), 500, 420);
            scenes[2] = new Scene(loaders[2].load(), 500, 420);
            scenes[3] = new Scene(loaders[3].load(), 500, 420);
            scenes[4] = new Scene(loaders[4].load(), 500, 420);
            scenes[5] = new Scene(loaders[5].load(), 500, 420);
            scenes[6] = new Scene(loaders[6].load(), 500, 420);
            scenes[7] = new Scene(loaders[7].load(), 500, 420);
            scenes[8] = new Scene(loaders[8].load(), 500, 420);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void start(Stage stage) throws IOException, SQLException {

        login_stage = stage;
        stage.setScene(scenes[0]);
        stage.show();
    }

    public static void change_scene(int i)throws IOException {

        login_stage.setScene(scenes[i]);
        login_stage.show();
    }

    public static void login(String email, String pass) throws IOException, SQLException {

        System.out.println(email + " " + pass);

        String[] sql = {"SELECT * FROM customer where email = ? and password = ?"
                , "SELECT * FROM admin where email = ? and password = ?"
                , "SELECT * FROM employee where email = ? and password = ?"};

        for(int i = 0; i < 3; i++){
            PreparedStatement statement = connection.prepareStatement(sql[i]);
            statement.setString(1, email); // Set the value for the second parameter placeholder
            statement.setString(2, pass); // Set the value for the second parameter placeholder
            ResultSet resultset = statement.executeQuery();

            if (!resultset.next()) {
                System.out.println("ResultSet is empty.");
            } else {
                // ResultSet is not empty, process the data
                do {
                    String firstName = resultset.getString("FIRST_NAME");
                    String lastName = resultset.getString("LAST_NAME");
                    String mail = resultset.getString("EMAIL");
                    String password = resultset.getString("PASSWORD");

                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Email: " + mail);
                    System.out.println("Password: " + password);
                    System.out.println("--------------------");
                } while (resultset.next());

                login_stage.setScene(scenes[i+2]);
                login_stage.show();
                break;
            }
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
