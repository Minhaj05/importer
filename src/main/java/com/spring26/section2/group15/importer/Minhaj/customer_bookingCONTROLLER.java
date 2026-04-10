package com.spring26.section2.group15.importer.Minhaj;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class customer_bookingCONTROLLER
{
    @javafx.fxml.FXML
    private DatePicker bookingdate;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ConfirmBookingOnClick(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void CancelOnClick(ActionEvent actionEvent) {
    }

    public static class MinhajCustomer_BookingsCONTROLLER
    {
        @javafx.fxml.FXML
        private TableColumn bookingdateCol;
        @javafx.fxml.FXML
        private TableView carTableView;
        @javafx.fxml.FXML
        private TableColumn statusCol;
        @javafx.fxml.FXML
        private TableColumn carCol;

        @javafx.fxml.FXML
        public void initialize() {
        }

        @javafx.fxml.FXML
        public void CancelBookingOnClick(ActionEvent actionEvent) {
        }

        @javafx.fxml.FXML
        public void RefreshOnClick(ActionEvent actionEvent) {
        }
    }
    protected void switchScene(String fxml, javafx.event.ActionEvent event) throws Exception {
        javafx.scene.Parent root = javafx.fxml.FXMLLoader.load(
                getClass().getResource("/view/" + fxml)
        );
        javafx.stage.Stage stage =
                (javafx.stage.Stage) ((javafx.scene.control.Button) event.getSource())
                        .getScene().getWindow();

        stage.setScene(new javafx.scene.Scene(root));
    }
}