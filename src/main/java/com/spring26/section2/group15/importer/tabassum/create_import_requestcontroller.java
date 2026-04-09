package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class create_import_requestcontroller
{
    @javafx.fxml.FXML
    private DatePicker importDateDP;
    @javafx.fxml.FXML
    private TextField sourceCountryTF;
    @javafx.fxml.FXML
    private TextField quantityTF;
    @javafx.fxml.FXML
    private Label CreateImportRequestLBL;
    @javafx.fxml.FXML
    private ComboBox carTypeCB;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void submitButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
    }
}