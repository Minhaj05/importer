package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class financial_reportcontroller {


    private Label FinancialReportLBL;     // Title label
    private DatePicker FromDateDP;        // From Date picker
    private DatePicker ToDateDP;          // To Date picker
    private TextArea GeneratedReportTA;   // Report output area

    public void initialize() {
        // Make the report area read-only so user cannot type in it
        GeneratedReportTA.setEditable(false);
        GeneratedReportTA.setWrapText(true);
        GeneratedReportTA.setPromptText("Report will appear here...");

        System.out.println("Financial Report Screen Loaded.");
    }



    @FXML
    public void generateButton(ActionEvent actionEvent) {

        LocalDate fromDate = FromDateDP.getValue();
        LocalDate toDate   = ToDateDP.getValue();

        if (fromDate == null) {
            GeneratedReportTA.setText("ERROR: Please select a From Date.");
            return;
        }
        if (toDate == null) {
            GeneratedReportTA.setText("ERROR: Please select a To Date.");
            return;
        }
        if (fromDate.isAfter(toDate)) {
            GeneratedReportTA.setText("ERROR: From Date cannot be after To Date.");
            return;
        }

        String report = buildReport(fromDate, toDate);
        GeneratedReportTA.setText(report);

        System.out.println("Report generated from " + fromDate + " to " + toDate);
    }


    private String buildReport(LocalDate from, LocalDate to) {
        // Replace this section with real DB queries when ready
        int    totalImports   = 25;       // example data
        int    totalCars      = 120;      // example data
        double totalCost      = 450000.0; // example data
        double totalRevenue   = 520000.0; // example data
        double profit         = totalRevenue - totalCost;

        return  "==============================\n" +
                "       FINANCIAL REPORT       \n" +
                "==============================\n" +
                "Period   : " + from + "  to  " + to + "\n" +
                "------------------------------\n" +
                "Total Imports  : " + totalImports  + "\n" +
                "Total Cars     : " + totalCars      + "\n" +
                "Total Cost     : $" + totalCost     + "\n" +
                "Total Revenue  : $" + totalRevenue  + "\n" +
                "------------------------------\n" +
                "Net Profit     : $" + profit        + "\n" +
                "==============================";
    }
}