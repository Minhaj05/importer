package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class addNewCarController
{
    @javafx.fxml.FXML
    private TextField priceTF;
    @javafx.fxml.FXML
    private Label ComponentLable;
    @javafx.fxml.FXML
    private TextField yearTF;
    @javafx.fxml.FXML
    private TextField modelTF;
    @javafx.fxml.FXML
    private TextField brandTF;
    @javafx.fxml.FXML
    private TextField mileageTF;
    @javafx.fxml.FXML
    private TextField engineccTF;
    private ArrayList<car> carList;



    @javafx.fxml.FXML
    public void initialize() {
        carList = FileHelper.loadCars();

    }

    @javafx.fxml.FXML
    public void goBackButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/user3-InventoryDashboard.fxml");
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        try {
            String brand = brandTF.getText();
            String model = modelTF.getText();
            int year = Integer.parseInt(yearTF.getText());
            double price = Double.parseDouble(priceTF.getText());

            // validation
            if (brand.isEmpty() || model.isEmpty()) {
                showAlert("Error", "Fill all fields!");
                return;
            }

            car newCar = new car();
            newCar.setBrand(brand);
            newCar.setModel(model);
            newCar.setYear(year);
            newCar.setPrice(price);
            newCar.setStatus("Available");

            carList.add(newCar);

            FileHelper.saveCars(carList);

            showAlert("Success", "Car Added!");

        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid number!");
        } catch (Exception e) {
            showAlert("Error", "Something went wrong!");
        }
    }
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}
