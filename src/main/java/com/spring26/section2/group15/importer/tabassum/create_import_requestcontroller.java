package com.spring26.section2.group15.importer.tabassum;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class create_import_requestcontroller {

    @FXML private TextField sourceCountryTF;
    @FXML private TextField quantityTF;
    @FXML private DatePicker importDateDP;
    @FXML private ComboBox<String> carTypeCB;
    @FXML private Label CreateImportRequestLBL;

    @FXML
    public void initialize() {
        carTypeCB.getItems().addAll("Sedan", "SUV", "Truck");
    }

    @FXML
    public void submitButton() {
        if (sourceCountryTF.getText().isEmpty() ||
                quantityTF.getText().isEmpty() ||
                carTypeCB.getValue() == null ||
                importDateDP.getValue() == null) {

            CreateImportRequestLBL.setText("Fill all fields!");
            return;
        }

        CreateImportRequestLBL.setText("Submitted!");
    }

    @FXML
    public void resetButton() {
        sourceCountryTF.clear();
        quantityTF.clear();
        carTypeCB.setValue(null);
        importDateDP.setValue(null);
    }
}