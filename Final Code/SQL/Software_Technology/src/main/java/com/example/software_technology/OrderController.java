package com.example.software_technology;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    /*private static final String DB_URL = "jdbc:mysql://localhost:3306/hoteliday_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";*/


    private Stage primary_stage = HotelMain.get_stage();
    private Connection connection = HotelMain.get_connection();

    @FXML
    private ChoiceBox<String> products;

    @FXML
    private ChoiceBox<String> quantity;

    @FXML
    void getProducts(MouseEvent event) {
        String product = products.getSelectionModel().getSelectedItem();
        System.out.println(products);
    }

    @FXML
    void getQuantity(MouseEvent event)
    {
        String quantities = quantity.getSelectionModel().getSelectedItem();
        System.out.println(quantities);
    }

    /*@FXML
    public void change_scene_Order_Confirmation() throws IOException {

        HotelMain.change_scene(10);
    }*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        products.getItems().addAll("chroline" , "paper", "klinex", "sweep", "bucket");

        quantity.getItems().addAll("0","1", "2", "3", "4", "5", "6", "7", "8", "9","10");
    }

    @FXML
    void button_send_order() throws IOException, SQLException{

        try {
            // Create a database connection
            //Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Connection connection =HotelMain.get_connection();

            // Prepare the SQL statement
            String sql = "INSERT INTO ORDERS (ORDER_ID) VALUES (DEFAULT)";
            PreparedStatement statement = connection.prepareStatement(sql);


            // Execute the statement
            statement.executeUpdate();

            // Close resources
            statement.close();

            System.out.println("Order sent successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void back_button() throws IOException, SQLException{

        HotelMain.change_scene("admin.fxml");
    }

        /*
        // Connection connection = HotelMain.get_connection(DB_URL, DB_USER, DB_PASSWORD);
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        Stage primary_stage = HotelMain.get_stage();
        Scene[] scenes = HotelMain.get_scenes();
        primary_stage.setScene(scenes[3]);
        primary_stage.show();

        HotelMain.order_submit();

        String sql = "INSERT INTO ORDERS (ORDER_ID) VALUES (DEFAULT)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        */

}