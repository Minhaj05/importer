package com.spring26.section2.group15.importer.Shafuath.model.com.spring26.section2.group15.importer.Shafuath.model;

public class Car {

    private String name;
    private double price;

    public Car(String name,double price){
        this.name=name;
        this.price=price;
    }

    public String getName(){ return name; }
    public double getPrice(){ return price; }

    public void setName(String name){ this.name=name; }
    public void setPrice(double price){ this.price=price; }
}
