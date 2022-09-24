package ui;

//UI can only import Shop
import domain.Shop;

import javax.swing.*;

public class UI {
	private final Shop shop;
	public UI(Shop shop) {
		this.shop = shop;
		showMenu();
	}

	public void showMenu() {
		String menu = " 1. Add product  \n  2. Show product \n 3. Show rental price \n 4. All products\n 5. Set as rented\n 0. Quit";
		String  choice = "";
		while (!choice.equals("0")) {
			choice = JOptionPane.showInputDialog(menu);
			if (choice == null) {
				break;
			} else {
				switch (choice) {
					case "1":
						addProduct();
						break;
					case "2":
						showProduct();
						break;
					case "3" :
						showPrice();
						break;
					case "4":
						showAllProducts();
						break;
					case "5":
						setRented();
						break;
					case "6":
						menu = "Invalid option!\n" + menu;
						break;

				}
			}
		}
	}

	private boolean productExists(String idString) {
		try {
			int id = Integer.parseInt(idString);
			shop.getProductByID(id); //Test if product exists
			return true;
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Invalid ID!");
			return false;
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	private String getID() {
		return JOptionPane.showInputDialog("Enter the id:");
	}

	public void addProduct() {
		String title = JOptionPane.showInputDialog("Enter the title:");
		String type = JOptionPane.showInputDialog("Enter the type: \nC - CD\n G - Game\n M - Movie");

		try {
			shop.addProduct(type, title);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void showAllProducts() {
		String s = shop.getProductsInOrder();
		JOptionPane.showMessageDialog(null, s);
	}

	public void showProduct() {
		String idString = getID();
		if (productExists(idString)) {
			int id = Integer.parseInt(idString);
			JOptionPane.showMessageDialog(null, shop.getProductByID(id));
		}
	}

	public void showPrice() {
		String idString = getID();
		if (productExists(idString)) {
			int id = Integer.parseInt(idString);
			String days = JOptionPane.showInputDialog(shop.getProductByID(id) + "\n\nEnter the number of days:");
			if (days == null) return;
			try {
				JOptionPane.showMessageDialog(null, shop.getPrice(Integer.parseInt(days), id));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid number of days!");
			}
		}
	}

	private void setRented() {
		String idString = getID();
		if (productExists(idString)) {
			try {
				shop.setRented(Integer.parseInt(idString));
				JOptionPane.showMessageDialog(null, "Product successfully set as not available.}");
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

}
