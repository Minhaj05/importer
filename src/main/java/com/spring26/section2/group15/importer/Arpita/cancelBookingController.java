package com.spring26.section2.group15.importer.Arpita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

public class cancelBookingController {

    @FXML
    private TableColumn<booking, Integer> bookingIDTC;
    @FXML
    private TableColumn<booking, String> statusTC;
    @FXML
    private TableColumn<booking, String> carModelTC;
    @FXML
    private TableColumn<booking, String> customerNameTC;
    @FXML
    private TableView<booking> cancleBookingTV;

    private ArrayList<booking> bookingList;
    private ArrayList<car> carList;
    @FXML
    private TableColumn bookingDateTC;

    @FXML
    public void initialize() {

        bookingList = FileHelper.loadBookings();
        carList = FileHelper.loadCars();

        bookingIDTC.setCellValueFactory(new PropertyValueFactory<>("bookingID"));
        customerNameTC.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        carModelTC.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        statusTC.setCellValueFactory(new PropertyValueFactory<>("status"));


        cancleBookingTV.getItems().addAll(bookingList);
    }


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


        FileHelper.saveAllBookings(bookingList);
        FileHelper.saveAllCars(carList);


        cancleBookingTV.getItems().clear();
        cancleBookingTV.getItems().addAll(bookingList);

        showAlert("Success", "Cancelled!");
    }

    @FXML
    public void backButton(ActionEvent event) {
        SceneSwitcher.switchScene(event,
                "/com/spring26/section2/group15/importer/Arpita/salesExecutiveDashboard.fxml");
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }


}