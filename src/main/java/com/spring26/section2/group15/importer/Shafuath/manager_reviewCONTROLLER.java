package com.spring26.section2.group15.importer.Shafuath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class manager_reviewCONTROLLER implements Initializable {

    @FXML
    private Label EmployeeReviewLabel;

    @FXML
    private TableView<EmployeeReview> employeeReviewTableView;

    @FXML
    private TableColumn<EmployeeReview, String> employeeTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up the column to read the "review" property from EmployeeReview class
        employeeTable.setCellValueFactory(new PropertyValueFactory<>("review"));

        // Load reviews into the table on startup
        loadReviewData();
    }

    // Load employee review data into the TableView
    private void loadReviewData() {
        ObservableList<EmployeeReview> reviewList = FXCollections.observableArrayList(
                // TODO: Replace with real DB query results
                new EmployeeReview("John  - Excellent performance this quarter."),
                new EmployeeReview("Jane  - Needs improvement in punctuality."),
                new EmployeeReview("Nusu - Outstanding sales numbers."),
                new EmployeeReview("Sara Khan - Great team collaboration skills."),
                new EmployeeReview("Tilottoma - Met all targets successfully.")
        );

        employeeReviewTableView.setItems(reviewList);
    }

    // Called when the Review button is clicked
    @FXML
    void reviewButton(ActionEvent actionEvent) {
        // Get the selected review from the table
        EmployeeReview selectedReview = employeeReviewTableView.getSelectionModel().getSelectedItem();

        if (selectedReview != null) {
            System.out.println("Selected: " + selectedReview.getReview());
        } else {
            System.out.println("No review selected.");
        }
    }

} // This last brace is CRITICAL to close the class