package com.example.software_technology;

import javafx.fxml.FXML;

import java.io.IOException;

public class HotelController {

    @FXML
    protected void change_scene_register() throws IOException {
        HotelMain.change_register();
    }

    @FXML
    protected void change_scene_login() throws IOException {
        HotelMain.change_login();
    }
}