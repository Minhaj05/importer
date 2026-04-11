package com.spring26.section2.group15.importer.Arpita;


import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class registerCustomerController
{
    @javafx.fxml.FXML
    private TextField phoneTF;
    @javafx.fxml.FXML
    private TextField nameTF;
    @javafx.fxml.FXML
    private TextField addressTF;
    private ArrayList<customer> customerList;

    @javafx.fxml.FXML
    public void initialize() {
        customerList = FileHelper.loadCustomers();
    }

    @javafx.fxml.FXML
    public void saveCustomerButton(ActionEvent actionEvent) {

        try {
            String name = nameTF.getText();
            String phone = phoneTF.getText();
            String address = addressTF.getText();

            if (name.isEmpty() || phone.isEmpty()) {
                showAlert("Error", "Fill all required fields!");
                return;
            }

            customer c = new customer(name, phone, address);

            customerList.add(c);

            FileHelper.saveCustomers(customerList);

            showAlert("Success", "Customer Added!");

            nameTF.clear();
            phoneTF.clear();
            addressTF.clear();

        } catch (Exception e) {
            showAlert("Error", "Something went wrong!");
        }
    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) {
        SceneSwitcher.switchScene(actionEvent,
                "/com/spring26/section2/group15/importer/Arpita/salesExecutiveDashboard.fxml");



    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}