package com.spring26.section2.group15.importer.tabassum;

public class Payment {
    private int id;
    private double amount;
    private String method;
    private String status;

    public Payment(int id, double amount, String method, String status) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
