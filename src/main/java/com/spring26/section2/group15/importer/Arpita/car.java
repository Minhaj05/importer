package com.example.reconditionedcarimporter;

import java.io.Serializable;

public class car implements Serializable {
    private int carID;
    private String brand;
    private String model;
    private int year;
    private double price;
    private String status;

    public car(int carID, String brand, String model, int year, String status, double price) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.status = status;
        this.price = price;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "car{" +
                "carID=" + carID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
