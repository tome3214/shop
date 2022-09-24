package domain;

public class Game extends Product{

    public Game(int id, String title) {
        super(id, title);
    }

    @Override
    public double getPrice(int days) {
        return days * 3;
    }

    @Override
    public String toString() {
        return  "-Game-\n" + super.toString();
    }
}
