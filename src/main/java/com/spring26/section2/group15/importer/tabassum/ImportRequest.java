package com.spring26.section2.group15.importer.tabassum;

public class ImportRequest {
    private int id;
    private String carModel;
    private int quantity;
    private String status;

    public ImportRequest(int id, String carModel, int quantity, String status) {
        this.id = id;
        this.carModel = carModel;
        this.quantity = quantity;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ImportRequest{" +
                "id=" + id +
                ", carModel='" + carModel + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }
}
