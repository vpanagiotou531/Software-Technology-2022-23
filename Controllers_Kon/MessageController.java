package com.example.software_technology;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class MessageController {

    @FXML
    public void send_message(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(19);
    }
    @FXML
    public void received_messages(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(18);
    }
    @FXML
    public void back_to_employee_menu(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(14);
    }
    @FXML
    public void show_announcements(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(11);
    }
}