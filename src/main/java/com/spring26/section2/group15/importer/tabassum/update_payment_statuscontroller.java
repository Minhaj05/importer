package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class update_payment_statuscontroller {

    @FXML
    private TableColumn<Payment, Integer> PaymentIdTC;
    @FXML
    private TableColumn<Payment, String> CustomerNameTC;
    @FXML
    private TableColumn<Payment, Double> AmountTC;
    @FXML
    private TableColumn<Payment, String> DateTC;
    @FXML
    private TableColumn<Payment, String> StatusTC;
    @FXML
    private TableView<Payment> UpdatePaymentStatusTV;
    @FXML
    private ComboBox<String> StatusCB;

    // ✅ List to hold all payment data
    private ObservableList<Payment> dataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // ✅ Link columns to model fields
        PaymentIdTC.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        CustomerNameTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        AmountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));
        DateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // ✅ Sample data
        dataList.add(new Payment(101, "Alice Johnson", 500.00, "2025-01-10", "Pending"));
        dataList.add(new Payment(102, "Bob Smith",     750.50, "2025-02-15", "Pending"));
        dataList.add(new Payment(103, "Charlie Brown", 300.00, "2025-03-20", "Completed"));
        dataList.add(new Payment(104, "Diana Prince",  920.00, "2025-04-05", "Failed"));
        dataList.add(new Payment(105, "Eve Adams",     150.75, "2025-05-11", "Pending"));

        // ✅ Load data into table
        UpdatePaymentStatusTV.setItems(dataList);

        // ✅ ComboBox status options
        StatusCB.setItems(FXCollections.observableArrayList(
                "Pending", "Completed", "Failed", "Cancelled"
        ));
        StatusCB.setValue("Pending"); // default
    }

    // ✅ Update button — updates selected row's status from ComboBox
    @FXML
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

        // ✅ Apply new status to selected row
        selected.setStatus(newStatus);
        UpdatePaymentStatusTV.refresh();

        // ✅ Show success message
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

    // ✅ Model class — one object = one row in the table
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