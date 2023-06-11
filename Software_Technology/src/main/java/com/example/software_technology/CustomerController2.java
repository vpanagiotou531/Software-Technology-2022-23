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
    protected void change_scene_available_rooms() throws IOException, SQLException {

        Stage primary_stage = HotelMain.get_stage();
        Connection connection = HotelMain.get_connection();

        HotelMain.change_scene(11);
        primary_stage.getScene().setRoot(new GridPane());

        GridPane gridPane = (GridPane) primary_stage.getScene().getRoot();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        String sql2 = "SELECT * FROM ROOM WHERE ROOM_TYPE = 'choiceBox1' AND ROOM_STATUS = 'GREEN'";
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql2);

        int col = 1;

        for (int row = 0; resultset.next(); ) {

            if (col == 1)
                row++;
            Rectangle box = new Rectangle(100, 100); // Create a rectangle as a box
            box.setId(Integer.toString((row - 1) * 4 + col));

            System.out.println(resultset.getString("ROOM_STATUS")+"  " +"RED");

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









