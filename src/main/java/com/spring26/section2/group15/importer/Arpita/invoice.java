package com.spring26.section2.group15.importer.Arpita;


import java.io.Serializable;

public class invoice implements Serializable {
    private int invoiceID;
    private String customer;
    private String car;
    private double price;
    private String date;

    public invoice(int invoiceID, String customer, String car, double price, String date) {
        this.invoiceID = invoiceID;
        this.customer = customer;
        this.car = car;
        this.price = price;
        this.date = date;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "invoice{" +
                "invoiceID=" + invoiceID +
                ", customer='" + customer + '\'' +
                ", car='" + car + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }
}
