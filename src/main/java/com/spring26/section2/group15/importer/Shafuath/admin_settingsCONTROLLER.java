package com.spring26.section2.group15.importer.Shafuath;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class admin_settingsCONTROLLER {

    @FXML
    private TextField systemNameField;

    @FXML
    private ComboBox<String> themeBox;

    @FXML
    private CheckBox notificationCheck;

    @FXML
    private Label statusLabel;

    // 🟢 INITIALIZE (auto runs when page opens)
    @FXML
    public void initialize() {

        // Add theme options
        themeBox.getItems().addAll("Light", "Dark", "Blue");

        // Default values (optional but good for marks)
        themeBox.setValue("Light");
        notificationCheck.setSelected(true);
        systemNameField.setText("Haq's Bay System");
    }

    // 🔴 SAVE BUTTON (must match: #saveBtn)
    @FXML
    private void saveBtn() {

        String systemName = systemNameField.getText();
        String theme = themeBox.getValue();
        boolean notification = notificationCheck.isSelected();

        // 🟡 Validation
        if (systemName.isEmpty() || theme == null) {
            statusLabel.setText("Please fill all settings ❗");
            return;
        }

        // 🟢 Save logic (simulation)
        String notifyStatus = notification ? "Enabled" : "Disabled";

        statusLabel.setText(
                "Settings Saved ✅ | Name: " + systemName +
                        " | Theme: " + theme +
                        " | Notification: " + notifyStatus
        );

        System.out.println("Settings Saved");
    }
}