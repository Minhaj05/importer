package com.spring26.section2.group15.importer.Shafuath;

import com.spring26.section2.group15.importer.Shafuath.model.com.spring26.section2.group15.importer.Shafuath.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class admin_manage_usersCONTROLLER {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private ComboBox<String> roleComBox;

    @FXML
    private TableView<User> manager_user_tableview;

    @FXML
    private TableColumn<User, String> usernameClm;

    @FXML
    private TableColumn<User, String> emailClm;

    @FXML
    private TableColumn<User, String> roleClm;

    // 🟢 Data List
    private ObservableList<User> userList = FXCollections.observableArrayList();

    // 🔵 INITIALIZE METHOD
    @FXML
    public void initialize() {

        // ComboBox values
        roleComBox.getItems().addAll("Admin", "Manager", "Customer");

        // Connect table columns
        usernameClm.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailClm.setCellValueFactory(new PropertyValueFactory<>("email"));
        roleClm.setCellValueFactory(new PropertyValueFactory<>("role"));

        // Set data
        manager_user_tableview.setItems(userList);

        // 🔴 Click row → show data in fields
        manager_user_tableview.setOnMouseClicked(e -> {
            User selected = manager_user_tableview.getSelectionModel().getSelectedItem();
            if (selected != null) {
                usernameField.setText(selected.getUsername());
                emailField.setText(selected.getEmail());
                roleComBox.setValue(selected.getRole());
            }
        });
    }

    // 🟢 ADD USER
    @FXML
    private void adduserBtn() {

        if (usernameField.getText().isEmpty() || emailField.getText().isEmpty() || roleComBox.getValue() == null) {
            showAlert("Error", "Please fill all fields!");
            return;
        }

        User user = new User(
                usernameField.getText(),
                emailField.getText(),
                roleComBox.getValue()
        );

        userList.add(user);
        clearFields();
        showAlert("Success", "User Added Successfully");
    }

    // 🔵 UPDATE USER
    @FXML
    private void updateuserBtn() {

        User selected = manager_user_tableview.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a user first!");
            return;
        }

        selected.setUsername(usernameField.getText());
        selected.setEmail(emailField.getText());
        selected.setRole(roleComBox.getValue());

        manager_user_tableview.refresh();
        clearFields();
        showAlert("Updated", "User Updated Successfully");
    }

    // 🔴 DELETE USER
    @FXML
    private void deleteuserBtn() {

        User selected = manager_user_tableview.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a user first!");
            return;
        }

        userList.remove(selected);
        clearFields();
        showAlert("Deleted", "User Deleted Successfully");
    }

    // 🟡 CLEAR INPUT
    private void clearFields() {
        usernameField.clear();
        emailField.clear();
        roleComBox.setValue(null);
    }

    // 🟣 ALERT MESSAGE
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }
}