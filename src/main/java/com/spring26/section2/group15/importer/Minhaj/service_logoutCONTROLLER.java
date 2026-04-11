package com.spring26.section2.group15.importer.Minhaj;

import javafx.event.ActionEvent;

public class service_logoutCONTROLLER
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void NoClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void YesClick(ActionEvent actionEvent) {
        SceneSwitcher.go(actionEvent, "customer_login.fxml");
    }
    protected void switchScene(String fxml, javafx.event.ActionEvent event) throws Exception {
        javafx.scene.Parent root = javafx.fxml.FXMLLoader.load(
                getClass().getResource("/com/spring26/section2/group15/importer/Minhaj/" + fxml)
        );
        javafx.stage.Stage stage =
                (javafx.stage.Stage) ((javafx.scene.control.Button) event.getSource())
                        .getScene().getWindow();

        stage.setScene(new javafx.scene.Scene(root));
    }
}