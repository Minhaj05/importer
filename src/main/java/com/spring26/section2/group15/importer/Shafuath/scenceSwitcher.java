package com.spring26.section2.group15.importer.Shafuath;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

class SceneSwitcher {

    public static void switchScene(ActionEvent event, String fxmlFile) {
        try {
            var url = SceneSwitcher.class.getResource(fxmlFile);

            if (url == null) {
                throw new RuntimeException("FXML not found: " + fxmlFile);
            }

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource())
                    .getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}