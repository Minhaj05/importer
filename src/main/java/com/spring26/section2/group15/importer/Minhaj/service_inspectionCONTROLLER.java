package com.spring26.section2.group15.importer.Minhaj;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class service_inspectionCONTROLLER
{
    @javafx.fxml.FXML
    private TextArea inspectionnoteTetxArea;
    @javafx.fxml.FXML
    private TableColumn brandCol;
    @javafx.fxml.FXML
    private ComboBox conditionComboBox;
    @javafx.fxml.FXML
    private TableView carlist;
    @javafx.fxml.FXML
    private TableColumn modelCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void SaveinspectionOnClick(ActionEvent actionEvent) {
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