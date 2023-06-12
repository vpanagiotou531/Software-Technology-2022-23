package com.example.software_technology;

        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.TextField;
        import javafx.scene.control.cell.PropertyValueFactory;

        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;

public class AdminAnnounceListController {

    @FXML
    private TableView<Announcement> announce_table;

    @FXML
    private TableColumn<Announcement, String> content_col;

    @FXML
    private TableColumn<Announcement, String> title_col;

    @FXML
    void back_to_ann_menu(ActionEvent event) throws IOException {
        HotelMain.change_scene("AdminMessageChoice.fxml");
    }

    @FXML
    private TextField txt_title;
    @FXML
    private TextField txt_content;


    ObservableList<Announcement> listM;
    ObservableList<Announcement> dataList;



    int index = -1;

    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    void Update_announcements(ActionEvent event) {

        title_col.setCellValueFactory(new PropertyValueFactory<Announcement,String>("title"));
        content_col.setCellValueFactory(new PropertyValueFactory<Announcement,String>("content"));

        listM = HotelMain.getAdminAnnouncements();
        announce_table.setItems(listM);
        System.out.println("Update: "+title_col);
    }



}
