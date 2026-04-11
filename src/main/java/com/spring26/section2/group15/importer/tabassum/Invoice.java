package com.spring26.section2.group15.importer.tabassum;

public class Invoice {
    private int invoiceId;
    private int paymentId;
    private double totalAmount;

    public Invoice(int invoiceId, int paymentId, double totalAmount) {
        this.invoiceId = invoiceId;
        this.paymentId = paymentId;
        this.totalAmount = totalAmount;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", paymentId=" + paymentId +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
