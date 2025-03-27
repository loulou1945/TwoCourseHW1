package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Add {
    public static void main(String[] args) {

        Product apple = new Product("Apple",120);
        Product banana = new Product("Banana",150);
        Product kiwi = new Product("Kiwi",200);
        Product avocado = new Product("Avocado",210);
        Product apricot = new Product("Apricot",170);
        Product lime = new Product("Lime", 190);

        ProductBasket firstBasket = new ProductBasket();

        firstBasket.addProduct(apple);
        firstBasket.addProduct(kiwi);
        firstBasket.addProduct(lime);
        firstBasket.addProduct(banana);
        firstBasket.addProduct(avocado);
        firstBasket.addProduct(apricot);

        firstBasket.printBasket();
        System.out.println("Общая стоимость корзины: " + firstBasket.printBasketCost());
        firstBasket.findProductByName("Apple");
        firstBasket.findProductByName("Cherry");
        firstBasket.cleanerBasket();
        firstBasket.printBasket();
        firstBasket.printBasketCost();
        firstBasket.findProductByName("Apple");
    }
}
