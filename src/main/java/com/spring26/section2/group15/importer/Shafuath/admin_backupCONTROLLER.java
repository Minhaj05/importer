package com.spring26.section2.group15.importer.Shafuath;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class admin_backupCONTROLLER {

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label statusLabel;

    // BUTTON ACTION (must match FXML: #backupBtn)
    @FXML
    private void backupBtn() {

        // Start Backup
        statusLabel.setText("Backup Started...");
        progressBar.setProgress(0.3);

        // Simulate process
        try {
            Thread.sleep(500); // delay (simulation)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        progressBar.setProgress(0.7);
        statusLabel.setText("Processing Backup...");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Complete Backup
        progressBar.setProgress(1.0);
        statusLabel.setText("Backup Completed Successfully ✅");
    }
}