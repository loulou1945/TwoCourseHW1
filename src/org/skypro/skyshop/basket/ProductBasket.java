package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getProductName(), k -> new LinkedList<>()).add(product);
    }

    public double getBasketCost() {
        double basketCost = products.values().stream().flatMap(Collection::stream)
                .mapToDouble(Product::getPrice)
                .sum();
        return basketCost;
    }

    private int getCountSpecialProduct() {
        return Math.toIntExact(products.values().stream().flatMap(Collection::stream).filter(p ->p.isSpecial()).count());
    }
    public void printBasket() {
        System.out.println("Корзина:");
        int countProduct = Math.toIntExact(products.values().stream().flatMap(Collection::stream).count());
        if (countProduct == 0) {
            System.out.println("В корзине пусто");
        } else {
            products.values().stream().flatMap(Collection::stream).forEach(p -> System.out.println(p));
            System.out.println("Итого: " + getBasketCost());
            System.out.println("Специальных товаров: " + getCountSpecialProduct());
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
