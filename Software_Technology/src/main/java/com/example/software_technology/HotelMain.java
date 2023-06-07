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

    public static void fill(){
        //AnchorPane root = (AnchorPane) primary_stage.getScene().getRoot(); // Use HBox for horizontal boxes or VBox for vertical boxes
        primary_stage.getScene().setRoot(new GridPane());
        GridPane gridPane = (GridPane) primary_stage.getScene().getRoot();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int numRows = 3;
        int numCols = 4;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                Rectangle box = new Rectangle(100, 100); // Create a rectangle as a box
                box.setFill(Color.LIGHTBLUE);
                box.setStroke(Color.BLACK);
                box.setStrokeWidth(2);

                gridPane.add(box, col, row); // Add the box to the GridPane
            }
        }
    }

    /*public static void login(String email, String pass) throws IOException, SQLException {

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

                primary_stage.setScene(scenes[i+2]);
                primary_stage.show();
                break;
            }
        }

    }*/

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

