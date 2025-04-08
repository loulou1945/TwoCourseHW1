package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {

        //Список продуктов
        Product apple = new FixPriceProduct("Apple");
        Product banana = new DiscountedProduct("Banana", 150, 15);
        Product kiwi = new SimpleProduct("Kiwi", 200);
        Product avocado = new SimpleProduct("Avocado", 210);
        Product apricot = new DiscountedProduct("Apricot", 170, 23);
        Product lime = new FixPriceProduct("Lime");

        //Список статей
        Article appleArticle1 = new Article("Apple", "Яблоко не тонет в воде, так как на четверть состоит из воздуха");
        Article appleArticle2 = new Article("Apple", "Археологи утверждают, что яблоня - первое дерево, культивируемое людьми еще 6500 лет до наступления новой эры");
        Article bananaArticle = new Article("Banana", "С ботанической точки зрения, банан - ягода");

        //Создание списка и добавление в него продуктов и статей
        SearchEngine engine = new SearchEngine(10);

        engine.add(apple);
        engine.add(banana);
        engine.add(kiwi);
        engine.add(apricot);
        engine.add(lime);
        engine.add(avocado);
        engine.add(appleArticle1);
        engine.add(bananaArticle);
        engine.add(appleArticle2);

        //Реализация метода search
        System.out.println("Реализация интерфесов");
        Searchable[] result = engine.search("Apple");
        System.out.println(Arrays.toString(result));

        //Реализаия методов Searchable
        System.out.println(bananaArticle.getStringRepresentation());
        System.out.println(avocado.getTypeContent());
        System.out.println(avocado.getSearchTerm());

        System.out.println();
        System.out.println("Реализация корзины");
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