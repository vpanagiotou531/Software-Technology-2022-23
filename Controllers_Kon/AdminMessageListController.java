package com.example.software_technology;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class AdminMessageListController {
    @FXML
    private TableView<AdminMessage> Messages_View;

    @FXML
    private TableColumn<AdminMessage, String> sender_col;

    @FXML
    private TableColumn<AdminMessage, String> title_col;

    @FXML
    private TableColumn<AdminMessage, String> content_col;


    @FXML
    private TextField txt_title;

    @FXML
    private TextField txt_sender;

    @FXML
    private TextField txt_content;

    @FXML
    private TextField filterField;


    ObservableList<AdminMessage> listM;
    ObservableList<AdminMessage> dataList;



    int index = -1;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;






    public void UpdateTable(){
        sender_col.setCellValueFactory(new PropertyValueFactory<AdminMessage,String>("sender_email"));
        title_col.setCellValueFactory(new PropertyValueFactory<AdminMessage,String>("title"));
        content_col.setCellValueFactory(new PropertyValueFactory<AdminMessage,String>("content"));

        listM = HotelMain.getAdminMessages();
        Messages_View.setItems(listM);
        System.out.println("Update: "+title_col);
    }



    public void back_to_msg_menu(ActionEvent actionEvent) throws IOException {
        HotelMain.change_scene(10);
    }
}
