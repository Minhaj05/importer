package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class update_payment_statuscontroller {

    private TableColumn<Payment, Integer> PaymentIdTC;
    private TableColumn<Payment, String> CustomerNameTC;
    private TableColumn<Payment, Double> AmountTC;
    private TableColumn<Payment, String> DateTC;
    private TableColumn<Payment, String> StatusTC;
    private TableView<Payment> UpdatePaymentStatusTV;
    private ComboBox<String> StatusCB;

    private ObservableList<Payment> dataList = FXCollections.observableArrayList();

    public void initialize() {
        PaymentIdTC.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        CustomerNameTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        AmountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        DateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        dataList.add(new Payment(101, "Alice Johnson", 500.00, "2025-01-10", "Pending"));
        dataList.add(new Payment(102, "Bob Smith",     750.50, "2025-02-15", "Pending"));
        dataList.add(new Payment(103, "Charlie Brown", 300.00, "2025-03-20", "Completed"));
        dataList.add(new Payment(104, "Diana Prince",  920.00, "2025-04-05", "Failed"));
        dataList.add(new Payment(105, "Eve Adams",     150.75, "2025-05-11", "Pending"));

        UpdatePaymentStatusTV.setItems(dataList);

        StatusCB.setItems(FXCollections.observableArrayList(
                "Pending", "Completed", "Failed", "Cancelled"
        ));
        StatusCB.setValue("Pending"); // default
    }


    public void UpdateButton(ActionEvent actionEvent) {
        Payment selected = UpdatePaymentStatusTV.getSelectionModel().getSelectedItem();

        // No row selected — show warning
        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a payment row to update.");
            alert.showAndWait();
            return;
        }

        String newStatus = StatusCB.getValue();

        // Same status — no need to update
        if (selected.getStatus().equals(newStatus)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Change");
            alert.setHeaderText(null);
            alert.setContentText("Payment ID " + selected.getPaymentId() +
                    " is already set to \"" + newStatus + "\".");
            alert.showAndWait();
            return;
        }

        selected.setStatus(newStatus);
        UpdatePaymentStatusTV.refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Status Updated");
        alert.setHeaderText(null);
        alert.setContentText(
                "Payment Updated Successfully!\n\n" +
                        "Payment ID    : " + selected.getPaymentId()    + "\n" +
                        "Customer Name : " + selected.getCustomerName() + "\n" +
                        "Amount        : $" + selected.getAmount()      + "\n" +
                        "Date          : " + selected.getDate()         + "\n" +
                        "New Status    : " + selected.getStatus()
        );
        alert.showAndWait();
    }

    public static class Payment {
        private int    paymentId;
        private String customerName;
        private double amount;
        private String date;
        private String status;

        public Payment(int paymentId, String customerName, double amount, String date, String status) {
            this.paymentId    = paymentId;
            this.customerName = customerName;
            this.amount       = amount;
            this.date         = date;
            this.status       = status;
        }

        // Getters — required by PropertyValueFactory
        public int    getPaymentId()    { return paymentId; }
        public String getCustomerName() { return customerName; }
        public double getAmount()       { return amount; }
        public String getDate()         { return date; }
        public String getStatus()       { return status; }

        // Setter — needed to update status
        public void setStatus(String status) { this.status = status; }
    }
}