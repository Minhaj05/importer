package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class record_paymentcontroller
{
    @javafx.fxml.FXML
    private ComboBox PaymentMethodCB;
    @javafx.fxml.FXML
    private TextField CustomerNameTF;
    @javafx.fxml.FXML
    private Label RecordPaymentLBL;
    @javafx.fxml.FXML
    private DatePicker dateDP;
    @javafx.fxml.FXML
    private TextField amountTF;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
    }
}