package com.spring26.section2.group15.importer.Shafuath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class manager_inventoryCONTROLLER implements Initializable {

    @FXML
    private Label inventoryLabel;

    @FXML
    private TableView<CarModel> inventoryTableView;

    @FXML
    private TableColumn<CarModel, String> inventoryTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up the column to read the "carModel" property from CarModel class
        inventoryTable.setCellValueFactory(new PropertyValueFactory<>("carModel"));

        // Load data into the table
        loadInventoryData();
    }

    // Load inventory data into the TableView
    private void loadInventoryData() {
        ObservableList<CarModel> carList = FXCollections.observableArrayList(
                // TODO: Replace with real DB query results
                new CarModel("Toyota Corolla"),
                new CarModel("Honda Civic"),
                new CarModel("Ford Mustang"),
                new CarModel("BMW 3 Series"),
                new CarModel("Mercedes C-Class")

        );

        inventoryTableView.setItems(carList);
    }

    // Called when Refresh button is clicked
    @FXML
    private void refreshBtn() {
        inventoryTableView.getItems().clear();
        loadInventoryData();
        System.out.println("Inventory refreshed.");
    }

    // -------------------------------------------------------
    // Inner Model Class (or move this to its own separate file)
    // -------------------------------------------------------
    public static class CarModel {

        private String carModel;

        public CarModel(String carModel) {
            this.carModel = carModel;
        }

        public String getCarModel() {
            return carModel;
        }

        public void setCarModel(String carModel) {
            this.carModel = carModel;
        }
    }
}