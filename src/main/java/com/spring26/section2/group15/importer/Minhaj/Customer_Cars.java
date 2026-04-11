package com.spring26.section2.group15.importer.Minhaj;

public class Customer_Cars {
    private String brand;
    private String model;
    private int year;
    private String status;

    public Customer_Cars(String brand, String model, int year, String status) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer_Cars{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", status='" + status + '\'' +
                '}';
    }
}
