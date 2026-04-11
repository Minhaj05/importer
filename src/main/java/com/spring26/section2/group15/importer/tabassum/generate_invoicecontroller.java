package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class generate_invoicecontroller {

    private TableView<Sale> GenerateInvoiceTV;    // Table to show sales
    private TableColumn<Sale, String> SaleIdTC;   // Sale ID column
    private TableColumn<Sale, String> CustomerTC; // Customer column
    private TableColumn<Sale, Double> AmountTC;   // Amount column
    private TextArea InvoiceViewTA;               // Invoice output area


    // This represents one row in the table
    public static class Sale {

        private String saleId;
        private String customer;
        private Double amount;

        public Sale(String saleId, String customer, Double amount) {
            this.saleId   = saleId;
            this.customer = customer;
            this.amount   = amount;
        }

        public String getSaleId()   { return saleId; }
        public String getCustomer() { return customer; }
        public Double getAmount()   { return amount; }
    }


\
    public void initialize() {

        // Link each column to the Sale class fields
        SaleIdTC.setCellValueFactory(new PropertyValueFactory<>("saleId"));
        CustomerTC.setCellValueFactory(new PropertyValueFactory<>("customer"));
        AmountTC.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // Load dummy data into the table
        // Replace this with real DB data when ready
        ObservableList<Sale> saleList = FXCollections.observableArrayList(
                new Sale("S001", "Ahmed Ali",   15000.0),
                new Sale("S002", "Sara Khan",   22000.0),
                new Sale("S003", "John Smith",  18500.0)
        );

        GenerateInvoiceTV.setItems(saleList);

        // Make invoice area read-only
        InvoiceViewTA.setEditable(false);
        InvoiceViewTA.setWrapText(true);
        InvoiceViewTA.setPromptText("Invoice will appear here...");

        System.out.println("Generate Invoice Screen Loaded.");
    }



    public void GenerateInvoiceButton(ActionEvent actionEvent) {

        // Get the selected row from the table
        Sale selectedSale = GenerateInvoiceTV.getSelectionModel().getSelectedItem();

        // Check if user selected a row
        if (selectedSale == null) {
            InvoiceViewTA.setText("ERROR: Please select a sale from the table first.");
            return;
        }

        // Build the invoice text
        String invoice = buildInvoice(selectedSale);

        // Show invoice in the TextArea
        InvoiceViewTA.setText(invoice);

        System.out.println("Invoice generated for Sale ID: " + selectedSale.getSaleId());
    }

    private String buildInvoice(Sale sale) {

        return  "==============================\n" +
                "           INVOICE            \n" +
                "==============================\n" +
                "Sale ID   : " + sale.getSaleId()   + "\n" +
                "Customer  : " + sale.getCustomer() + "\n" +
                "------------------------------\n" +
                "Amount    : $" + sale.getAmount()  + "\n" +
                "------------------------------\n" +
                "Thank you for your business! \n" +
                "==============================";
    }
}