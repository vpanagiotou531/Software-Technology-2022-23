module com.example.software_technology {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.software_technology to javafx.fxml;
    exports com.example.software_technology;
}