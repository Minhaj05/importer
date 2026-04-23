package com.spring26.section2.group15.importer.Shafuath;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class manager_summaryCONTROLLER implements Initializable {

    @FXML
    private Label summaryLabel;

    @FXML
    private Label totalSales;

    @FXML
    private Label totalCars;

    @FXML
    private Label revenue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load summary data when the screen opens
        loadSummaryData();
    }

    // Load and display summary statistics
    private void loadSummaryData() {

        // TODO: Replace these with real DB query results
        // Example:
        // int sales    = DatabaseHelper.getTotalSales();
        // int cars     = DatabaseHelper.getTotalCars();
        // double rev   = DatabaseHelper.getTotalRevenue();

        // Hardcoded sample data for now:
        int totalSalesCount = 120;
        int totalCarsCount = 85;
        double totalRevenue = 3_750_000.00;

        // Update the labels with fetched data
        totalSales.setText("Total Sales  :  " + totalSalesCount + " sales");
        totalCars.setText("Total Cars   :  " + totalCarsCount + " cars");
    }

}
