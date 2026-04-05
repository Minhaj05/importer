package com.spring26.section2.group15.importer.Arpita;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {

    // CAR SAVE
    public static void saveCars(ArrayList<com.example.reconditionedcarimporter.car> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car.dat"));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CAR LOAD
    public static ArrayList<Car> loadCars() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("car.dat"));
            return (ArrayList<Car>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // CUSTOMER SAVE
    public static void saveCustomers(ArrayList<Customer> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customer.dat"));
            oos.writeObject(list);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CUSTOMER LOAD
    public static ArrayList<Customer> loadCustomers() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customer.dat"));
            return (ArrayList<Customer>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
