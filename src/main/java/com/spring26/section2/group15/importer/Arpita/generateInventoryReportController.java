package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class generateInventoryReportController {

    @FXML
    private TextArea reportOutputTArea;

    @FXML
    public void generateReportButton(ActionEvent event) {

        ArrayList<car> carList = FileHelper.loadCars();

        StringBuilder report = new StringBuilder();

        report.append("===== INVENTORY REPORT =====\n\n");

        for (car c : carList) {
            report.append("Model: ").append(c.getModel()).append("\n");
            report.append("Price: ").append(c.getPrice()).append("\n");
            report.append("Status: ").append(c.getStatus()).append("\n");
            report.append("----------------------\n");
        }

        if (carList.isEmpty()) {
            reportOutputTArea.setText("No cars in inventory!");
        } else {
            reportOutputTArea.setText(report.toString());
        }
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/user3InventorydDashboard.fxml");
    }
}