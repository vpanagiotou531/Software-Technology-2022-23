package com.example.software_technology;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.net.URL;
import java.io.IOException;
import java.sql.*;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;


import java.sql.PreparedStatement;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;



 public class CustomerController {

     @FXML
     private Menu reservation;
     private Stage room_stage;
     private Stage primary_stage = HotelMain.get_stage();
     private Connection connection = HotelMain.get_connection();

     @FXML
     private Menu RatingPage;

     @FXML
     private TextField RatingNumber;

     @FXML Button button_backButton;

     @FXML
     private void button_submitRating() throws IOException, SQLException {
         String RatingNumber1 = RatingNumber.getText();
         Connection connection = HotelMain.get_connection();
         Stage primary_stage = HotelMain.get_stage();
         HotelMain.change_scene("customer.fxml");
         primary_stage.show();
         String ID = HotelMain.getID();
         System.out.println(ID);
         String sql1 = "INSERT INTO FEEDBACK (CUSTOMER_ID, STARS_RATING, FEEDBACK_STATUS) VALUES (" + ID + "," + RatingNumber1 + ", DEFAULT)";

         PreparedStatement statement = connection.prepareStatement(sql1);
         statement.executeUpdate();
     }

      @FXML
     public void button_backButton(ActionEvent actionevent) throws IOException {
         HotelMain.change_scene("customer.fxml");
     }

     @FXML
     protected void change_scene_reservation() throws IOException {
         System.out.println("here1");
         HotelMain.change_scene("reservation.fxml");
     }
     @FXML
     protected void change_scene_ratingPage() throws IOException {
         System.out.println("here2");
         HotelMain.change_scene("ratingPage.fxml");
     }
 }

