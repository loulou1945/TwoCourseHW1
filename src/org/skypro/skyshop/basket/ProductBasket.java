package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProductName(), k -> new LinkedList<>()).add(product);
    }

    public double getBasketCost() {
        double basketCost = 0;
        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            for (Product p : product.getValue()) {
                basketCost += p.getPrice();
            }
        }
        return basketCost;
    }

    public void printBasket() {
        System.out.println("Корзина:");
        int countProduct = 0;
        int countSpecialProduct = 0;
        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            countProduct++;
            System.out.println(product.getValue());
            for (Product p : product.getValue()) {
                if (p.isSpecial()) {
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
        for (Map.Entry<String, List<Product>> product : products.entrySet()) {
            for (Product p : product.getValue()) {
                if (p.getProductName().equals(productName)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public void clearBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }

    public LinkedList<Product> removeThisProduct(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Map.Entry<String, List<Product>>> iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Product>> p = iterator.next();
            for (Product product : p.getValue()) {
                Product tempProd = product;
                if (tempProd.getProductName().equals(name)) {
                    removedProducts.add(tempProd);
                    iterator.remove();
                }
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return (LinkedList<Product>) removedProducts;
    }
}
