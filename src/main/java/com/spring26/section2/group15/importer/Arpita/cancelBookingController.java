package com.spring26.section2.group15.importer.Arpita;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class cancelBookingController {

    @FXML
    private TableColumn<booking, Integer> bookingIDTC;

    @FXML
    private TableColumn<booking, String> statusTC;

    private ArrayList<booking> bookingList;
    private ArrayList<car> carList;
    @FXML
    private TableColumn bookingDateTC;
    @FXML
    private TableColumn carModelTC;
    @FXML
    private TableColumn customerNameTC;
    @FXML
    private TableView<booking> cancleBookingTV;


    @FXML
    public void initialize() {

        bookingList = FileHelper.loadBookings();
        carList = FileHelper.loadCars();


        bookingIDTC.setCellValueFactory(new PropertyValueFactory<>("bookingID"));
        customerNameTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        carModelTC.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        cancleBookingTV.setItems(FXCollections.observableArrayList(bookingList));
    }


    @Deprecated
    public void cancelBookingButton(ActionEvent event) {

        booking selected = cancleBookingTV.getSelectionModel().getSelectedItem();

        if (selected == null) {
            showAlert("Error", "Select a booking first!");
            return;
        }


        for (car c : carList) {
            if (c.getModel().equals(selected.getCarModel())) {
                c.setStatus("Available");
                break;
            }
        }

        bookingList.remove(selected);


        FileHelper.saveBookings(bookingList);
        FileHelper.saveCars(carList);


        cancleBookingTV.setItems(FXCollections.observableArrayList(bookingList));

        showAlert("Success", "Booking cancelled!");
    }


    @FXML
    public void backButton(ActionEvent event) {
        SceneSwitcher.switchScene(event,
                "/com/spring26/section2/group15/importer/Arpita/salesExecutiveDashboard.fxml");
    }


    private void showAlert(String title, String msg) {
        javafx.scene.control.Alert alert =
                new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }


}