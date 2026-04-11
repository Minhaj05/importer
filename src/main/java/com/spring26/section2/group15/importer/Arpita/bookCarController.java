package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

        if (customerList == null) customerList = new ArrayList<>();
        if (carList == null) carList = new ArrayList<>();
        if (bookingList == null) bookingList = new ArrayList<>();


        if (customerList.isEmpty()) {
            customerList.add(new customer("Arpita", "01711111111", "Dhaka"));
            customerList.add(new customer("Rahim", "01822222222", "CTG"));
        }

        if (carList.isEmpty()) {
            carList.add(new car("Toyota", "Axio", 2020, 1500000));
            carList.add(new car("Honda", "Civic", 2021, 2000000));
        }

        customerComboBox.getItems().clear();
        carComboBox.getItems().clear();

        for (customer c : customerList) {
            customerComboBox.getItems().add(c.getName());
        }

        for (car c : carList) {
            if (c.getStatus().equalsIgnoreCase("Available")) {
                carComboBox.getItems().add(c.getModel());
            }
        }
    }


    @FXML
    public void bookButton(ActionEvent event) {

        String selectedCustomer = customerComboBox.getValue();
        String selectedCar = carComboBox.getValue();

        if (selectedCustomer == null || selectedCar == null) {
            showAlert("Error", "Select customer and car!");
            return;
        }

        int id = bookingList.size() + 1;

        for (car c : carList) {
            if (c.getModel().equals(selectedCar)) {


                c.setStatus("Reserved");


                booking b = new booking(id, selectedCustomer, selectedCar, "Booked");
                bookingList.add(b);

                break;
            }
        }


        FileHelper.saveBookings(bookingList);
        FileHelper.saveCars(carList);

        showAlert("Success", "Car booked successfully!");
    }


    @FXML
    public void backButton(ActionEvent event) {
        SceneSwitcher.switchScene(event, "/com/spring26/section2/group15/importer/Arpita/salesExecutiveDashboard.fxml");
    }


    private void showAlert(String title, String msg) {
        javafx.scene.control.Alert alert =
                new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
