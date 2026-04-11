package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class payment_historycontroller {

    private Label PaymentHistoryLBL;                        // Title label
    private TableView<Payment> PaymentHistoryTV;            // Payment table
    private TableColumn<Payment, String> PaymentIdTC;       // Payment ID column
    private TableColumn<Payment, String> customerNameTC;    // Customer Name column
    private TableColumn<Payment, Double> AmountTC;          // Amount column
    private TableColumn<Payment, String> DateTC;            // Date column
    private TableColumn<Payment, String> StatusTC;          // Status column


    // Represents one row in the table
    public static class Payment {

        private String paymentId;
        private String customerName;
        private Double amount;
        private String date;
        private String status;

        public Payment(String paymentId, String customerName,
                       Double amount, String date, String status) {
            this.paymentId    = paymentId;
            this.customerName = customerName;
            this.amount       = amount;
            this.date         = date;
            this.status       = status;
        }

        public String getPaymentId()    { return paymentId; }
        public String getCustomerName() { return customerName; }
        public Double getAmount()       { return amount; }
        public String getDate()         { return date; }
        public String getStatus()       { return status; }
    }

    public void initialize() {

        // Link each column to the Payment class fields
        PaymentIdTC.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        customerNameTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        AmountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        DateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Load dummy data into the table
        // Replace this with real DB data when ready
        ObservableList<Payment> paymentList = FXCollections.observableArrayList(
                new Payment("P001", "Ahmed Ali",   15000.0, "2024-01-10", "Paid"),
                new Payment("P002", "Sara Khan",   22000.0, "2024-02-15", "Pending"),
                new Payment("P003", "John Smith",  18500.0, "2024-03-20", "Paid"),
                new Payment("P004", "Maria Lopez", 9500.0,  "2024-04-05", "Failed")
        );

        PaymentHistoryTV.setItems(paymentList);

        System.out.println("Payment History Screen Loaded.");
    }

    public void ViewDetailsButton(ActionEvent actionEvent) {

        // Get the selected row
        Payment selected = PaymentHistoryTV.getSelectionModel().getSelectedItem();

        // Check if user selected a row
        if (selected == null) {
            System.out.println("ERROR: Please select a payment row first.");
            return;
        }

        // Print details to console
        // Replace with a popup or new screen if needed
        System.out.println("===== Payment Details =====");
        System.out.println("Payment ID    : " + selected.getPaymentId());
        System.out.println("Customer Name : " + selected.getCustomerName());
        System.out.println("Amount        : $" + selected.getAmount());
        System.out.println("Date          : " + selected.getDate());
        System.out.println("Status        : " + selected.getStatus());
        System.out.println("===========================");
    }
}