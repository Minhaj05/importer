package com.spring26.section2.group15.importer.Shafuath;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;

import java.io.File;

public class admin_restoreCONTROLLER {

    @FXML
    private Label statusLabel;

    @FXML
    private Label fileNameLabel;

    @FXML
    private Label fileNameLabel1;

    @FXML
    private ProgressBar progressBar;

    private File selectedFile;

    // 🔴 SELECT FILE BUTTON
    @FXML
    private void selectFileBtn() {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Backup File");

        selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            fileNameLabel.setText("Selected File: " + selectedFile.getName());
            fileNameLabel1.setText("Ready to restore: " + selectedFile.getName());
            statusLabel.setText("File Selected Successfully ✅❤️");
        } else {
            statusLabel.setText("No file selected ❌");
        }
    }

    // 🔵 RESTORE BUTTON
    @FXML
    private void restoreBtn() {

        if (selectedFile == null) {
            statusLabel.setText("Please select a file first ‼️‼️‼️");
            return;
        }

        // 🟡 Start restore
        statusLabel.setText("Restoring...");
        progressBar.setProgress(0.3);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        progressBar.setProgress(0.7);
        statusLabel.setText("Processing Restore...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 🟢 Complete
        progressBar.setProgress(1.0);
        statusLabel.setText("Restore Completed Successfully ✅❤️");
    }
}