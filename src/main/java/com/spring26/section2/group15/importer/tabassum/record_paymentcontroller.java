package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class record_paymentcontroller {

    private Label RecordPaymentLBL;
    private TextField CustomerNameTF;
    private TextField amountTF;
    private ComboBox<String> PaymentMethodCB;
    private DatePicker dateDP;

    public void initialize() {
        CustomerNameTF.setPromptText("Enter customer name...");
        amountTF.setPromptText("Enter amount...");

        PaymentMethodCB.setItems(FXCollections.observableArrayList(
                "Cash", "Credit Card", "Debit Card", "Bank Transfer", "Mobile Banking"
        ));
        PaymentMethodCB.setValue("Cash"); // default

        dateDP.setValue(LocalDate.now());
    }

    public void saveButton(ActionEvent actionEvent) {
        String customerName   = CustomerNameTF.getText().trim();
        String amountText     = amountTF.getText().trim();
        String paymentMethod  = PaymentMethodCB.getValue();
        LocalDate date        = dateDP.getValue();

        if (customerName.isEmpty()) {
            showWarning("Please enter the customer name.");
            return;
        }

        if (amountText.isEmpty()) {
            showWarning("Please enter the payment amount.");
            return;
        }

        if (paymentMethod == null) {
            showWarning("Please select a payment method.");
            return;
        }

        if (date == null) {
            showWarning("Please select a payment date.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            if (amount <= 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Amount");
                alert.setHeaderText(null);
                alert.setContentText("Amount must be greater than zero.");
                alert.showAndWait();
                return;
            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Confirm Payment");
            confirm.setHeaderText(null);
            confirm.setContentText(
                    "Are you sure you want to save this payment?\n\n" +
                            "Customer Name  : " + customerName                    + "\n" +
                            "Amount         : $" + String.format("%.2f", amount)  + "\n" +
                            "Payment Method : " + paymentMethod                   + "\n" +
                            "Date           : " + date
            );

            confirm.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {

                    // ✅ Show success message
                    Alert success = new Alert(Alert.AlertType.INFORMATION);
                    success.setTitle("Payment Saved");
                    success.setHeaderText(null);
                    success.setContentText(
                            "Payment Recorded Successfully!\n\n" +
                                    "Customer Name  : " + customerName                    + "\n" +
                                    "Amount         : $" + String.format("%.2f", amount)  + "\n" +
                                    "Payment Method : " + paymentMethod                   + "\n" +
                                    "Date           : " + date
                    );
                    success.showAndWait();

                    clearFields();
                }
            });

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for amount.");
            alert.showAndWait();
        }
    }

    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Input");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearFields() {
        CustomerNameTF.clear();
        amountTF.clear();
        PaymentMethodCB.setValue("Cash");
        dateDP.setValue(LocalDate.now());
    }
}