package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    public abstract boolean isSpecial();

    private final String productName;

    public Product(String productName) {
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Неправильное имя продукта");
        }
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

    @Override
    public String getSearchTerm() {
        return productName + ": " + getPrice();
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return toString();
    }
}
