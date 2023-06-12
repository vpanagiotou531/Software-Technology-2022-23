package com.example.software_technology;

import javafx.event.ActionEvent;

import java.io.IOException;

public class AnnounceAdminSelectController {
    public void list_announcements(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("AdminAnnounceList.fxml");
    }

    public void send_announce(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("Announce.fxml");
    }

    public void back_to_admin_menu(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene("admin.fxml");
    }
}
