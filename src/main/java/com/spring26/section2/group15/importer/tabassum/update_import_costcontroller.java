package com.spring26.section2.group15.importer.tabassum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class update_import_costcontroller {

    private Label UpdateImportCostLBL;
    private TextField ShippingCostTF;
    private TextField TaxTF;
    private TextField TotalCostTF;

    public void initialize() {
        TotalCostTF.setEditable(false);
        TotalCostTF.setStyle("-fx-background-color: #f0f0f0;"); // grey to show read-only

        ShippingCostTF.setOnKeyReleased(e -> calculateTotal());
        TaxTF.setOnKeyReleased(e -> calculateTotal());
    }

    private void calculateTotal() {
        try {
            double shipping = ShippingCostTF.getText().isEmpty() ? 0 :
                    Double.parseDouble(ShippingCostTF.getText());
            double tax      = TaxTF.getText().isEmpty() ? 0 :
                    Double.parseDouble(TaxTF.getText());

            double total = shipping + tax;
            TotalCostTF.setText(String.format("%.2f", total));

        } catch (NumberFormatException e) {
            TotalCostTF.setText("Invalid input");
        }
    }

    public void UpdateButton(ActionEvent actionEvent) {
        String shippingText = ShippingCostTF.getText().trim();
        String taxText      = TaxTF.getText().trim();

        if (shippingText.isEmpty() || taxText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Missing Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter both Shipping Cost and Tax.");
            alert.showAndWait();
            return;
        }

        try {
            double shipping = Double.parseDouble(shippingText);
            double tax      = Double.parseDouble(taxText);
            double total    = shipping + tax;

            if (shipping < 0 || tax < 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Shipping Cost and Tax cannot be negative.");
                alert.showAndWait();
                return;
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cost Updated");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Import Cost Updated Successfully!\n\n" +
                            "Shipping Cost : $" + String.format("%.2f", shipping) + "\n" +
                            "Tax           : $" + String.format("%.2f", tax)      + "\n" +
                            "Total Cost    : $" + String.format("%.2f", total)
            );
            alert.showAndWait();

            ShippingCostTF.clear();
            TaxTF.clear();
            TotalCostTF.clear();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numbers only.");
            alert.showAndWait();
        }
    }
}