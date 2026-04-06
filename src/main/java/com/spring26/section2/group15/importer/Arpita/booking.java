package com.example.reconditionedcarimporter;

import java.io.Serializable;

public class booking implements Serializable
 {
    private int bookingID;
    private String customerName;
    private String carModel;
    private String status;

     public booking(int bookingID, String customerName, String carModel, String status) {
         this.bookingID = bookingID;
         this.customerName = customerName;
         this.carModel = carModel;
         this.status = status;
     }

     public int getBookingID() {
         return bookingID;
     }

     public void setBookingID(int bookingID) {
         this.bookingID = bookingID;
     }

     public String getCustomerName() {
         return customerName;
     }

     public void setCustomerName(String customerName) {
         this.customerName = customerName;
     }

     public String getCarModel() {
         return carModel;
     }

     public void setCarModel(String carModel) {
         this.carModel = carModel;
     }

     public String getStatus() {
         return status;
     }

     public void setStatus(String status) {
         this.status = status;
     }

     @Override
     public String toString() {
         return "booking{" +
                 "bookingID=" + bookingID +
                 ", customerName='" + customerName + '\'' +
                 ", carModel='" + carModel + '\'' +
                 ", status='" + status + '\'' +
                 '}';
     }
 }
