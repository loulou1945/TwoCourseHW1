package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];

    public void addProduct(Product product) {
        boolean result = true;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                result = true;
                break;
            } else {
                result = false;
            }
        }
        if (!result) {
            System.out.println("Невозможно добваить продукт");
        }
    }

    public int getBasketCost() {
        int basketCost = 0;
        for (Product product : products) {
            if (product != null) {
                basketCost = basketCost + product.getProductCost();
            }
        }
        return basketCost;
    }

    public void printBasket() {
        System.out.println("Корзина:");
        int countProduct = 0;
        for (Product product : products) {
            if (product != null) {
                countProduct += 1;
                System.out.println(product);
            }
        }
        if (countProduct == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + getBasketCost());
        }
    }

    public boolean existsProductByName(String productName) {
        boolean result = false;
        for (Product product : products) {
            if (product != null && product.getProductName().equals(productName)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        System.out.println("Корзина очищена");
    }
}
