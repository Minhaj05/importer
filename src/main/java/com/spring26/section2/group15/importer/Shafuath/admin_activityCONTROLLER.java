package com.spring26.section2.group15.importer.Shafuath;

import com.spring26.section2.group15.importer.Shafuath.model.admin_activity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class
admin_activityCONTROLLER {

    @FXML
    private TableView<admin_activity> admin_activity_table_view;

    @FXML
    private TableColumn<admin_activity, String> userClm;

    @FXML
    private TableColumn<admin_activity, String> actionClm;

    @FXML
    private TableColumn<admin_activity, String> timeClm;

    @FXML
    public void initialize() {


        userClm.setCellValueFactory(new PropertyValueFactory<>("user"));
        actionClm.setCellValueFactory(new PropertyValueFactory<>("action"));
        timeClm.setCellValueFactory(new PropertyValueFactory<>("time"));

        //CREATE SAMPLE DATA
        ObservableList<admin_activity> activityList = FXCollections.observableArrayList(
                new admin_activity(1, "Admin", "Login", "10:00 AM", "Success"),
                new admin_activity(2, "Admin", "Add User", "10:10 AM", "Success"),
                new admin_activity(3, "Admin", "Update Settings", "10:20 AM", "Success"),
                new admin_activity(4, "Admin", "Backup Data", "10:30 AM", "Success")
        );

        //SET DATA TO TABLE
        admin_activity_table_view.setItems(activityList);
    }
}