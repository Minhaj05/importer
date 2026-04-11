package com.spring26.section2.group15.importer.tabassum;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class import_officer_logoutcontroller {

    @FXML private Label import_officer_logoutLBL;

    @FXML
    public void yesButton() {
        import_officer_logoutLBL.setText("Logged out!");
    }

    @FXML
    public void NoButton() {
        import_officer_logoutLBL.setText("Cancelled!");
    }
}