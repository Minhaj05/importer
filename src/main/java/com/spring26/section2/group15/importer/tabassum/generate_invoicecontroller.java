package com.spring26.section2.group15.importer.tabassum;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

public class generate_invoicecontroller {

    @FXML private TableView<String> GenerateInvoiceTV;
    @FXML private TableColumn<String, String> SaleIdTC;
    @FXML private TableColumn<String, String> CustomerTC;
    @FXML private TableColumn<String, String> AmountTC;
    @FXML private TextArea InvoiceViewTA;

    @FXML
    public void initialize() {
        // Dummy data
        GenerateInvoiceTV.setItems(FXCollections.observableArrayList(
                "Sale1 - Tabassum - 5000",
                "Sale2 - Nuzhat - 7000"
        ));
    }

    @FXML
    public void GenerateInvoiceButton() {

        String selected = GenerateInvoiceTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            InvoiceViewTA.setText("Select a row first!");
            return;
        }

        // Invoice output
        String invoice = "INVOICE\n\n" +
                selected +
                "\n\nThank you!";

        InvoiceViewTA.setText(invoice);
    }
}