package com.spring26.section2.group15.importer.tabassum;

public class view_import_history {
    private int id;
    private String source;
    private int quantity;
    private String date;
    private String status;

    public view_import_history(int id, String source, int quantity, String date, String status) {
        this.id = id;
        this.source = source;
        this.quantity = quantity;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "view_import_history{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
