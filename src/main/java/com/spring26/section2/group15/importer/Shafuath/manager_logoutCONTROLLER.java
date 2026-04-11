package com.spring26.section2.group15.importer.Shafuath;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class manager_logoutCONTROLLER implements Initializable {

    @FXML
    private Button logoutBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Nothing to initialize for this simple screen
    }

    // Called when the Logout button is clicked
    @FXML
    private void logoutBtn(ActionEvent event) {
        try {
            // Close the current window
            Stage currentStage = (Stage) logoutBtn.getScene().getWindow();
            currentStage.close();

            // Load the Login screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/spring26/section2/group15/importer/Shafuath/login.fxml"));
            Parent root = loader.load();

            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(root));
