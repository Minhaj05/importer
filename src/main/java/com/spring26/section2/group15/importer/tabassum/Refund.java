package com.spring26.section2.group15.importer.tabassum;

public class Refund {
    private int refundId;
    private int paymentId;
    private double amount;
    private String reason;

    public Refund(int refundId, int paymentId, double amount, String reason) {
        this.refundId = refundId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.reason = reason;
    }

    public int getRefundId() {
        return refundId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    public void setRefundId(int refundId) {
        this.refundId = refundId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "refundId=" + refundId +
                ", paymentId=" + paymentId +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
