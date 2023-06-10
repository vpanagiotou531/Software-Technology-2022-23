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



public class CustomerController2 implements Initializable {


    private Stage room_stage;
    private Stage primary_stage = HotelMain.get_stage();
    private Connection connection = HotelMain.get_connection();


    @FXML
    private Menu reservation;

    @FXML
    protected void change_scene_reservation() throws IOException {

        HotelMain.change_scene(10);
    }

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label selection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll("ECONOMIC", "NORMAL", "SUITE");}

}











