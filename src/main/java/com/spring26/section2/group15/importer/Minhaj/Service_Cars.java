package com.spring26.section2.group15.importer.Minhaj;

import java.time.LocalDate;

public class Service_Cars {
    private String Car;
    private LocalDate date;
    private String task;
    private String status;

    public Service_Cars(String car, LocalDate date, String task, String status) {
        Car = car;
        this.date = date;
        this.task = task;
        this.status = status;
    }

    public String getCar() {
        return Car;
    }

    public void setCar(String car) {
        Car = car;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Service_Cars{" +
                "Car='" + Car + '\'' +
                ", date=" + date +
                ", task='" + task + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
