package com.spring26.section2.group15.importer.Shafuath;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class manager_logoutCONTROLLER {

    @FXML
    private Button logoutBtn;

    @FXML
    private void logoutBtn(ActionEvent event) {
        try {
            Stage currentStage = (Stage) logoutBtn.getScene().getWindow();
            currentStage.close();

            //  Goes back to the Inventory Dashboard (your current start screen)
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/com/spring26/section2/group15/importer/Arpita/user3-InventorydDashboard.fxml"
            ));
            Parent root = loader.load();

            Stage newStage = new Stage();
            newStage.setTitle("Dashboard");
            newStage.setScene(new Scene(root));
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading dashboard screen.");
        }
    }
}

