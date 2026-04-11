package com.spring26.section2.group15.importer.Arpita;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;



public class updateCarInformationController
{
    @javafx.fxml.FXML
    private TableColumn<car, String> priceTC;
    @javafx.fxml.FXML
    private TableColumn<car, String> brandTC;
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private TableView<car> carListTV;
    @javafx.fxml.FXML
    private TableColumn<car, String> modelTC;
    @javafx.fxml.FXML
    private TextField modelTF;
    @javafx.fxml.FXML
    private TextField brandTF;
    private ArrayList<car> carList;

    @javafx.fxml.FXML
    public void initialize() {
        carList = FileHelper.loadCars();

        brandTC.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("model"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));

        carListTV.setItems(FXCollections.observableArrayList(carList));


        carListTV.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                brandTF.setText(newVal.getBrand());
                modelTF.setText(newVal.getModel());
                priceTF.setText(String.valueOf(newVal.getPrice()));
            }
        });
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/user3-dashboard.fxml");
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        car selected = carListTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a car first!");
            return;
        }

        try {
            selected.setBrand(brandTF.getText());
            selected.setModel(modelTF.getText());
            selected.setPrice(Double.parseDouble(priceTF.getText()));

            FileHelper.saveCars(carList);

            carListTV.refresh();

            showAlert("Success", "Car Updated!");

        } catch (Exception e) {
            showAlert("Error", "Invalid input!");

        }
    }
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}




