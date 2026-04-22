package com.spring26.section2.group15.importer.tabassum;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class record_car_detailscontroller {

    @FXML private TextField CarModelTF;
    @FXML private TextField EngineNoTF;
    @FXML private TextField ChassisNoTF;
    @FXML private ComboBox<String> ConditionCB;
    @FXML private Label RecordCarDetailsLBL;

    @FXML
    public void initialize() {
        ConditionCB.getItems().addAll("New", "Used");
    }

    @FXML
    public void saveButton() {

        if (CarModelTF.getText().isEmpty() ||
                EngineNoTF.getText().isEmpty() ||
                ChassisNoTF.getText().isEmpty() ||
                ConditionCB.getValue() == null) {

            RecordCarDetailsLBL.setText("Fill all fields!");
            return;
        }

        RecordCarDetailsLBL.setText("Saved!");
    }
}