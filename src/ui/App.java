package ui;

import domain.Shop;

public class App {

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.loadFile("Products.txt");
        new UI(shop);
        shop.saveToFile("Products.txt");
    }
}
