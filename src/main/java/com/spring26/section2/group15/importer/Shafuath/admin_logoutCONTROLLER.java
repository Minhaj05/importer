package com.spring26.section2.group15.importer.Shafuath;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class admin_logoutCONTROLLER {

    @FXML
    private Label messageLabel;

    // 🔴 YES BUTTON (Logout)

    @FXML
    private void yesBtn(ActionEvent event) {
        try {
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/spring26/section2/group15/importer/Arpita/user3-InventorydDashboard.fxml"
            ));
            javafx.scene.Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Dashboard");
            newStage.setScene(new javafx.scene.Scene(root));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🟡 NO BUTTON (Cancel)
    @FXML
    private void noBtn() {

        // 🔵 Cancel logout
        messageLabel.setText("Logout cancelled ❌");

        System.out.println("Logout cancelled");
    }
}