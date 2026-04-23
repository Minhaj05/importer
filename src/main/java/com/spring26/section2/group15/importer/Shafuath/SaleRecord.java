package com.spring26.section2.group15.importer.Shafuath;

public class SaleRecord {
    private String sale;

    // Constructor
    public SaleRecord(String sale) {
        this.sale = sale;
    }

    // Getter (Required for the TableView to "read" the data)
    public String getSale() {
        return sale;
    }
}