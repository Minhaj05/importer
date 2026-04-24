package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class update_import_statuscontroller {


    @FXML
    private TableColumn<ImportOrder, String> ImportIdTC;
    @FXML
    private TableColumn<ImportOrder, String> itemNameTC;
    @FXML
    private TableColumn<ImportOrder, String> StatusTC;
    @FXML
    private TableView<ImportOrder> UpdateImportStatusTV;
    @FXML
    private ComboBox<String>StatusComboBox;

    @FXML
    private Label UpdateImportStatusLBL;

    private ObservableList<ImportOrder> dataList = FXCollections.observableArrayList();

    public void initialize() {
        ImportIdTC.setCellValueFactory(new PropertyValueFactory<>("importId"));
        itemNameTC.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        dataList.add(new ImportOrder("IMP-001", "Electronics",   "Pending"));
        dataList.add(new ImportOrder("IMP-002", "Clothing",      "Shipped"));
        dataList.add(new ImportOrder("IMP-003", "Furniture",     "Pending"));
        dataList.add(new ImportOrder("IMP-004", "Food Items",    "Completed"));
        dataList.add(new ImportOrder("IMP-005", "Medical Tools", "Pending"));

        UpdateImportStatusTV.setItems(dataList);

        StatusComboBox.setItems(FXCollections.observableArrayList(
                "Pending", "Shipped", "Completed"
        ));
        StatusComboBox.setValue("Pending"); // default
    }

    @FXML
    public void UpdateButton(ActionEvent actionEvent) {
        ImportOrder selected = UpdateImportStatusTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select an import row to update.");
            alert.showAndWait();
            return;
        }

        String newStatus = StatusComboBox.getValue();

        if (selected.getStatus().equals(newStatus)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Change");
            alert.setHeaderText(null);
            alert.setContentText("Import ID " + selected.getImportId() +
                    " is already set to \"" + newStatus + "\".");
            alert.showAndWait();
            return;
        }


        selected.setStatus(newStatus);
        UpdateImportStatusTV.refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Status Updated");
        alert.setHeaderText(null);
        alert.setContentText(
                "Import Status Updated Successfully!\n\n" +
                        "Import ID  : " + selected.getImportId()  + "\n" +
                        "Item Name  : " + selected.getItemName()  + "\n" +
                        "New Status : " + selected.getStatus()
        );
        alert.showAndWait();
    }

    public ComboBox<String> getStatusComboBox() {
        return StatusComboBox;
    }

    public void setStatusComboBox(ComboBox<String> statusComboBox) {
        StatusComboBox = statusComboBox;
    }

    public static class ImportOrder {
        private String importId;
        private String itemName;
        private String status;

        public ImportOrder(String importId, String itemName, String status) {
            this.importId = importId;
            this.itemName = itemName;
            this.status   = status;
        }

        public String getImportId() { return importId; }
        public String getItemName() { return itemName; }
        public String getStatus()   { return status; }

        public void setStatus(String status) { this.status = status; }
    }
}