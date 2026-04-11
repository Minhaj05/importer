package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class record_car_detailscontroller {

    private Label RecordCarDetailsLBL;
    private TextField CarModelTF;
    private TextField EngineNoTF;
    private TextField ChassisNoTF;
    private ComboBox<String> ConditionCB;

    public void initialize() {
        CarModelTF.setPromptText("e.g. Toyota Corolla 2022");
        EngineNoTF.setPromptText("e.g. ENG-00123");
        ChassisNoTF.setPromptText("e.g. CHS-00456");

        ConditionCB.setItems(FXCollections.observableArrayList(
                "Brand New", "Reconditioned", "Used"
        ));
        ConditionCB.setValue("Brand New"); // default
    }L
    public void saveButton(ActionEvent actionEvent) {
        String carModel   = CarModelTF.getText().trim();
        String engineNo   = EngineNoTF.getText().trim();
        String chassisNo  = ChassisNoTF.getText().trim();
        String condition  = ConditionCB.getValue();

        if (carModel.isEmpty()) {
            showWarning("Please enter the Car Model.");
            return;
        }

        if (engineNo.isEmpty()) {
            showWarning("Please enter the Engine No.");
            return;
        }

        if (chassisNo.isEmpty()) {
            showWarning("Please enter the Chassis No.");
            return;
        }

        if (condition == null) {
            showWarning("Please select the car Condition.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Save");
        confirm.setHeaderText(null);
        confirm.setContentText(
                "Are you sure you want to save this car record?\n\n" +
                        "Car Model  : " + carModel  + "\n" +
                        "Engine No  : " + engineNo  + "\n" +
                        "Chassis No : " + chassisNo + "\n" +
                        "Condition  : " + condition
        );

        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {


                Alert success = new Alert(Alert.AlertType.INFORMATION);
                success.setTitle("Car Details Saved");
                success.setHeaderText(null);
                success.setContentText(
                        "Car Details Recorded Successfully!\n\n" +
                                "Car Model  : " + carModel  + "\n" +
                                "Engine No  : " + engineNo  + "\n" +
                                "Chassis No : " + chassisNo + "\n" +
                                "Condition  : " + condition
                );
                success.showAndWait();


                clearFields();
            }
        });
    }

    private void showWarning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Input");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void clearFields() {
        CarModelTF.clear();
        EngineNoTF.clear();
        ChassisNoTF.clear();
        ConditionCB.setValue("Brand New");
    }
}