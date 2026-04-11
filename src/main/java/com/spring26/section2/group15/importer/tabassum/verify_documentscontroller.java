package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class verify_documentscontroller {

    @FXML
    private TableColumn<Document, Integer> DocumentIdTC;
    @FXML
    private TableColumn<Document, String> TypeTC;
    @FXML
    private TableColumn<Document, String> statusTC;
    @FXML
    private TableView<Document> VerifyDocumentsTV;
    @FXML
    private ComboBox<String> StatusCB;

    // ✅ Full data list and filtered list
    private ObservableList<Document> allData    = FXCollections.observableArrayList();
    private ObservableList<Document> filterData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // ✅ Link columns to model fields
        DocumentIdTC.setCellValueFactory(new PropertyValueFactory<>("documentId"));
        TypeTC.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        // ✅ Sample data
        allData.add(new Document(1001, "Invoice",       "Pending"));
        allData.add(new Document(1002, "Contract",      "Verified"));
        allData.add(new Document(1003, "Receipt",       "Pending"));
        allData.add(new Document(1004, "Tax Form",      "Rejected"));
        allData.add(new Document(1005, "Import Permit", "Pending"));

        // ✅ Load all data into table
        VerifyDocumentsTV.setItems(allData);

        // ✅ ComboBox options for filtering
        StatusCB.setItems(FXCollections.observableArrayList(
                "All", "Pending", "Verified", "Rejected"
        ));
        StatusCB.setValue("All"); // default selection
    }

    // ✅ View button — filters table by selected status
    @FXML
    public void ViewButton(ActionEvent actionEvent) {
        String selected = StatusCB.getValue();

        if (selected == null || selected.equals("All")) {
            // Show all records
            VerifyDocumentsTV.setItems(allData);
        } else {
            // Filter records by status
            filterData.clear();
            for (Document doc : allData) {
                if (doc.getStatus().equals(selected)) {
                    filterData.add(doc);
                }
            }
            VerifyDocumentsTV.setItems(filterData);
        }
    }

    // ✅ Confirm button — marks selected row as Verified
    @FXML
    public void confirmButton(ActionEvent actionEvent) {
        Document selected = VerifyDocumentsTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            // No row selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a document row to confirm.");
            alert.showAndWait();
            return;
        }

        if (selected.getStatus().equals("Verified")) {
            // Already verified
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Already Verified");
            alert.setHeaderText(null);
            alert.setContentText("Document ID " + selected.getDocumentId() + " is already verified.");
            alert.showAndWait();
            return;
        }

        // ✅ Update status to Verified
        selected.setStatus("Verified");
        VerifyDocumentsTV.refresh();

        // Success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Document Confirmed");
        alert.setHeaderText(null);
        alert.setContentText(
                "Document Verified Successfully!\n\n" +
                        "Document ID : " + selected.getDocumentId() + "\n" +
                        "Type        : " + selected.getType() + "\n" +
                        "Status      : " + selected.getStatus()
        );
        alert.showAndWait();
    }

    // ✅ Model class — one object = one row in the table
    public static class Document {
        private int documentId;
        private String type;
        private String status;

        public Document(int documentId, String type, String status) {
            this.documentId = documentId;
            this.type       = type;
            this.status     = status;
        }

        // Getters — required by PropertyValueFactory
        public int    getDocumentId() { return documentId; }
        public String getType()       { return type; }
        public String getStatus()     { return status; }

        // Setter — needed to update status on Confirm
        public void setStatus(String status) { this.status = status; }
    }
}