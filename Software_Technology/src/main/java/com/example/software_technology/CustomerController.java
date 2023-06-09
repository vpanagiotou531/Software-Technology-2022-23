package com.example.software_technology;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;
import java.sql.*;

public class CustomerController {


    @FXML
    private TextField RatingNumber;

    @FXML
    private Menu RatingPage;

    @FXML
    private Menu reservation;

    @FXML
    protected void change_scene_reservation() throws IOException {

        HotelMain.change_scene(10);
    }

    @FXML
    protected void change_scene_ratingPage() throws IOException {

        HotelMain.change_scene(9);
    }

    @FXML
    private void button_submitRating() throws IOException, SQLException {
        String RatingNumber1 = RatingNumber.getText();
        Connection connection = HotelMain.get_connection();
        Stage primary_stage = HotelMain.get_stage();
        Scene[] scenes = HotelMain.get_scenes();
        primary_stage.setScene(scenes[2]);
        primary_stage.show();


        String[] sql1 = {"INSERT INTO FEEDBACK (FEEDBACK_ID, CUSTOMER_ID, STARS_RATING, FEEDBACK_STATUS) VALUES (DEFAULT, ID, RatingNumber1, DEFAULT)"};


    }
}

/*
        String RatingNumber = RatingNumber.getText();

    */



     /*



     /* @FXML
    protected void change_scene_feedback() throws IOException, SQLException {


        HotelMain.change_scene(9);
        Stage primary_stage = HotelMain.get_stage();

        Stage room_stage = new Stage();
        Connection connection = HotelMain.get_connection();  */

        /*
        room_stage.setScene(new Scene(new FXMLLoader(HotelMain.class.getResource("room_info.fxml")).load()));
        primary_stage.getScene().setRoot(new GridPane());


        String sql = "SELECT * FROM room ";
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);

        int col = 1;

        for (int row = 0; resultset.next(); ) {

            if(col==1)
                row++;
            Rectangle box = new Rectangle(100, 100); // Create a rectangle as a box

            System.out.println(resultset.getString("ROOM_STATUS")+"  " +"RED");

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
            nameText.setWrappingWidth(100); // Set the width of the text box
            nameText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            nameText.setTextAlignment(TextAlignment.CENTER);
            nameText.setMouseTransparent(true);

            box.setStroke(Color.BLACK);
            box.setStrokeWidth(2);

            box.setOnMouseClicked(event -> {
                room_info();
            });

            gridPane.add(box, col, row+1); // Add the box to the GridPane
            gridPane.add(nameText, col, row + 1);
            col = (col%4) + 1;
        }
    }
}
*/


