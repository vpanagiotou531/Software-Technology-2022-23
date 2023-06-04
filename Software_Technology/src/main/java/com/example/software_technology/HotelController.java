package com.example.software_technology;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class HotelController {

    @FXML
    private  TextField email_field;
    @FXML
    private  PasswordField pass_field;
    @FXML
    protected void change_scene_register() throws IOException {
        HotelMain.change_register();
    }
    @FXML
    protected void change_scene_login() throws IOException {
        HotelMain.change_login();
    }
    @FXML
    protected void button_login() throws IOException, SQLException {

        HotelMain.login(email_field.getText() ,pass_field.getText());
    }
}