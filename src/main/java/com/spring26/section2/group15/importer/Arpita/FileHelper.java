package com.spring26.section2.group15.importer.Arpita;

import com.spring26.section2.group15.importer.Shafuath.model.com.spring26.section2.group15.importer.Shafuath.model.Car;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    // CAR SAVE
    public static void saveCars(ArrayList<com.spring26.section2.group15.importer.Arpita.car> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car.dat"));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CAR LOAD
    public static ArrayList<car> loadCars() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("car.dat"));
            return (ArrayList<car>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // CUSTOMER SAVE
    public static void saveCustomers(ArrayList<customer> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customer.dat"));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CUSTOMER LOAD
    public static ArrayList<customer> loadCustomers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customer.dat"));
            return (ArrayList<customer>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    // BOOKING SAVE
    public static void saveBookings(ArrayList<booking> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("booking.dat"));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // BOOKING LOAD
    public static ArrayList<booking> loadBookings() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("booking.dat"));
            return (ArrayList<booking>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
