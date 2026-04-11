package com.spring26.section2.group15.importer.Arpita;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class updateCarStatusController {
    @javafx.fxml.FXML
    private TableColumn<car,String> brandTC;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableColumn<car,String> carIDTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> modelTC;
    @javafx.fxml.FXML
    private TableView<car> updateCarStatusTV;
    @javafx.fxml.FXML
    private TableColumn<car,String> status;
    private ArrayList<car> carList;


    @javafx.fxml.FXML
    public void initialize() {
        carList = FileHelper.loadCars();


        statusCB.getItems().addAll("Available", "Sold", "Reserved");


        brandTC.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("model"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        carIDTC.setCellValueFactory(new PropertyValueFactory<>("carID"));


        updateCarStatusTV.setItems(FXCollections.observableArrayList(carList));
    }

    @javafx.fxml.FXML
    public void updateStatusButton(ActionEvent actionEvent) {
        car selectedCar = updateCarStatusTV.getSelectionModel().getSelectedItem();
        String newStatus = statusCB.getValue();

        if (selectedCar == null || newStatus == null) {
            showAlert("Error", "Select car & status!");
            return;
        }

        selectedCar.setStatus(newStatus);

        FileHelper.saveCars(carList);

        updateCarStatusTV.refresh();

        showAlert("Success", "Status updated!");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/user3-dashboard.fxml");
    }
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}