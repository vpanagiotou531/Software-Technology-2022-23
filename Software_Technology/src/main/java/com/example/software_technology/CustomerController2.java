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
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


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
import java.time.LocalDate;
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
    private Menu available_rooms;


    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label selection;

    @FXML
    private TextField adults;

    @FXML
    private TextField children;

    @FXML
    private CheckBox meal;

    @FXML
    private CheckBox pool;

    @FXML
    private CheckBox tennisCourt;

    @FXML
    private DatePicker checkInDate;

    @FXML
    private DatePicker checkOutDate;

    @FXML
    private Button backButton2;


    @FXML
    public void button_backButton2(ActionEvent actionevent) throws IOException {
        Connection connection = HotelMain.get_connection();
        Stage primary_stage = HotelMain.get_stage();
        Scene[] scenes = HotelMain.get_scenes();
        primary_stage.setScene(scenes[2]);
        primary_stage.show();
    }


    @Override  // Ορισμός περιεχομένου μέσα στη λίστα τύπων δωματίου
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll("ECONOMIC", "NORMAL", "SUITE");
    }

    @FXML
    private void button_showButton() throws IOException, SQLException {

        String choiceBox1 = choiceBox.getValue();
        String adultSelection = adults.getText();
        String childrenSelection = children.getText();
        String poolSelection = pool.getText();
        String mealSelection = meal.getText();
        String tennisCourtSelection = tennisCourt.getText();
        LocalDate checkInDateSelection = checkInDate.getValue();
        LocalDate checkOutDateSelection = checkOutDate.getValue();

        Connection connection = HotelMain.get_connection();
        Stage primary_stage = HotelMain.get_stage();
        Scene[] scenes = HotelMain.get_scenes();
        primary_stage.setScene(scenes[11]);
        primary_stage.show();
        String ID = HotelMain.getID();
        System.out.println(ID);


    }
}











