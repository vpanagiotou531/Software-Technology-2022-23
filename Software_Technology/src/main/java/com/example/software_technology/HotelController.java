package com.example.software_technology;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelController {

    @FXML
    private  TextField email_field;
    @FXML
    private  PasswordField pass_field;
    @FXML
    protected void change_scene_register() throws IOException {
        HotelMain.change_scene(1);
    }
    @FXML
    protected void change_scene_login() throws IOException {
        HotelMain.change_scene(0);
    }
    @FXML
    protected void button_login() throws IOException, SQLException {

        String email = email_field.getText();
        String pass = pass_field.getText();
        Connection connection = HotelMain.get_connection();
        Stage primary_stage = HotelMain.get_stage();
        Scene[] scenes = HotelMain.get_scenes();

        primary_stage.setScene(scenes[3]);
        primary_stage.show();

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

                    HotelMain.setFirstName(firstName);
                    HotelMain.setLastName(lastName);

                    if(i == 0){
                        HotelMain.setSTATUS("CUSTOMER_ID");
                        HotelMain.setLastName(lastName);
                    }

                    else if(i == 1){
                        HotelMain.setSTATUS("ADMIN_ID");
                        HotelMain.setLastName(lastName);
                    }

                    else{
                        HotelMain.setSTATUS("employee");
                        HotelMain.setLastName("EMPLOYEE_ID");
                    }

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
    }
}