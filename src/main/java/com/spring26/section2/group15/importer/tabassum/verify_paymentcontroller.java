package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class verify_paymentcontroller {

    private TableColumn<Payment, Integer> PaymentIdTC;
    private TableColumn<Payment, String> CustomerTC;
    private TableColumn<Payment, Double> AmountTC;
    private TableColumn<Payment, String> StatusTC;
    private TableView<Payment> VerifyPaymentTV;

    private ObservableList<Payment> dataList = FXCollections.observableArrayList();

    public void initialize() {
        PaymentIdTC.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        CustomerTC.setCellValueFactory(new PropertyValueFactory<>("customer"));
        AmountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        dataList.add(new Payment(101, "Alice",   500.00, "Pending"));
        dataList.add(new Payment(102, "Bob",     750.50, "Pending"));
        dataList.add(new Payment(103, "Charlie", 300.00, "Verified"));

        VerifyPaymentTV.setItems(dataList);
    }

    public void VerifyButton(ActionEvent actionEvent) {
        Payment selected = VerifyPaymentTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            // No row selected — show warning
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a payment row to verify.");
            alert.showAndWait();
            return;
        }

        if (selected.getStatus().equals("Verified")) {
            // Already verified — inform user
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Already Verified");
            alert.setHeaderText(null);
            alert.setContentText("Payment ID " + selected.getPaymentId() + " is already verified.");
            alert.showAndWait();
            return;
        }

        selected.setStatus("Verified");

        // Refresh the table to show updated status
        VerifyPaymentTV.refresh();

        // Show success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Payment Verified");
        alert.setHeaderText(null);
        alert.setContentText(
                "Payment Verified Successfully!\n\n" +
                        "Payment ID : " + selected.getPaymentId() + "\n" +
                        "Customer   : " + selected.getCustomer() + "\n" +
                        "Amount     : $" + selected.getAmount() + "\n" +
                        "Status     : " + selected.getStatus()
        );
        alert.showAndWait();
    }

    public static class Payment {
        private int paymentId;
        private String customer;
        private double amount;
        private String status;

        public Payment(int paymentId, String customer, double amount, String status) {
            this.paymentId = paymentId;
            this.customer  = customer;
            this.amount    = amount;
            this.status    = status;
        }

        // Getters — required by PropertyValueFactory
        public int    getPaymentId() { return paymentId; }
        public String getCustomer()  { return customer; }
        public double getAmount()    { return amount; }
        public String getStatus()    { return status; }

        // Setter — needed to update status on Verify
        public void setStatus(String status) { this.status = status; }
    }
}