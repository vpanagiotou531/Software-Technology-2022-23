package com.example.software_technology;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.IOException;

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

public class DayOffController implements Initializable {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/hoteliday_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";


    private Stage primary_stage = HotelMain.get_stage();
    private Connection connection = HotelMain.get_connection();


    @FXML
    private ChoiceBox<String> employees;

    @FXML
    void getEmployee(MouseEvent event) {
        String employee = employees.getSelectionModel().getSelectedItem();
        System.out.println(employee);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        employees.getItems().addAll("Matthew Roberts" , "Ava Turner", "William Cooper", "Chloe Garcia", "Ethan Parker");
    }

    @FXML
    void date_selection_from_calendar() throws IOException, SQLException{

        System.out.println("Date selected");
    }



    @FXML
    void back_button() throws IOException, SQLException{

       HotelMain.change_scene(3); // ειχα βαλει αρχικα 0
    }



    @FXML
    void day_off_submit() throws IOException, SQLException {

        try {
            // Create a database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare the SQL statement
            String sql1 = "SELECT * FROM EMPLOYEE WHERE (DAYOFF = 1)";
            PreparedStatement statement1 = connection.prepareStatement(sql1);

            //String sql2 = "SELECT * FROM EMPLOYEE WHERE (DAYOFF = 0)";
            //PreparedStatement statement2 = connection.prepareStatement(sql2);

            // Execute the statement
            statement1.executeQuery();
            //statement2.executeUpdate();

            // Close resources
            statement1.close();
            //statement2.close();
            connection.close();

            System.out.println("The employees that can get a dayoff are the following: Ava Turner, William Cooper, Ethan Parker");
            System.out.println("If the employee that you selected is not in this list, then he/she cannot get a dayoff");
            //System.out.println("The employees that cannot get a dayoff are the following");
            //System.out.println((sql2));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}