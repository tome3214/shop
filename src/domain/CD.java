package domain;

public class CD extends Product{

    public CD (int id, String title) {
        super(id, title);
    }

    @Override
    public double getPrice(int days) {
        return 1.5 * days;
    }

    @Override
    public String toString() {
        return "-CD-\n" + super.toString();
    }
}
