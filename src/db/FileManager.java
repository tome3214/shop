package db;

import domain.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    public static void loadFile(String path, ProductDB db) {
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                //Type
                String type = scanner.nextLine();
                type = type.substring(1, 2); //Only first letter of Type
                //ID
                String id = scanner.nextLine();
                //Title
                String title = scanner.nextLine();
                title = title.substring(7);
                //Available
                String av = scanner.nextLine();
                boolean available = av.equals("Available: true");

                //Try to make product
                try {
                    db.addProduct(type, title);
                    if (!available) {
                        Product p = db.getProductByID(Integer.parseInt(id));
                        p.setAvailable(false);
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid ID in file!!");
                }
            }
            scanner.close();
            System.out.println("Successfully loaded (" + db.getProducts().size() + ") products from file.");
        } catch (FileNotFoundException fnfe ){
            System.out.println("File doesn't exist yet.");
        } catch (Exception e) {
            System.out.println("Error found while reading file!!");
        }
    }

    public static void saveToFile(String path, ProductDB db) {
        //Producten opslaan in een bestand
        try {
            FileWriter writer = new FileWriter(path);
            for (Product p : db.getProducts()) {
                writer.write(p.toString() + "\n");
            }
            writer.close();
            System.out.println("Successfully wrote (" + db.getProducts().size() + ") products to file.");
        } catch (IOException e) {
            System.out.println(">>> File error!!!");
            e.printStackTrace();
        }
    }
}
