package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class financial_reportcontroller
{
    @javafx.fxml.FXML
    private Label FinancialReportLBL;
    @javafx.fxml.FXML
    private TextArea GeneratedReportTA;
    @javafx.fxml.FXML
    private DatePicker ToDateDP;
    @javafx.fxml.FXML
    private DatePicker FromDateDP;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void generateButton(ActionEvent actionEvent) {
    }
}