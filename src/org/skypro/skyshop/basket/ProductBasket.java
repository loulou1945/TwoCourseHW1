package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    LinkedList<Product> products = new LinkedList<>();
    private int counter = 0;

    public void addProduct(Product product) {
        products.add(product);
        counter++;
    }

    public double getBasketCost() {
        double basketCost = 0;
        for (Product product : products) {
            if (product != null) {
                basketCost = basketCost + product.getPrice();
            }
        }
        return basketCost;
    }

    public void printBasket() {
        System.out.println("Корзина:");
        int countProduct = 0;
        int countSpecialProduct = 0;
        for (Product product : products) {
            if (product != null) {
                countProduct++;
                System.out.println(product);
                if (product.isSpecial()) {
                    countSpecialProduct++;
                }
            }
        }
        if (countProduct == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + getBasketCost());
            System.out.println("Специальных товаров: " + countSpecialProduct);
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
        products.replaceAll(ignored -> null);
        System.out.println("Корзина очищена");
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public LinkedList<Product> removeThisProduct(String name) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getProductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removedProducts;
    }
}
