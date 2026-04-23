package com.spring26.section2.group15.importer.Shafuath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class manager_priceCONTROLLER implements Initializable {

    @FXML
    private ComboBox<String> carSelect;
    @FXML
    private TextField priceField;
    @FXML
    private Label statusLabel;

    @FXML
    public void approveBtn(ActionEvent actionEvent) {
    }