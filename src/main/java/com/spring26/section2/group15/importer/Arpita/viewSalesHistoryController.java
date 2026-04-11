package com.spring26.section2.group15.importer.Arpita;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class viewSalesHistoryController {

    @FXML
    private TableView<booking> viewSalesHistoryTV;

    @FXML
    private TableColumn<booking, String> invoiceIDTC;

    @FXML
    private TableColumn<booking, String> customerTC;

    @FXML
    private TableColumn<booking, String> carTC;

    @FXML
    private TableColumn<booking, String> dateTC;

    @FXML
    private TableColumn<booking, Double> priceTC;

    @FXML
    public void initialize() {

        ArrayList<booking> bookingList = FileHelper.loadBookings();
        ArrayList<car> carList = FileHelper.loadCars();


        invoiceIDTC.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        customerTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        carTC.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        dateTC.setCellValueFactory(new PropertyValueFactory<>("date"));


        priceTC.setCellValueFactory(cellData -> {
            booking b = cellData.getValue();

            for (car c : carList) {
                if (c.getModel().equals(b.getCarModel())) {
                    return new javafx.beans.property.SimpleDoubleProperty(c.getPrice()).asObject();
                }
            }
            return new javafx.beans.property.SimpleDoubleProperty(0).asObject();
        });


        ArrayList<booking> soldList = new ArrayList<>();

        for (booking b : bookingList) {
            if (b.getStatus().equalsIgnoreCase("Sold")) {
                soldList.add(b);
            }
        }


        viewSalesHistoryTV.getItems().clear();
        viewSalesHistoryTV.getItems().addAll(soldList);
    }

    @FXML
    public void backButton(javafx.event.ActionEvent event) {
        SceneSwitcher.switchScene(event,
                "/com/spring26/section2/group15/importer/Arpita/sales-dashboard.fxml");
    }
}