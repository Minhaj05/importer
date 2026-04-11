package com.spring26.section2.group15.importer.tabassum;

public class Cost {
    private double shipping;
    private double tax;
    private double total;

    public Cost(double shipping, double tax, double total) {
        this.shipping = shipping;
        this.tax = tax;
        this.total = total;
    }

    public double getShipping() {
        return shipping;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "shipping=" + shipping +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}
