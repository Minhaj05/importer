package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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