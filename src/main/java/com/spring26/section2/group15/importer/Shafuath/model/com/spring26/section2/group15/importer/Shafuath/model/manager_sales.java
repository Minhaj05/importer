package com.spring26.section2.group15.importer.Shafuath.model.com.spring26.section2.group15.importer.Shafuath.model;

public class Sale {

    private String car;
    private double amount;

    public Sale(String car, double amount){
        this.car = car;
        this.amount = amount;
    }

    public String getCar(){ return car; }
    public double getAmount(){ return amount; }

    public void setCar(String car){ this.car = car; }
    public void setAmount(double amount){ this.amount = amount; }

    @Override
    public String toString(){
        return car + " - " + amount;
    }
}
