package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;

public class salesExecutiveController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void registerCustomerButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/registerCustomer.fxml");
    }

    @javafx.fxml.FXML
    public void sellCarButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/sellCar.fxml");
    }

    @javafx.fxml.FXML
    public void cancelBookingButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/cancelBooking.fxml");
    }

    @javafx.fxml.FXML
    public void logoutButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/sales_logout.fxml");
    }

    @javafx.fxml.FXML
    public void salesHistoryButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/viewSalesHistory.fxml");
    }

    @javafx.fxml.FXML
    public void bookCarButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/bookCar.fxml");
    }

    @javafx.fxml.FXML
    public void generateInvoiceButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/generateInventoryReport.fxml");

    }

    @javafx.fxml.FXML
    public void viewAvailableCarButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/viewAvailableCars.fxml");
    }
}