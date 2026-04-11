package com.spring26.section2.group15.importer.Shafuath;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class admin_logoutCONTROLLER {

    @FXML
    private Label messageLabel;

    // 🔴 YES BUTTON (Logout)
    @FXML
    private void yesBtn() {

        // 🟢 Show logout message
        messageLabel.setText("Logged out successfully ✅");

        // 🔵 You can later add scene switching here
        System.out.println("User logged out");
    }

    // 🟡 NO BUTTON (Cancel)
    @FXML
    private void noBtn() {

        // 🔵 Cancel logout
        messageLabel.setText("Logout cancelled ❌");

        System.out.println("Logout cancelled");
    }
}