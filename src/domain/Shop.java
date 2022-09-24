package domain;

import db.ProductDB;
import db.FileManager;

import java.util.Comparator;
import java.util.List;

public class Shop {
    private final ProductDB db;

    public Shop() {
        db = new ProductDB();
    }

    public void addProduct(String type, String title) throws IllegalArgumentException {
        db.addProduct(type, title);
    }

    public String getProductByID(int id) {
        Product p = db.getProductByID(id);
        if (p == null) throw new IllegalArgumentException("Product with ID (" + id + ") not found!");
        else return p.toString();
    }

    public String getProductsInOrder() {
        List<Product> allProducts = db.getProducts();
        allProducts.sort(Comparator.comparing(o -> o.getClass().getName()).reversed());
        StringBuilder s = new StringBuilder();
        for (Product p : allProducts) {
            s.append(p).append("\n\n");
        }
        return String.valueOf(s);
    }

    public void loadFile(String path) {
        FileManager.loadFile(path, db);
    }

    public void saveToFile(String path) {
        FileManager.saveToFile(path, db);
    }

    public double getPrice(int days, int productID) {
        return db.getProductByID(productID).getPrice(days);
    }

    public void setRented(int id) {
        db.getProductByID(id).setAvailable(false);
    }
}
