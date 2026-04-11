package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class view_import_historycontroller {

    private TableColumn<ImportHistory, Integer> IdTC;
    private TableColumn<ImportHistory, String> SourceTC;
    private TableColumn<ImportHistory, Integer> QuantityTC;
    private TableColumn<ImportHistory, String> DateTC;
    private TableColumn<ImportHistory, String> StatusTC;
    private TableView<ImportHistory> importHistoryTV;

    private ObservableList<ImportHistory> dataList = FXCollections.observableArrayList();

    public void initialize() {
        IdTC.setCellValueFactory(new PropertyValueFactory<>("id"));
        SourceTC.setCellValueFactory(new PropertyValueFactory<>("source"));
        QuantityTC.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        DateTC.setCellValueFactory(new PropertyValueFactory<>("date"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        dataList.add(new ImportHistory(1, "Supplier A", 100, "2025-01-10", "Completed"));
        dataList.add(new ImportHistory(2, "Supplier B", 50,  "2025-02-15", "Pending"));
        dataList.add(new ImportHistory(3, "Supplier C", 200, "2025-03-20", "Completed"));

        importHistoryTV.setItems(dataList);
    }

    public void viewDetailsButton(ActionEvent actionEvent) {
        ImportHistory selected = importHistoryTV.getSelectionModel().getSelectedItem();

        if (selected != null) {
            // Show details in an alert popup
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Import Details");
            alert.setHeaderText("Selected Import Record");
            alert.setContentText(
                    "ID       : " + selected.getId() + "\n" +
                            "Source   : " + selected.getSource() + "\n" +
                            "Quantity : " + selected.getQuantity() + "\n" +
                            "Date     : " + selected.getDate() + "\n" +
                            "Status   : " + selected.getStatus()
            );
            alert.showAndWait();
        } else {
            // Show warning if nothing is selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a row to view details.");
            alert.showAndWait();
        }
    }

    public static class ImportHistory {
        private int id;
        private String source;
        private int quantity;
        private String date;
        private String status;

        public ImportHistory(int id, String source, int quantity, String date, String status) {
            this.id = id;
            this.source = source;
            this.quantity = quantity;
            this.date = date;
            this.status = status;
        }

        // Getters — required by PropertyValueFactory
        public int getId()         { return id; }
        public String getSource()  { return source; }
        public int getQuantity()   { return quantity; }
        public String getDate()    { return date; }
        public String getStatus()  { return status; }
    }
}