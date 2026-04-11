package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class generate_reportcontroller {
    private Label ImportReportLBL;
    private DatePicker FromDateDP;
    private DatePicker ToDateDP;
    private TextArea ReportShowTA;

    public void initialize() {
        FromDateDP.setValue(LocalDate.now().minusMonths(1)); // 1 month ago
        ToDateDP.setValue(LocalDate.now());                  // today

        ReportShowTA.setEditable(false);
        ReportShowTA.setPromptText("Report will appear here after clicking Generate...");
    }


    public void GenerateButton(ActionEvent actionEvent) {
        LocalDate fromDate = FromDateDP.getValue();
        LocalDate toDate   = ToDateDP.getValue();

        if (fromDate == null) {
            showWarning("Please select a From Date.");
            return;
        }
        if (toDate == null) {
            showWarning("Please select a To Date.");
            return;
        }
        if (fromDate.isAfter(toDate)) {
            showWarning("From Date cannot be after To Date.");
            return;
        }

        String report = generateReport(fromDate, toDate);
        ReportShowTA.setText(report);
    }

    private String generateReport(LocalDate from, LocalDate to) {
        // Sample import data — replace with real DB data later
        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("         IMPORT REPORT                  \n");
        sb.append("========================================\n");
        sb.append("From Date  : ").append(from).append("\n");
        sb.append("To Date    : ").append(to).append("\n");
        sb.append("----------------------------------------\n");
        sb.append(String.format("%-10s %-15s %-10s %-10s\n",
                "Import ID", "Item Name", "Quantity", "Status"));
        sb.append("----------------------------------------\n");

        sb.append(String.format("%-10s %-15s %-10s %-10s\n",
                "IMP-001", "Electronics", "50",  "Completed"));
        sb.append(String.format("%-10s %-15s %-10s %-10s\n",
                "IMP-002", "Clothing",    "120", "Shipped"));
        sb.append(String.format("%-10s %-15s %-10s %-10s\n",
                "IMP-003", "Furniture",   "30",  "Pending"));
        sb.append(String.format("%-10s %-15s %-10s %-10s\n",
                "IMP-004", "Food Items",  "200", "Completed"));
        sb.append(String.format("%-10s %-15s %-10s %-10s\n",
                "IMP-005", "Med Tools",   "75",  "Pending"));

        sb.append("----------------------------------------\n");
        sb.append("Total Imports  : 5\n");
        sb.append("Completed      : 2\n");
        sb.append("Shipped        : 1\n");
        sb.append("Pending        : 2\n");
        sb.append("========================================\n");

        return sb.toString();
    }
    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}