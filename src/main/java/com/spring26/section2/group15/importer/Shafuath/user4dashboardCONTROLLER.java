package com.spring26.section2.group15.importer.Shafuath;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class user4dashboardCONTROLLER {

    @FXML
    private AnchorPane mainContentPane;

    @FXML
    public void initialize() {
        // Optional: Load a default summary or welcome screen when dashboard opens
        System.out.println("Manager Dashboard Initialized");
    }

    // 1. Dashboard / Summary Button
    @FXML
    private void handleDashboardBtn(ActionEvent event) {
        loadScene("manager_summary.fxml");
    }

    // 2. Inventory Button
    @FXML
    private void handleInventoryBtn(ActionEvent event) {
        loadScene("manager_inventory.fxml");
    }

    // 3. Sales Reports Button
    @FXML
    private void handleSalesBtn(ActionEvent event) {
        loadScene("manager_sales.fxml");
    }

    // 4. Approval Button
    @FXML
    private void handleApprovalBtn(ActionEvent event) {
        loadScene("manager_sale_approval.fxml");
    }

    // 5. Logout Button
    @FXML
    private void handleLogoutBtn(ActionEvent event) {
        // For logout, we usually switch the whole window back to login
        try {
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/com/spring26/section2/group15/importer/Arpita/user3-InventorydDashboard.fxml"));
            mainContentPane.getScene().setRoot(loginRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper method to load different FXML files into the center area
     */
    private void loadScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent newPane = loader.load();

            // This clears the current center view and adds the new one
            mainContentPane.getChildren().setAll(newPane);

            // Optional: Ensure the new pane fits the full size
            AnchorPane.setTopAnchor(newPane, 0.0);
            AnchorPane.setBottomAnchor(newPane, 0.0);
            AnchorPane.setLeftAnchor(newPane, 0.0);
            AnchorPane.setRightAnchor(newPane, 0.0);

        } catch (IOException e) {
            System.err.println("Error loading FXML: " + fxmlFile);
            e.printStackTrace();
        }
    }
}