package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;    // Correct JavaFX import
import javafx.scene.control.Label;     // Correct JavaFX import
import javafx.stage.Stage;

public class accountant_logoutcontroller {

    @javafx.fxml.FXML
    private Label AccountantLogoutLBL;

    @javafx.fxml.FXML
    private Label AreYouSureLBL;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void YesButton(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/spring26/section2/group15/importer/tabassum/user3dashboard.fxml"
            ));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Dashboard");
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void NoButton(ActionEvent actionEvent) {
        // Just close the logout dialog — do nothing else
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}