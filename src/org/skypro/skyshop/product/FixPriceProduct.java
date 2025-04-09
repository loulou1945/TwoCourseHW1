package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private int FIX_PRICE = 170;

    @Override
    public boolean isSpecial() {
        return true;
    }

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + getPrice();
    }

    @Override
    public String getStringRepresentation() {

        return null;
    }
}
