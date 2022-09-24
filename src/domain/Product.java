package domain;

public abstract class Product {
    private final int id;
    private final String title;
    private boolean available;

    public Product(int id, String title) {
        this.id = id;
        this.title = title;
        available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public abstract double getPrice(int days);

    @Override
    public String toString() {
        return "ID: " + id +
                "\nTitle: " + title +
                "\nAvailable: " + available;
    }

    public void setAvailable (boolean available) throws IllegalArgumentException {
        if (this.available == available) {
            String m = "Product is already set as ";
            if (!available) m += "not ";
            m += "available";
            throw new IllegalArgumentException(m);
        }
        this.available = available;
    }
}
