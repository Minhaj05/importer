package com.spring26.section2.group15.importer.Minhaj;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {

    private static final String BASE =
            "/com/spring26/section2/group15/importer/Minhaj/";

    public static void go(ActionEvent event, String fxmlFile) {
        try {
            var url = SceneSwitcher.class.getResource(BASE + fxmlFile);
            if (url == null) {
                System.err.println("FXML not found: " + fxmlFile);
                return;
            }
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

