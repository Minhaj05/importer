package com.spring26.section2.group15.importer.Shafuath;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class admin_dashboardCONTROLLER {

    @FXML
    private Label totaluserLbl;

    @FXML
    private Label totalsalesLbl;

    @FXML
    private Label systeamstatusLbl;

    // 🔴 BUTTON ACTION (must match: #refreshBtn)
    @FXML
    private void refreshBtn() {

        // 🟢 Simulated Data (you can change later)
        int totalUsers = 12;
        int totalSales = 7;
        String systemStatus = "Running";

        // 🔵 SET VALUES TO LABELS
        totaluserLbl.setText("Total Users: " + totalUsers);
        totalsalesLbl.setText("Total Sales: " + totalSales);
        systeamstatusLbl.setText("System Status: " + systemStatus);
    }

    // 🟡 AUTO LOAD DATA WHEN PAGE OPENS (VERY GOOD FOR MARKS)
    @FXML
    public void initialize() {
        refreshBtn(); // auto load data
    }
}