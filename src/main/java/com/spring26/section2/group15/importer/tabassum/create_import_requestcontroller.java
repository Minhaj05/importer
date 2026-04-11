package com.spring26.section2.group15.importer.tabassum;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class create_import_requestcontroller {



    private TextField sourceCountryTF;       // Source Country input
    private TextField quantityTF;            // Quantity input
    private DatePicker importDateDP;         // Import Date picker
    private ComboBox<String> carTypeCB;      // Car Type dropdown
    private Label CreateImportRequestLBL;    // Title label

    public void initialize() {

        // Fill Car Type dropdown with options
        carTypeCB.setItems(FXCollections.observableArrayList(
                "Sedan",
                "SUV",
                "Truck",
                "Van",
                "Electric",
                "Hybrid"
        ));

        System.out.println("Create Import Request Screen Loaded.");
    }

    public void submitButton(ActionEvent actionEvent) {

        // Read values from the form
        String sourceCountry = sourceCountryTF.getText().trim();
        String quantity      = quantityTF.getText().trim();
        String carType       = carTypeCB.getValue();
        LocalDate importDate = importDateDP.getValue();

        if (sourceCountry.isEmpty()) {
            System.out.println("ERROR: Source Country is empty!");
            return;
        }
        if (quantity.isEmpty()) {
            System.out.println("ERROR: Quantity is empty!");
            return;
        }
        if (carType == null) {
            System.out.println("ERROR: Please select a Car Type!");
            return;
        }
        if (importDate == null) {
            System.out.println("ERROR: Please select an Import Date!");
            return;
        }

        // ── All Good → Print the data (replace with DB save if needed) ──
        System.out.println("===== Import Request Submitted =====");
        System.out.println("Source Country : " + sourceCountry);
        System.out.println("Quantity       : " + quantity);
        System.out.println("Car Type       : " + carType);
        System.out.println("Import Date    : " + importDate);
        System.out.println("====================================");

        // ── Navigate to next screen after submit ──
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/spring26/section2/group15/importer/tabassum/AccountantDashboard.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Accountant Dashboard");
            stage.show();

        } catch (IOException e) {
            System.out.println("ERROR: AccountantDashboard.fxml not found. Check the path.");
            e.printStackTrace();
        }
    }


    // ─── RESET Button → Clear all fields ─────────────────────────
    @FXML
    public void resetButton(ActionEvent actionEvent) {

        sourceCountryTF.clear();
        quantityTF.clear();
        carTypeCB.setValue(null);
        importDateDP.setValue(null);

        System.out.println("Form has been reset.");
    }
}