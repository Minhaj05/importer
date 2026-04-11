package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class verify_paymentcontroller {

    @FXML
    private TableColumn<Payment, Integer> PaymentIdTC;
    @FXML
    private TableColumn<Payment, String> CustomerTC;
    @FXML
    private TableColumn<Payment, Double> AmountTC;
    @FXML
    private TableColumn<Payment, String> StatusTC;
    @FXML
    private TableView<Payment> VerifyPaymentTV;

    // ✅ List to hold table data
    private ObservableList<Payment> dataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // ✅ Link columns to model fields
        PaymentIdTC.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        CustomerTC.setCellValueFactory(new PropertyValueFactory<>("customer"));
        AmountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // ✅ Sample data to show in table
        dataList.add(new Payment(101, "Alice",   500.00, "Pending"));
        dataList.add(new Payment(102, "Bob",     750.50, "Pending"));
        dataList.add(new Payment(103, "Charlie", 300.00, "Verified"));

        // ✅ Load data into TableView
        VerifyPaymentTV.setItems(dataList);
    }

    @FXML
    public void VerifyButton(ActionEvent actionEvent) {
        // ✅ Get selected row
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

        // ✅ Update status to Verified
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

    // ✅ Model class — one object = one row in the table
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