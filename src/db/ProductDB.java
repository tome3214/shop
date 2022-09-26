package db;

import domain.CD;
import domain.Game;
import domain.Movie;
import domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    private final List<Product> products;
    // use an input file to load the products



    public ProductDB() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }


    public void addProduct(String type, String title) throws IllegalArgumentException {
        if (type == null) throw new IllegalArgumentException("Invalid type!");
        int newID = products.size()+1;
        switch (type.toUpperCase()) {
            case "M":
                products.add(new Movie(newID, title));
                break;
            case "G":
                products.add(new Game(newID, title));
                break;
            case "C":
                products.add(new CD(newID, title));
                break;
            default:
                throw new IllegalArgumentException("Invalid type!");

        }
    }

    public Product getProductByID(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        } return null;
    }
}
