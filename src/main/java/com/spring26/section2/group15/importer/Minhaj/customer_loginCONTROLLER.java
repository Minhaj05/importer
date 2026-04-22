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
    public void LoginOnClick(ActionEvent actionEvent) { String email = emailTextField.getText();
        String pass = passwordTextField.getText();

        if (email.isEmpty() || pass.isEmpty()) {
            System.out.println("Email or Password!");
            return;
        }
        SceneSwitcher.go(actionEvent, "customer_view_cars.fxml");
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