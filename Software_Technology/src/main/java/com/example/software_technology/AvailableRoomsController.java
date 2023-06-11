package com.example.software_technology;

import javafx.fxml.FXML;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class AvailableRoomsController {

    @FXML
    private Menu available_rooms;

    private Stage primary_stage = HotelMain.get_stage();
    private Connection connection = HotelMain.get_connection();

    @FXML
    protected void change_scene_available_rooms() throws SQLException, IOException {
        Stage primary_stage = HotelMain.get_stage();
        Connection connection = HotelMain.get_connection();

        HotelMain.change_scene(11);
        primary_stage.getScene().setRoot(new GridPane());

        GridPane gridPane = (GridPane) primary_stage.getScene().getRoot();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        String sql2 = "SELECT * FROM ROOM";
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql2);

    int col = 1;

        for (int row = 0; resultset.next(); ) {

        if (col == 1)
            row++;
        Rectangle box = new Rectangle(100, 100); // Create a rectangle as a box
        box.setId(Integer.toString((row - 1) * 4 + col));

            if(resultset.getString("ROOM_STATUS").equalsIgnoreCase("RED")){
                box.setFill(Color.RED);
            }
            else if (resultset.getString("ROOM_STATUS").equalsIgnoreCase("YELLOW")) {
                box.setFill(Color.YELLOW);
            }
            else{
                box.setFill(Color.GREEN);
            }

        String name = resultset.getString("ROOM_ID"); // Replace with the actual name you want to display
        Text nameText = new Text(name);
        nameText.setId(Integer.toString((row - 1) * 4 + col));
        nameText.setWrappingWidth(100); // Set the width of the text box
        nameText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        nameText.setTextAlignment(TextAlignment.CENTER);
        nameText.setMouseTransparent(true);

        box.setStroke(Color.BLACK);
        box.setStrokeWidth(2);


        gridPane.add(box, col, row + 1); // Add the box to the GridPane
        gridPane.add(nameText, col, row + 1);
        col = (col % 4) + 1;
        }

        }

}



