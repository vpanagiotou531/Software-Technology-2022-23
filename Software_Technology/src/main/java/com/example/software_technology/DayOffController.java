package com.example.software_technology;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DayOffController implements Initializable {

    @FXML
    private ChoiceBox<String> employees;

    @FXML
    void getEmployee(MouseEvent event) {
        String animal = employees.getSelectionModel().getSelectedItem();
        System.out.println(employees);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        employees.getItems().addAll("Matthew Roberts" , "Ava Turner", "William Cooper", "Chloe Garcia", "Ethan Parker");
    }
}