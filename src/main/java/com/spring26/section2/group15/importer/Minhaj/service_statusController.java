package com.spring26.section2.group15.importer.Minhaj;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class service_statusController
{
    @javafx.fxml.FXML
    private ComboBox statusComboBox;
    @javafx.fxml.FXML
    private TableColumn carCol;
    @javafx.fxml.FXML
    private TableView serviceTable;
    @javafx.fxml.FXML
    private TableColumn currentstatusCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void UpdateOnClick(ActionEvent actionEvent) {
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