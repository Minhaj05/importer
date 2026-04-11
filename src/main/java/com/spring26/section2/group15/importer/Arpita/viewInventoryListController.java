package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class viewInventoryListController {

    @FXML
    private TableView<car> invertoryListTV;

    @FXML
    private TableColumn<car, String> brandTC;

    @FXML
    private TableColumn<car, String> modelTC;

    @FXML
    private TableColumn<car, Integer> yearTC;

    @FXML
    private TableColumn<car, String> statusTC;

    @FXML
    private TableColumn<car, Double> priceTC;

    private ArrayList<car> carList;

    @FXML
    public void initialize() {

        carList = FileHelper.loadCars();


        brandTC.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearTC.setCellValueFactory(new PropertyValueFactory<>("year"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));


        invertoryListTV.getItems().clear();
        invertoryListTV.getItems().addAll(carList);
    }

    @FXML
    public void backButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/user3InventorydDashboard.fxml");
    }
}