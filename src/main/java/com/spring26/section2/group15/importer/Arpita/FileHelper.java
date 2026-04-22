package com.spring26.section2.group15.importer.Arpita;

import java.io.*;
import java.util.ArrayList;

public class FileHelper {


    public static void saveCar(car c) {
        File f = new File("car.bin");
        boolean exists = f.exists();
        try (FileOutputStream fos = new FileOutputStream(f, true);
             ObjectOutputStream oos = exists ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos)) {
            oos.writeObject(c);
        } catch (Exception e) { e.printStackTrace(); }
    }


    public static void saveCars(ArrayList<car> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("car.bin"))) {
            for (car c : list) {
                oos.writeObject(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }


    public static void saveAllCars(ArrayList<car> list) {
        saveCars(list);
    }


    public static ArrayList<car> loadCars() {
        ArrayList<car> list = new ArrayList<>();
        File f = new File("car.bin");
        if (!f.exists()) return list;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    list.add((car) ois.readObject());
                } catch (EOFException e) { break; }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }


    public static void saveCustomers(ArrayList<customer> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customer.bin"))) {
            for (customer c : list) {
                oos.writeObject(c);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static ArrayList<customer> loadCustomers() {
        ArrayList<customer> list = new ArrayList<>();
        File f = new File("customer.bin");
        if (!f.exists()) return list;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    list.add((customer) ois.readObject());
                } catch (EOFException e) { break; }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }


    public static void saveBooking(booking b) {
        File f = new File("booking.bin");
        boolean exists = f.exists();
        try (FileOutputStream fos = new FileOutputStream(f, true);
             ObjectOutputStream oos = exists ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos)) {
            oos.writeObject(b);
        } catch (Exception e) { e.printStackTrace(); }
    }


    public static void saveBookings(ArrayList<booking> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("booking.bin"))) {
            for (booking b : list) {
                oos.writeObject(b);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }


    public static void saveAllBookings(ArrayList<booking> list) {
        saveBookings(list);
    }

    public static ArrayList<booking> loadBookings() {
        ArrayList<booking> list = new ArrayList<>();
        File f = new File("booking.bin");
        if (!f.exists()) return list;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            while (true) {
                try {
                    list.add((booking) ois.readObject());
                } catch (EOFException e) { break; }
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}