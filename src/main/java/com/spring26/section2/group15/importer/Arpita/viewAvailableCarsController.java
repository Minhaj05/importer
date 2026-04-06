package com.example.reconditionedcarimporter;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class viewAvailableCarsController
{
    @javafx.fxml.FXML
    private TableColumn priceTC;
    @javafx.fxml.FXML
    private TableColumn brandTC;
    @javafx.fxml.FXML
    private TableColumn statusTC;
    @javafx.fxml.FXML
    private TableColumn carIDTC;
    @javafx.fxml.FXML
    private TableColumn modelTC;
    @javafx.fxml.FXML
    private TableView viewAvailableCarTV;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
    }
}