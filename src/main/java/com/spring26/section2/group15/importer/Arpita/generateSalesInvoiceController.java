package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class generateSalesInvoiceController {

    @FXML
    private TextArea invoiceTA;

    private ArrayList<booking> bookingList;
    private ArrayList<car> carList;

    @FXML
    public void initialize() {
        bookingList = FileHelper.loadBookings();
        carList = FileHelper.loadCars();
    }


    @FXML
    public void generateInvoiceButton(ActionEvent event) {

        StringBuilder invoice = new StringBuilder();
        invoice.append("===== SALES INVOICE =====\n\n");

        for (booking b : bookingList) {

            if (b.getStatus().equalsIgnoreCase("Sold")) {

                String price = "N/A";

                for (car c : carList) {
                    if (c.getModel().equals(b.getCarModel())) {
                        price = String.valueOf(c.getPrice());
                        break;
                    }
                }

                invoice.append("Invoice ID: ").append(b.getBookingID()).append("\n");
                invoice.append("Customer: ").append(b.getCustomerName()).append("\n");
                invoice.append("Car: ").append(b.getCarModel()).append("\n");
                invoice.append("Price: ").append(price).append("\n");
                invoice.append("-----------------------\n");
            }
        }

        if (invoice.toString().equals("===== SALES INVOICE =====\n\n")) {
            invoiceTA.setText("No sales yet!");
        } else {
            invoiceTA.setText(invoice.toString());
        }
    }


    @FXML
    public void printButton(ActionEvent event) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter("invoice.txt");
            writer.write(invoiceTA.getText());
            writer.close();

            showAlert("Success", "Invoice saved!");
        } catch (Exception e) {
            showAlert("Error", "File write failed!");
        }
    }


    @FXML
    public void backButton(ActionEvent event) {
        SceneSwitcher.switchScene(event,
                "/com/spring26/section2/group15/importer/Arpita/salesExecutiveDashboard.fxml");
    }


    private void showAlert(String title, String msg) {
        javafx.scene.control.Alert alert =
                new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}