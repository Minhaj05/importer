package com.spring26.section2.group15.importer.Arpita;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class deleteCarRecordController
{
    @javafx.fxml.FXML
    private TableView<car> deleteCarRecordTV;
    @javafx.fxml.FXML
    private TableColumn<car,String> priceTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> brandTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> carIDTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> modelTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> yearTC;
    private ArrayList<car> carList;

    @javafx.fxml.FXML
    public void initialize() {
        carList = FileHelper.loadCars();

        brandTC.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearTC.setCellValueFactory(new PropertyValueFactory<>("year"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        deleteCarRecordTV.setItems(FXCollections.observableArrayList(carList));
    }

    @javafx.fxml.FXML
    public void deleteButton(ActionEvent actionEvent) {
        car selectedCar = deleteCarRecordTV.getSelectionModel().getSelectedItem();

        if (selectedCar == null) {
            showAlert("Error", "Select a car first!");
            return;
        }

        carList.remove(selectedCar);

        FileHelper.saveCars(carList);

        deleteCarRecordTV.setItems(FXCollections.observableArrayList(carList));

        showAlert("Success", "Car deleted!");
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/user3InventorydDashboard.fxml");
    }
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}