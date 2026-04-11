package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class accountant_logoutcontroller {


    private Label AccountantLogoutLBL;   // "Accountant Logout" title label

    private Label AreYouSureLBL;         // "Are You Sure?" label

    private Button AccountantNoBtn;      // "No" button (fix fx:id in FXML too)


    public void initialize() {
        // You can set any default values here if needed
        System.out.println("Accountant Logout Screen Loaded.");
    }


    public void YesButton(ActionEvent actionEvent) {
        try {
            // Load the Login screen FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/spring26/section2/group15/importer/tabassum/Login.fxml"));
            Parent root = loader.load();

            // Get the current stage from the button click event
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Switch to Log in scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();

            System.out.println("Logged out. Redirected to Login screen.");

        } catch (IOException e) {
            System.out.println("ERROR: Login.fxml not found. Check the file path.");
            e.printStackTrace();
        }
    }

    // ─── NO Button → Go back to Accountant Dashboard ─────────────

    public void NoButton(ActionEvent actionEvent) {
        try {
            // Load the Accountant Dashboard FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/spring26/section2/group15/importer/tabassum/AccountantDashboard.fxml"));
            Parent root = loader.load();

            // Get the current stage
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Switch to Dashboard scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Accountant Dashboard");
            stage.show();

            System.out.println("Logout cancelled. Back to Dashboard.");

        } catch (IOException e) {
            System.out.println("ERROR: AccountantDashboard.fxml not found. Check the file path.");
            e.printStackTrace();
        }
    }
}