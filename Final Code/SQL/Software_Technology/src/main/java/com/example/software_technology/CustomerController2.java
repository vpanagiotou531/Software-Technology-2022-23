package com.example.software_technology;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerController2 implements Initializable {


    private Stage primary_stage = HotelMain.get_stage();
    private Connection connection = HotelMain.get_connection();

    @FXML
    protected void change_scene_reservation() throws IOException {

        HotelMain.change_scene("reservation.fxml");
    }

    @FXML
    private ChoiceBox<String> choiceBox;

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
        HotelMain.change_scene("customer.fxml");
    }

    @Override  // Ορισμός περιεχομένου μέσα στη λίστα τύπων δωματίου
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll("ECONOMIC", "NORMAL", "SUITE");
    }

    @FXML
    private void button_showButton() throws IOException, SQLException {

        //HotelMain.change_scene("reservation.fxml");
        Stage primary_stage = HotelMain.get_stage();
        Connection connection = HotelMain.get_connection();
        String adultSelection = adults.getText();
        String childrenSelection = children.getText();
        String choiceBox1 = choiceBox.getValue();
        boolean mealSelection = meal.isSelected();
        boolean poolSelection = pool.isSelected();
        boolean tennisCourtSelection = tennisCourt.isSelected();
        LocalDate checkInDateSelection = checkInDate.getValue();
        LocalDate checkOutDateSelection = checkOutDate.getValue();

        GridPane gridPane = new GridPane();
        ScrollPane scrollpane = new ScrollPane(gridPane);
        AnchorPane rootPane = new AnchorPane(scrollpane);

        Scene scene = new Scene(rootPane, 500, 500);
        primary_stage.setScene(scene);
        primary_stage.getScene().setRoot(rootPane);

        AnchorPane.setTopAnchor(scrollpane, 0.0);
        AnchorPane.setBottomAnchor(scrollpane, 0.0);
        AnchorPane.setLeftAnchor(scrollpane, 0.0);
        AnchorPane.setRightAnchor(scrollpane, 0.0);

        AnchorPane.setTopAnchor(gridPane, 0.0);
        AnchorPane.setBottomAnchor(gridPane, 0.0);
        AnchorPane.setLeftAnchor(gridPane, 0.0);
        AnchorPane.setRightAnchor(gridPane, 0.0);

        Button button = new Button("Back");
        button.setStyle("-fx-padding: 10px;");

        AnchorPane.setBottomAnchor(button, 10.0);
        AnchorPane.setRightAnchor(button, 70.0);


        rootPane.getChildren().add(button);

        button.setOnMouseClicked(event -> {
            try {
                HotelMain.change_scene("customer.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        int totalCount = Integer.parseInt(adultSelection) + Integer.parseInt(childrenSelection);

        String sql2 = "SELECT * FROM ROOM inner join reservation on ROOM.ROOM_ID = reservation.ROOM_ID";
        PreparedStatement statement1 = connection.prepareStatement(sql2);
        ResultSet resultset1 = statement1.executeQuery();

        int ROW=1;
        while (resultset1.next()){

            if(LocalDate.parse(resultset1.getString("CHECK_IN_DATE")).compareTo(((LocalDate) checkInDate.getValue())) < 0//CHECK_IN_DATE date is after checkInDate
            && LocalDate.parse(resultset1.getString("CHECK_IN_DATE")).compareTo(((LocalDate) checkOutDate.getValue())) > 0){//CHECK_IN_DATE date is before checkOutDate
                continue;
            }
            else if(LocalDate.parse(resultset1.getString("CHECK_IN_DATE")).compareTo(((LocalDate) checkInDate.getValue())) > 0//CHECK_IN_DATE date is before checkInDate
                    && LocalDate.parse(resultset1.getString("CHECK_OUT_DATE")).compareTo(((LocalDate) checkOutDate.getValue())) > 0){//CHECK_OUT_DATE date is before checkOutDate
                continue;
            }
            else if(LocalDate.parse(resultset1.getString("CHECK_OUT_DATE")).compareTo(((LocalDate) checkInDate.getValue())) < 0//CHECK_OUT_DATE date is after checkInDate
                    && LocalDate.parse(resultset1.getString("CHECK_OUT_DATE")).compareTo(((LocalDate) checkOutDate.getValue())) > 0){//CHECK_OUT_DATE date is before checkOutDate
                continue;
            }

            else if((Integer.parseInt(resultset1.getString("ROOM_ID")) + 1 )<= ROW){
                continue;
            }

            Rectangle box = new Rectangle(300, 100); // Create a rectangle as a box
            Text nameText = new Text("Price: "+resultset1.getString("PRICE_PER_NIGHT")+"  "+"Capacity: "+resultset1.getString("ROOM_CAPACITY"));
            nameText.setId(String.valueOf(resultset1.getString("ROOM_ID")));
            nameText.setWrappingWidth(100); // Set the width of the text box
            nameText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            nameText.setTextAlignment(TextAlignment.CENTER);
            nameText.setMouseTransparent(true);
            box.setFill(Color.AQUA);
            box.setStroke(Color.BURLYWOOD);
            box.setStrokeWidth(2);

            box.setOnMouseClicked(event -> {
                try {
                    String[] parts = nameText.getText().split(" ");

                    make_reservation(checkInDate.getValue().toString(),checkOutDate.getValue().toString(), HotelMain.getID(),box.getId(),
                            parts[1], adults.getText(), children.getText(), mealSelection,poolSelection, tennisCourtSelection);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            gridPane.add(box, 1, ROW); // Add the box to the GridPane
            gridPane.add(nameText, 1, ROW);
            ROW++;
        }

        primary_stage.show();
    }

    @FXML
    private void make_reservation(String checkInDate,String checkOutDate,String customerid ,String roomid,
    String price ,String adults ,String children,boolean meal,boolean pool,boolean tennis) throws IOException, SQLException {

        String sql = "INSERT INTO reservation (CHECK_IN_DATE, CHECK_OUT_DATE, CUSTOMER_ID, ROOM_ID, PRICE, ADULT_NUMBER," +
                "CHILDREN_NUMBER,INCLUDED_MEAL,INCLUDED_POOL,INCLUDED_TENNIS_COURT) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, checkInDate); // Set the value for the first parameter placeholder
        statement.setString(2, checkOutDate); // Set the value for the second parameter placeholder
        statement.setString(3, customerid); // Set the value for the third parameter placeholder
        statement.setString(4, roomid); // Set the value for the third parameter placeholder
        statement.setString(5, price); // Set the value for the third parameter placeholder
        statement.setString(6, adults); // Set the value for the third parameter placeholder
        statement.setString(7, children); // Set the value for the third parameter placeholder
        statement.setBoolean(8, meal); // Set the value for the third parameter placeholder
        statement.setBoolean(9, pool); // Set the value for the third parameter placeholder
        statement.setBoolean(10, tennis); // Set the value for the third parameter placeholder
        int rowsInserted = statement.executeUpdate();

        HotelMain.change_scene("customer.fxml");

    }
}
