package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private int FIX_PRICE;

    @Override
    public boolean isSpecial() {
        return true;
    }

    public FixPriceProduct(String productName, int FIX_PRICE) {
        super(productName);
        this.FIX_PRICE = FIX_PRICE;
    }

    @Override
    public double getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + getPrice();
    }
}
