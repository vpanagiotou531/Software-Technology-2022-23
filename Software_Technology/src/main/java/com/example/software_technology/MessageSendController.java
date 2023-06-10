package com.example.software_technology;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class MessageSendController {

    @FXML
    public void send_message(ActionEvent actionEvent) throws IOException {
        MessageChoice.change_scene(1);
    }
    @FXML
    public void received_messages(ActionEvent actionEvent) throws IOException {
        MessageChoice.change_scene(3);
    }
    @FXML
    public void back_to_menu(ActionEvent actionEvent) throws IOException {
        MessageChoice.change_scene(2);
    }
    @FXML
    public void send_Message(ActionEvent actionEvent) throws IOException {
        MessageChoice.change_scene(4);
    }

}