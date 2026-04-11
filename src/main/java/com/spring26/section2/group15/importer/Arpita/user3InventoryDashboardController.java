package com.spring26.section2.group15.importer.Arpita;


import javafx.event.ActionEvent;

public class user3InventoryDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateStatusButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/update_status.fxml");
    }

    @javafx.fxml.FXML
    public void viewInventoryButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/view_inventory.fxml");
    }

    @javafx.fxml.FXML
    public void generateReportButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/inventory_report.fxml");

    }

    @javafx.fxml.FXML
    public void logoutButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/logout.fxml");
    }

    @javafx.fxml.FXML
    public void addCarButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/addNewCar.fxml");

    }

    @javafx.fxml.FXML
    public void updateCarButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/update_car.fxml");
    }

    @javafx.fxml.FXML
    public void deleteCarButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/delete_car.fxml");
    }

    @javafx.fxml.FXML
    public void searchCarButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/searchCar.fxml");
    }
}