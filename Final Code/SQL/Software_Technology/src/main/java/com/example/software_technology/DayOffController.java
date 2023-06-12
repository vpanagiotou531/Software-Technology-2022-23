package com.example.software_technology;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DayOffController implements Initializable {

    private Stage primary_stage = HotelMain.get_stage();
    private Connection connection = HotelMain.get_connection();

    @FXML
    private ChoiceBox<String> employees;
    @FXML
    private DatePicker calendar;

    @FXML
    void getEmployee(MouseEvent event) {
        String employee = employees.getSelectionModel().getSelectedItem();
        System.out.println(employee);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String sql1 = "SELECT FIRST_NAME,LAST_NAME FROM EMPLOYEE";
        Stage primary_stage = HotelMain.get_stage();
        Connection connection = HotelMain.get_connection();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql1);
            ResultSet resultset = statement.executeQuery();


            while (resultset.next()){
                employees.getItems().add(resultset.getString("FIRST_NAME")+" "+resultset.getString("LAST_NAME"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void back_button() throws IOException, SQLException{

        HotelMain.change_scene("admin.fxml"); // ειχα βαλει αρχικα 0
    }

    @FXML
    void day_off_submit() throws IOException, SQLException {

        try {
            // Create a database connection
            Connection connection =HotelMain.get_connection();
            System.out.println(employees.getValue());
            System.out.println(calendar.getValue());

            String[] parts = employees.getValue().split(" ");

            // Accessing the split parts
            String part1 = parts[0];
            String part2 = parts[1];

            String sqlQuery = "UPDATE employee SET DAYOFF = 1 WHERE FIRST_NAME = ? and LAST_NAME = ?";
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, parts[0]); // Set the value for the second parameter placeholder
            statement.setString(2, parts[1]); // Set the value for the second parameter placeholder
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}