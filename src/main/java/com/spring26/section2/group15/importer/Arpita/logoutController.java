package com.spring26.section2.group15.importer.Arpita;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class logoutController
{
    @javafx.fxml.FXML
    private Label logoutLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void cancelButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/login.fxml");
    }

    @javafx.fxml.FXML
    public void confirmLogoutButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/login.fxml");


        }
}