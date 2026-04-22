package com.spring26.section2.group15.importer.Minhaj;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class customer_view_carsCONTROLLER
{
    @javafx.fxml.FXML
    private TableView carlistTableView;
    @javafx.fxml.FXML
    private TableColumn carlistTableCol;
    @javafx.fxml.FXML
    private TableColumn modelTableCol;
    @javafx.fxml.FXML
    private TableColumn priceTableCol;
    @javafx.fxml.FXML
    private TableColumn brandTableCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void BookCarOnclick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void ViewDetailsOnClick(ActionEvent actionEvent) {
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