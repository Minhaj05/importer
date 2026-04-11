package com.spring26.section2.group15.importer.tabassum;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class generate_reportcontroller {

    @FXML private DatePicker FromDateDP;
    @FXML private DatePicker ToDateDP;
    @FXML private TextArea ReportShowTA;
    @FXML private Label ImportReportLBL;

    @FXML
    public void GenerateButton() {

        if (FromDateDP.getValue() == null || ToDateDP.getValue() == null) {
            ImportReportLBL.setText("Select dates!");
            return;
        }

        String report = "Import Report\n\nFrom: " +
                FromDateDP.getValue() +
                "\nTo: " + ToDateDP.getValue() +
                "\n\nTotal Cars: 10\nTotal Cost: 100000";

        ReportShowTA.setText(report);
    }
}