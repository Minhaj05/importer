package com.spring26.section2.group15.importer.Arpita;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.util.ArrayList;

public class viewAvailableCarsController
{
    @javafx.fxml.FXML
    private TableColumn<car,String> priceTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> brandTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> carIDTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> modelTC;
    @javafx.fxml.FXML
    private TableView<car> viewAvailableCarTV;

    @javafx.fxml.FXML
    public void initialize() {
        ArrayList<car> allCars = FileHelper.loadCars();
        ArrayList<car> availableCars = new ArrayList<>();


        for (car c : allCars) {
            if (c.getStatus().equalsIgnoreCase("Available")) {
                availableCars.add(c);
            }
        }


        carIDTC.setCellValueFactory(new PropertyValueFactory<>("carID"));
        brandTC.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("model"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        viewAvailableCarTV.setItems(FXCollections.observableArrayList(availableCars));





}

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/salesExecutiveDashboard.fxml");
}
}