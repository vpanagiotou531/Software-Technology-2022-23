package com.example.software_technology;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class AdminMessageController {

    @FXML
    public void a_send_message(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("Admin_Message.fxml");
    }
    @FXML
    public void a_received_messages(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("AdminMessageList.fxml");
    }
    @FXML
    public void a_back_to_employee_menu(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("admin.fxml");
    }
    @FXML
    public void a_show_announcements(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("AdminAnnounceList.fxml");
    }
}