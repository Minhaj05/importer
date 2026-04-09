package com.spring26.section2.group15.importer.tabassum.model;

public class CreateImportRequest {

    private int id;
    private String carModel;
    private int quantity;
    private String status;

    // Constructor
    public CreateImportRequest(int id, String carModel, int quantity, String status) {
        this.id = id;
        this.carModel = carModel;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CreateImportRequest{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}
