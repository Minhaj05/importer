package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class import_officer_logoutcontroller {
    private Label import_officer_logoutLBL;   // Title label

    public void initialize() {
        System.out.println("Import Officer Logout Screen Loaded.");
    }

    public void yesButton(ActionEvent actionEvent) {

        try {
            // Load the Login screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/spring26/section2/group15/importer/tabassum/Login.fxml"));
            Parent root = loader.load();

            // Get current window
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Switch to Login screen
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();

            System.out.println("Logged out. Redirected to Login screen.");

        } catch (IOException e) {
            System.out.println("ERROR: Login.fxml not found. Check the file path.");
            e.printStackTrace();
        }
    }



    public void NoButton(ActionEvent actionEvent) {

        try {
            // Load the Import Officer Dashboard screen
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/spring26/section2/group15/importer/tabassum/ImportOfficerDashboard.fxml"));
            Parent root = loader.load();

            // Get current window
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Switch to Dashboard screen
            stage.setScene(new Scene(root));
            stage.setTitle("Import Officer Dashboard");
            stage.show();

            System.out.println("Logout cancelled. Back to Dashboard.");

        } catch (IOException e) {
            System.out.println("ERROR: ImportOfficerDashboard.fxml not found. Check the file path.");
            e.printStackTrace();
        }
    }
}