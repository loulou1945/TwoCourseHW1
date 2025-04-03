package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        Product apple = new FixPriceProduct("Apple");
        Product banana = new DiscountedProduct("Banana", 150, 15);
        Product kiwi = new SimpleProduct("Kiwi", 200);
        Product avocado = new SimpleProduct("Avocado", 210);
        Product apricot = new DiscountedProduct("Apricot", 170, 23);
        Product lime = new FixPriceProduct("Lime");

        ProductBasket firstBasket = new ProductBasket();

        firstBasket.addProduct(apple);
        firstBasket.addProduct(kiwi);
        firstBasket.addProduct(lime);
        firstBasket.addProduct(banana);
        firstBasket.addProduct(apricot);

        firstBasket.printBasket();
        System.out.println("Общая стоимость корзины: " + firstBasket.getBasketCost());
        firstBasket.existsProductByName("Apple");
        firstBasket.existsProductByName("Cherry");
        firstBasket.clearBasket();
        firstBasket.printBasket();
        firstBasket.getBasketCost();
        firstBasket.existsProductByName("Apple");
    }
}
