package com.spring26.section2.group15.importer.tabassum;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class financial_reportcontroller {

    @FXML private DatePicker FromDateDP;
    @FXML private DatePicker ToDateDP;
    @FXML private TextArea GeneratedReportTA;
    @FXML private Label FinancialReportLBL;

    @FXML
    public void generateButton() {

        if (FromDateDP.getValue() == null || ToDateDP.getValue() == null) {
            FinancialReportLBL.setText("Select dates!");
            return;
        }

        String from = FromDateDP.getValue().toString();
        String to = ToDateDP.getValue().toString();

        // simple demo report
        String report = "Financial Report\n\nFrom: " + from +
                "\nTo: " + to +
                "\n\nTotal Import Cost: 50000\nProfit: 15000";

        GeneratedReportTA.setText(report);
    }
}