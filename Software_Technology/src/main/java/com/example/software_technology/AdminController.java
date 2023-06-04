package com.example.software_technology;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminController {
    @FXML
    private MenuItem MenuItemStaff;
    @FXML
    private MenuItem MenuItemRooms;
    @FXML
    private MenuItem MenuItemOrders;
    @FXML
    private MenuItem MenuItemWork;
    @FXML
    protected void change_scene_Staff() throws IOException {
        HotelMain.change_scene(5);
    }
    @FXML
    protected void change_scene_Rooms() throws IOException {
        HotelMain.change_scene(6);
        HotelMain.fill();
    }
    @FXML

    protected void change_scene_Orders() throws IOException {
        HotelMain.change_scene(7);
    }
    @FXML
    protected void change_scene_Work() throws IOException {
        HotelMain.change_scene(8);
    }

}
