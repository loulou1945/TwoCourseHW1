package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private final double price;

    public SimpleProduct(String productName, double price) {
        super(productName);
        this.price = price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice();
    }
}
