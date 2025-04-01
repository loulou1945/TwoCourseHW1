package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrise;
    private final int discount;

    public DiscountedProduct(String productName, int basePrise, int discount) {
        super(productName);
        this.basePrise = basePrise;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public double getPrice() {
        return basePrise - (double) basePrise * discount / 100;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice() + " (" + getDiscount() + "%)";
    }
}
