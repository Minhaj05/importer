package com.spring26.section2.group15.importer.Shafuath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class manager_sale_approvalCONTROLLER implements Initializable {

    @FXML
    private TableView<SaleRecord> approveSaleTableView;

    @FXML
    private TableColumn<SaleRecord, String> saleTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set up the column to read the "sale" property from SaleRecord class
        saleTable.setCellValueFactory(new PropertyValueFactory<>("sale"));

        // Load sale records into the table on startup
        loadSaleData();
    }

    // Load pending sale records into the TableView
    private void loadSaleData() {
        ObservableList<SaleRecord> saleList = FXCollections.observableArrayList(
                // TODO: Replace with real DB query results
                new SaleRecord("Jesika - Toyota")
        );
        saleTable.setText(saleList.toString());

    }
}

