package com.example.software_technology;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnnounceSendController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/HOTELIDAY_DB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    @FXML
    private  TextField title;
    @FXML
    private TextArea textArea;


    @FXML
    public void an_back_to_menu(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(17);
    }

    @FXML
    public void an_send_Announcement(ActionEvent actionEvent) throws IOException {
        String scontent = textArea.getText();
        String stitle = title.getText();

        try {
            // Create a database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare the SQL statement
            String sql = "INSERT INTO announcement (ANNOUNCEMENT_ID, TITLE, CONTENT) VALUES (DEFAULT, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, stitle);
            statement.setString(2, scontent);

            // Execute the statement
            statement.executeUpdate();

            // Close resources
            statement.close();
            connection.close();

            System.out.println("Announce Uploaded!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HotelMain.change_scene(17);
    }

}
