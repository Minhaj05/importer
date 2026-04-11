package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class sales_logoutController {

    @FXML
    private Label logoutLable;

    @FXML
    public void logoutButton(ActionEvent event) {
        SceneSwitcher.switchScene(event,
                "/com/spring26/section2/group15/importer/Arpita/login.fxml");
    }

    @Deprecated
    public void cancelButton(ActionEvent event) {
        SceneSwitcher.switchScene(event,
                "/com/spring26/section2/group15/importer/Arpita/salesExecutiveDashboard.fxml");
    }


}