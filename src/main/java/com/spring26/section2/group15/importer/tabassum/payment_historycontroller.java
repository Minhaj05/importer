package com.spring26.section2.group15.importer.tabassum;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;

public class payment_historycontroller {

    @FXML private TableView<String> PaymentHistoryTV;
    @FXML private TextArea detailsTA; // optional না থাকলেও চলবে

    @FXML
    public void initialize() {
        PaymentHistoryTV.setItems(FXCollections.observableArrayList(
                "P1 - Tabassum - 5000 - 2026 - Paid",
                "P2 - Nuzhat - 7000 - 2026 - Pending"
        ));
    }

    @FXML
    public void ViewDetailsButton() {

        String selected = PaymentHistoryTV.getSelectionModel().getSelectedItem();

        if (selected == null) return;

        System.out.println(selected); // simple output
    }
}