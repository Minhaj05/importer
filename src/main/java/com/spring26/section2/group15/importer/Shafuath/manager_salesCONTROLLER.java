package com.spring26.section2.group15.importer.Shafuath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class manager_salesCONTROLLER implements Initializable {

    @FXML
    private Label titleLabel;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private TableView<SalesReport> salesReportTableView;

    @FXML
    private TableColumn<SalesReport, String> reportTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up the column to read the "report" property from SalesReport class
        reportTable.setCellValueFactory(new PropertyValueFactory<>("report"));

        // Set default date range: last 30 days to today
        toDate.setValue(LocalDate.now());
        fromDate.setValue(LocalDate.now().minusDays(30));
    }

    // Called when the Generate button is clicked
    @FXML
    private void generateBtn(ActionEvent event) {
        LocalDate from = fromDate.getValue();
        LocalDate to   = toDate.getValue();

        // Validation: check if both dates are selected
        if (from == null || to == null) {
            showAlert(AlertType.WARNING, "Missing Dates", "Please select both From and To dates.");
            return;
        }

        // Validation: check if From date is before To date
        if (from.isAfter(to)) {
            showAlert(AlertType.WARNING, "Invalid Date Range", "The From date must be before the To date.");
            return;
        }

        // Load the filtered report data
        loadReportData(from, to);
    }

    // Load sales report data into the TableView based on date range
    private void loadReportData(LocalDate from, LocalDate to) {
        ObservableList<SalesReport> reportList = FXCollections.observableArrayList();

        // TODO: Replace with real DB query filtered by date range
        // Example:
        // ResultSet rs = DatabaseHelper.getSalesReport(from, to);
        // while (rs.next()) {
        //     reportList.add(new SalesReport(rs.getString("report_details")));
        // }

        // Hardcoded sample data for now:
        reportList.addAll(
                new SalesReport("IBRAHIM Pasha - Toyota Corolla - $25,000 - " + from),
                new SalesReport("Nuzhat Tabassum - Honda Civic - $28,000 - " + from.plusDays(1)),
                new SalesReport("Tilottoma Tithi - Ford Mustang - $45,000 - " + from.plusDays(2)),
                new SalesReport("Sara Khan - BMW 3 Series - $55,000 - " + from.plusDays(3)),
                new SalesReport("Khondoker Ali - Mercedes C-Class - $60,000 - " + to)
        );

        salesReportTableView.setItems(reportList);

        System.out.println("Report generated from: " + from + " to: " + to);
        System.out.println("Total records found: " + reportList.size());
    }

    // Helper method to show alert dialogs
    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // -------------------------------------------------------
    // Inner Model Class (or move this to its own separate file)
    // -------------------------------------------------------
    public static class SalesReport {

        private String report;

        public SalesReport(String report) {
            this.report = report;
        }

        public String getReport() {
            return report;
        }

        public void setReport(String report) {
            this.report = report;
        }
    }
}