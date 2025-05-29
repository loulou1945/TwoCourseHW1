package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class App {
    public static void main(String[] args) throws BestResultNotFound {

        //Список продуктов
        Product apple = new FixPriceProduct("Apple");
        Product banana = new DiscountedProduct("Banana", 150, 15);
        Product kiwi = new SimpleProduct("Kiwi", 200);
        Product avocado = new SimpleProduct("Avocado", 210);
        Product apricot = new DiscountedProduct("Apricot", 170, 23);
        Product lime = new FixPriceProduct("Lime");
        Product appleGrannySmith = new DiscountedProduct("Apple: Granny Smith", 210, 10);

        //Создание продуктов и обработка IllegalArgumentException
        try {
            DiscountedProduct cucumber = new DiscountedProduct("Cucumber", 190, 130);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct potato = new SimpleProduct("Potato", -120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            FixPriceProduct carrot = new FixPriceProduct(" ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //Список статей
        Article appleArticle1 = new Article("Apple", "Яблоко не тонет в воде, так как на четверть состоит из воздуха");
        Article appleArticle2 = new Article("Apple", "Археологи утверждают, что яблоня - первое дерево, культивируемое людьми еще 6500 лет до наступления новой эры");
        Article bananaArticle = new Article("Banana", "С ботанической точки зрения, банан - ягода");

        //Создание списка и добавление в него продуктов и статей
        SearchEngine engine = new SearchEngine();

        engine.add(apple);
        engine.add(banana);
        engine.add(kiwi);
        engine.add(apricot);
        engine.add(lime);
        engine.add(avocado);
        engine.add(appleArticle1);
        engine.add(bananaArticle);
        engine.add(appleArticle2);
        engine.add(appleGrannySmith);

        //Реализация поика самого подходящего элемента
        System.out.println();
        System.out.println("Реализация поика самого подходящего элемента");
        System.out.println(engine.foundBestResult("Apple"));
        try {
            System.out.println(engine.foundBestResult("Tomato"));
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }


        //Реализация метода search
        System.out.println();
        System.out.println("Реализация интерфесов");
        TreeSet<Searchable> result = engine.search("Apple");
        System.out.println(result);

        //Реализаия методов Searchable
        System.out.println();
        System.out.println("Реализация методов Searchable");
        System.out.println(bananaArticle.getStringRepresentation());
        System.out.println(avocado.getTypeContent());
        System.out.println(avocado.getSearchTerm());

        System.out.println();
        System.out.println("Реализация корзины");
        ProductBasket firstBasket = new ProductBasket();
        ProductBasket secondBasket = new ProductBasket();

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

        //Реализация удаления продукта из корзины по имени
        System.out.println();
        System.out.println("Вторая корзина");
        secondBasket.addProduct(apple);
        secondBasket.printBasket();
        System.out.println(secondBasket.removeThisProduct("Apple"));
        secondBasket.printBasket();
        System.out.println(secondBasket.removeThisProduct("Banana"));
        secondBasket.printBasket();
    }
}