package com.example.software_technology;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class CustomerController {


    @FXML
    private Menu feedback;
    @FXML
    private Menu reservation;
    @FXML
    private Menu ratingPage;

    @FXML
    private Button RatingSubmitButton;




    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        System.out.println("Rating Given:");

    }

    @FXML
    protected void change_scene_reservation() throws IOException {

        HotelMain.change_scene(10);
    }

    @FXML
    protected void change_scene_ratingPage() throws IOException {

        HotelMain.change_scene(11);
    }

    @FXML
    protected void change_scene_feedback() throws IOException, SQLException {


        HotelMain.change_scene(9);
        Stage primary_stage = HotelMain.get_stage(); /* Επιστρέφει το αρχικό page */

        Stage room_stage = new Stage();
        Connection connection = HotelMain.get_connection();

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
    }
}
