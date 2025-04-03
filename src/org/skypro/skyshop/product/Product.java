package org.skypro.skyshop.product;

public abstract class Product {
    public abstract boolean isSpecial();

    private final String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return productName + ": " + getPrice();
    }

}
