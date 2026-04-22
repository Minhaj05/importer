package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;

public class bookCarController {

    @FXML
    private ComboBox<String> customerComboBox;
    @FXML
    private ComboBox<String> carComboBox;

    private ArrayList<customer> customerList;
    private ArrayList<car> carList;
    private ArrayList<booking> bookingList;

    @FXML
    public void initialize() {

        customerList = FileHelper.loadCustomers();
        carList = FileHelper.loadCars();
        bookingList = FileHelper.loadBookings();

        customerComboBox.getItems().clear();
        carComboBox.getItems().clear();


        for (customer c : customerList) {
            customerComboBox.getItems().add(c.getName());
        }


        for (car c : carList) {
            if ("Available".equalsIgnoreCase(c.getStatus())) {
                carComboBox.getItems().add(c.getModel());
            }
        }
    }

    @FXML
    public void bookButton(ActionEvent event) {
        String selectedCustomer = customerComboBox.getValue();
        String selectedCarModel = carComboBox.getValue();

        if (selectedCustomer == null || selectedCarModel == null) {
            showAlert("Error", "Please select both Customer and Car!");
            return;
        }


        int nextId = bookingList.size() + 1;
        booking newBooking = new booking(nextId, selectedCustomer, selectedCarModel, "Booked");


        FileHelper.saveBooking(newBooking);


        for (car c : carList) {
            if (c.getModel().equals(selectedCarModel)) {
                c.setStatus("Reserved");
                break;
            }
        }


        FileHelper.saveAllCars(carList);

        showAlert("Success", "Car Reserved successfully!");

        // বুকিং হয়ে গেলে গাড়িটি লিস্ট থেকে সরিয়ে ফেলা (UI আপডেট)
        carComboBox.getItems().remove(selectedCarModel);
    }

    @FXML
    public void backButton(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/spring26/section2/group15/importer/Arpita/salesExecutiveDashboard.fxml");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}