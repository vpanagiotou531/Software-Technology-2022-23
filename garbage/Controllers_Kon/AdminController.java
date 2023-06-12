package com.example.software_technology;

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

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdminController {

    private Stage room_stage,employee_stage;
    private Stage primary_stage = HotelMain.get_stage();
    private Connection connection = HotelMain.get_connection();
    @FXML
    private TextField salary;
    @FXML
    private Text employee_id;

    @FXML
    protected void change_scene_Staff() throws IOException, SQLException {

        Stage primary_stage = HotelMain.get_stage();
        Connection connection = HotelMain.get_connection();

        HotelMain.change_scene(5);
        primary_stage.getScene().setRoot(new GridPane());

        GridPane gridPane = (GridPane) primary_stage.getScene().getRoot();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        String sql = "SELECT * FROM employee ";
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);

        int col = 1;

        for (int row = 0; resultset.next(); ) {

            if(col==1)
                row++;
            Rectangle box = new Rectangle(100, 100); // Create a rectangle as a box
            box.setId(Integer.toString((row-1)*4+col));

            box.setFill(Color.BISQUE);

            String name = resultset.getString("FIRST_NAME") + "\n" +resultset.getString("LAST_NAME"); // Replace with the actual name you want to display
            Text nameText = new Text(name);
            nameText.setId(Integer.toString((row-1)*4+col));
            nameText.setWrappingWidth(100); // Set the width of the text box
            nameText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            nameText.setTextAlignment(TextAlignment.CENTER);
            nameText.setMouseTransparent(true);

            box.setStroke(Color.BLACK);
            box.setStrokeWidth(2);

            box.setOnMouseClicked(event -> {
                try {
                    System.out.println(box.getId());
                    employee_info(box.getId());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            gridPane.add(box, col, row+1); // Add the box to the GridPane
            gridPane.add(nameText, col, row + 1);
            col = (col%4) + 1;
        }
    }
    @FXML
    protected void change_scene_Rooms() throws SQLException, IOException {

        Stage primary_stage = HotelMain.get_stage();
        Connection connection = HotelMain.get_connection();

        HotelMain.change_scene(6);
        primary_stage.getScene().setRoot(new GridPane());

        GridPane gridPane = (GridPane) primary_stage.getScene().getRoot();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        String sql = "SELECT * FROM room ";
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(sql);

        int col = 1;

        for (int row = 0; resultset.next(); ) {

            if(col==1)
                row++;
            Rectangle box = new Rectangle(100, 100); // Create a rectangle as a box
            box.setId(Integer.toString((row-1)*4+col));

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
            nameText.setId(Integer.toString((row-1)*4+col));
            nameText.setWrappingWidth(100); // Set the width of the text box
            nameText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
            nameText.setTextAlignment(TextAlignment.CENTER);
            nameText.setMouseTransparent(true);

            box.setStroke(Color.BLACK);
            box.setStrokeWidth(2);

            box.setOnMouseClicked(event -> {
                try {
                    room_info(box.getId());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            gridPane.add(box, col, row+1); // Add the box to the GridPane
            gridPane.add(nameText, col, row + 1);
            col = (col%4) + 1;
        }
    }
    @FXML
    protected void room_info(String room_number) throws IOException, SQLException {

        Stage primary_stage = HotelMain.get_stage();
        Connection connection = HotelMain.get_connection();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the current date according to the SQL format
        String formattedDate = currentDate.format(formatter);

        String sql = "SELECT * FROM reservation WHERE ROOM_ID = ? AND CHECK_IN_DATE <= ? AND CHECK_OUT_DATE >= ?";

        room_stage = new Stage();
        room_stage.setScene(new Scene(new FXMLLoader(HotelMain.class.getResource("room_info.fxml")).load()));
        room_stage.show();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, room_number); // Set the value for the second parameter placeholder
        statement.setString(2, formattedDate); // Set the value for the second parameter placeholder
        statement.setString(3, formattedDate); // Set the value for the third parameter placeholder
        ResultSet resultset = statement.executeQuery();

        while (resultset.next()){

            ((Text) room_stage.getScene().lookup("#checkin")).setText(resultset.getString("CHECK_IN_DATE"));
            ((Text) room_stage.getScene().lookup("#checkout")).setText(resultset.getString("CHECK_OUT_DATE"));
            ((Text) room_stage.getScene().lookup("#adults")).setText(resultset.getString("ADULT_NUMBER"));
            ((Text) room_stage.getScene().lookup("#kids")).setText(resultset.getString("CHILDREN_NUMBER"));

            if(resultset.getString("INCLUDED_MEAL").equals("1")){
                ((CheckBox) room_stage.getScene().lookup("#meal")).setSelected(true);
            }
            if(resultset.getString("INCLUDED_POOL").equals("1")){
                ((CheckBox) room_stage.getScene().lookup("#pool")).setSelected(true);
            }
            if(resultset.getString("INCLUDED_TENNIS_COURT").equals("1")){
                ((CheckBox) room_stage.getScene().lookup("#tennis")).setSelected(true);
            }

            String sql1 = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ? ";

            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setString(1, resultset.getString("CUSTOMER_ID")); // Set the value for the second parameter placeholder
            ResultSet resultset1 = statement1.executeQuery();

            while (resultset1.next()){
                ((Text) room_stage.getScene().lookup("#name")).setText(resultset1.getString("FIRST_NAME")+" "+resultset1.getString("LAST_NAME"));
            }
        }
    }
    @FXML
    protected void employee_info(String employee) throws IOException, SQLException {
        Stage primary_stage = HotelMain.get_stage();
        Connection connection = HotelMain.get_connection();

        String sql = "SELECT * FROM employee WHERE EMPLOYEE_ID = ? ";

        employee_stage = new Stage();
        employee_stage.setScene(new Scene(new FXMLLoader(HotelMain.class.getResource("employee_info.fxml")).load()));
        employee_stage.show();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee); // Set the value for the second parameter placeholder
        ResultSet resultset = statement.executeQuery();

        while (resultset.next()){
            System.out.println(resultset.getString("FIRST_NAME"));
            ((Text) employee_stage.getScene().lookup("#employee_id")).setText(resultset.getString("EMPLOYEE_ID"));
            ((Text) employee_stage.getScene().lookup("#firstname")).setText(resultset.getString("FIRST_NAME"));
            ((Text) employee_stage.getScene().lookup("#lastname")).setText(resultset.getString("LAST_NAME"));
            ((Text) employee_stage.getScene().lookup("#email")).setText(resultset.getString("EMAIL"));
            ((TextField) employee_stage.getScene().lookup("#salary")).setText(resultset.getString("SALARY"));
        }
    }

    @FXML
    protected void edit_salary() throws SQLException {

        System.out.println(salary.getText());
        System.out.println(employee_id.getText());
        Connection connection = HotelMain.get_connection();
        String sqlQuery = "UPDATE employee SET SALARY = ? WHERE EMPLOYEE_ID = ?";
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setString(1, salary.getText()); // Set the value for the second parameter placeholder
        statement.setString(2, employee_id.getText()); // Set the value for the second parameter placeholder
        statement.executeUpdate();

    }
    @FXML
    protected void change_scene_Orders() throws IOException {
        HotelMain.change_scene(7);
    }
    @FXML
    protected void change_scene_Work() throws IOException {
        HotelMain.change_scene(8);
    }
    @FXML
    protected void change_scene_Messages() throws IOException {
        HotelMain.change_scene(10);
    }
    @FXML
    protected void change_scene_Announcements() throws IOException {
        HotelMain.change_scene(15);
    }
}
