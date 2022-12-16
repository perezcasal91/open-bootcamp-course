package structurals.adapter;

public class RoundHoleMain {
    public static void main(String[] args) {
        RoundPeg roundPeg = new RoundPeg();
        System.out.println(roundPeg.getRadius());
        SquareAdapter squareAdapter = new SquareAdapter();
        System.out.println(squareAdapter.getRadius());
    }
}
interface RoundHole {
    double getRadius();
}
class RoundPeg implements RoundHole {
    @Override
    public double getRadius() {
        return 25d;
    }
}
class SquarePeg {
    public double getWidth() {
        return 5d;
    }
}
class SquareAdapter implements RoundHole {
    private final SquarePeg squarePeg;
    public SquareAdapter() {
        this.squarePeg = new SquarePeg();
    }
    @Override
    public double getRadius() {
        return Math.pow(squarePeg.getWidth(), 2);
    }
}