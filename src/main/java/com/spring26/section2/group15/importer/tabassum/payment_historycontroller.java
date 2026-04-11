package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class payment_historycontroller
{
    @javafx.fxml.FXML
    private TableColumn PaymentIdTC;
    @javafx.fxml.FXML
    private TableColumn AmountTC;
    @javafx.fxml.FXML
    private TableColumn StatusTC;
    @javafx.fxml.FXML
    private TableColumn customerNameTC;
    @javafx.fxml.FXML
    private Label PaymentHistoryLBL;
    @javafx.fxml.FXML
    private TableColumn DateTC;
    @javafx.fxml.FXML
    private TableView PaymentHistoryTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ViewDetailsButton(ActionEvent actionEvent) {
    }
}