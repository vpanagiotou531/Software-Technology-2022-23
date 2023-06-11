package com.example.software_technology;

import javafx.event.ActionEvent;

import java.io.IOException;

public class AnnounceAdminSelectController {
    public void list_announcements(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(20);
    }

    public void send_announce(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(16);
    }

    public void back_to_admin_menu(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(3);
    }
}
