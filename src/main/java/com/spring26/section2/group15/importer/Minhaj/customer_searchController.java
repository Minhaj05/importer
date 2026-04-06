package com.spring26.section2.group15.importer.Minhaj;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class customer_searchController
{
    @javafx.fxml.FXML
    private ComboBox yearComboBox;
    @javafx.fxml.FXML
    private TableColumn yearCol;
    @javafx.fxml.FXML
    private TableView CarViewTableView;
    @javafx.fxml.FXML
    private TableColumn brandCol;
    @javafx.fxml.FXML
    private TextField searchbymodelTextField;
    @javafx.fxml.FXML
    private TableColumn pricerangeCol;
    @javafx.fxml.FXML
    private TextField searchbybrandTextField;
    @javafx.fxml.FXML
    private ComboBox pricerangeComboBox;
    @javafx.fxml.FXML
    private TableColumn modelCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void SearchOnClick(ActionEvent actionEvent) {
    }
}