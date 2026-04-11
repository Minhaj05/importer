package com.spring26.section2.group15.importer.Arpita;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class searchCarController
{
    @javafx.fxml.FXML
    private TableColumn<car,String> priceTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> brandTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> statusTC;
    @javafx.fxml.FXML
    private TableColumn<car,Integer> carIDTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> modelTC;
    @javafx.fxml.FXML
    private TableColumn<car,String> yearTC;
    @javafx.fxml.FXML
    private TextField searchTF;
    @javafx.fxml.FXML
    private TableView<car> searchTV;
    private ArrayList<car> carList;


    @javafx.fxml.FXML
    public void initialize() {
        carList = FileHelper.loadCars();

        brandTC.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelTC.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearTC.setCellValueFactory(new PropertyValueFactory<>("year"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));

        searchTV.setItems(FXCollections.observableArrayList(carList));
    }



    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        String keyword = searchTF.getText().toLowerCase();

        ArrayList<car> filteredList = new ArrayList<>();

        for (car c : carList) {

            if (c.getBrand().toLowerCase().contains(keyword) ||
                    c.getModel().toLowerCase().contains(keyword)) {

                filteredList.add(c);
            }
        }

        searchTV.setItems(FXCollections.observableArrayList(filteredList));
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/user3InventorydDashboard.fxml");

    }
}