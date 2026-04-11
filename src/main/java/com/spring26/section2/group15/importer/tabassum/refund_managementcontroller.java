package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class refund_managementcontroller {

    private Label RefundLBL;
    private TextField RefundAmountTF;
    private TextArea ReasonTA;

    public void initialize() {
        RefundAmountTF.setPromptText("Enter refund amount...");
        ReasonTA.setPromptText("Enter reason for refund...");
    }

    public void ProcessRefundButton(ActionEvent actionEvent) {
        String amountText = RefundAmountTF.getText().trim();
        String reason     = ReasonTA.getText().trim();

        if (amountText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter the refund amount.");
            alert.showAndWait();
            return;
        }

        if (reason.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a reason for the refund.");
            alert.showAndWait();
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            if (amount <= 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Amount");
                alert.setHeaderText(null);
                alert.setContentText("Refund amount must be greater than zero.");
                alert.showAndWait();
                return;
            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Confirm Refund");
            confirm.setHeaderText(null);
            confirm.setContentText(
                    "Are you sure you want to process this refund?\n\n" +
                            "Refund Amount : $" + String.format("%.2f", amount) + "\n" +
                            "Reason        : " + reason
            );

            // Only process if user clicks OK
            confirm.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {

                    Alert success = new Alert(Alert.AlertType.INFORMATION);
                    success.setTitle("Refund Processed");
                    success.setHeaderText(null);
                    success.setContentText(
                            "Refund Processed Successfully!\n\n" +
                                    "Refund Amount : $" + String.format("%.2f", amount) + "\n" +
                                    "Reason        : " + reason
                    );
                    success.showAndWait();

                    RefundAmountTF.clear();
                    ReasonTA.clear();
                }
            });

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for refund amount.");
            alert.showAndWait();
        }
    }
}