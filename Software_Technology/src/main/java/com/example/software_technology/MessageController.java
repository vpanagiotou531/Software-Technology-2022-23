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
        HotelMain.change_scene("Message.fxml");
    }
    @FXML
    public void received_messages(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("MessageList.fxml");
    }
    @FXML
    public void back_to_employee_menu(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("employee.fxml");
    }
    @FXML
    public void show_announcements(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("AnnounceList.fxml");
    }
}