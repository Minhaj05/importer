package com.spring26.section2.group15.importer.Minhaj;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class customer_loginCONTROLLER
{
    @javafx.fxml.FXML
    private PasswordField passwordTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void LoginOnClick(ActionEvent actionEvent) {
    }
    protected void switchScene(String fxml, javafx.event.ActionEvent event) throws Exception {
        javafx.scene.Parent root = javafx.fxml.FXMLLoader.load(
                getClass().getResource("/view/" + fxml)
        );
        javafx.stage.Stage stage =
                (javafx.stage.Stage) ((javafx.scene.control.Button) event.getSource())
                        .getScene().getWindow();

        stage.setScene(new javafx.scene.Scene(root));
    }
}