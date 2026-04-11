package com.spring26.section2.group15.importer.Shafuath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class admin_update_accessCONTROLLER implements Initializable {

    @FXML
    private ComboBox<String> userselectComBox;

    @FXML
    private CheckBox ReadAcessChkBox;

    @FXML
    private CheckBox WriteAcessChkBox;

    @FXML
    private CheckBox DeleteAcessChkBox;

    @FXML
    private Label statusLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Load users into ComboBox
        ObservableList<String> userList = FXCollections.observableArrayList(
                "User1",
                "User2",
                "User3"
                // Replace these with real usernames from your database
        );
        userselectComBox.setItems(userList);

        // Listen for user selection and auto-load their current access rights
        userselectComBox.setOnAction(event -> loadUserAccess());

        statusLabel.setText("");
    }

    // Called when a user is selected from the ComboBox
    private void loadUserAccess() {
        String selectedUser = userselectComBox.getValue();
        if (selectedUser == null) return;

        // TODO: Replace this block with a real DB query to fetch current access rights
        // Example logic (hardcoded for now):
        if (selectedUser.equals("User1")) {
            ReadAcessChkBox.setSelected(true);
            WriteAcessChkBox.setSelected(false);
            DeleteAcessChkBox.setSelected(false);
        } else if (selectedUser.equals("User2")) {
            ReadAcessChkBox.setSelected(true);
            WriteAcessChkBox.setSelected(true);
            DeleteAcessChkBox.setSelected(false);
        } else {
            ReadAcessChkBox.setSelected(false);
            WriteAcessChkBox.setSelected(false);
            DeleteAcessChkBox.setSelected(false);
        }

        statusLabel.setStyle("-fx-text-fill: blue;");
        statusLabel.setText("Loaded access rights for: " + selectedUser);
    }

    // Called when the Update button is clicked
    @FXML
    private void updateAccessBtn() {
        String selectedUser = userselectComBox.getValue();

        // Validation: make sure a user is selected
        if (selectedUser == null || selectedUser.isEmpty()) {
            statusLabel.setStyle("-fx-text-fill: red;");
            statusLabel.setText("Please select a user before updating.");
            return;
        }

        boolean canRead   = ReadAcessChkBox.isSelected();
        boolean canWrite  = WriteAcessChkBox.isSelected();
        boolean canDelete = DeleteAcessChkBox.isSelected();

        // TODO: Replace this block with your actual DB update logic
        // Example:
        // DatabaseHelper.updateAccess(selectedUser, canRead, canWrite, canDelete);

        System.out.println("Updating access for: " + selectedUser);
        System.out.println("  Read   : " + canRead);
        System.out.println("  Write  : " + canWrite);
        System.out.println("  Delete : " + canDelete);

        // Show success message
        statusLabel.setStyle("-fx-text-fill: green;");
        statusLabel.setText("Access rights updated successfully for: " + selectedUser);
    }
}
