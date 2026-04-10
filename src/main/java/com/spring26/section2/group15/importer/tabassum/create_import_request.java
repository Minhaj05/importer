package com.spring26.section2.group15.importer.tabassum;

public class create_import_request {
    private String source;
    private int quantity;
    private String date;
    private String carType;

    public create_import_request(String source, int quantity, String date, String carType) {
        this.source = source;
        this.quantity = quantity;
        this.date = date;
        this.carType = carType;
    }

    public String getSource() {
        return source;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public String getCarType() {
        return carType;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "create_import_request{" +
                "source='" + source + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
