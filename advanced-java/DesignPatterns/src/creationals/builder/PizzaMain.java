package creational_patterns.builder;

public class PizzaMain {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .setSize(5)
                .setPeperoni(true)
                .setOnion(true)
                .build();
        System.out.println(pizza);
        System.out.println("Size: " + pizza.getSize());
        System.out.println("Peperoni: " + pizza.isPeperoni());
        System.out.println("Onion: " + pizza.isOnion());
    }
}
class PizzaBuilder extends Builder {
    private Pizza pizza;
    public PizzaBuilder() {init();}
    private void init() {pizza = new PizzaImplement();}
    @Override
    PizzaBuilder setSize(int size) {pizza.setSize(size);return this;}
    @Override
    PizzaBuilder setPeperoni(boolean peperoni) {pizza.setPeperoni(peperoni);return this;}
    @Override
    PizzaBuilder setOnion(boolean onion) {pizza.setOnion(onion);return this;}
    public Pizza build() {return pizza;}
}
abstract class Builder {
    abstract Builder setSize(int size);
    abstract Builder setPeperoni(boolean peperoni);
    abstract Builder setOnion(boolean onion);
}
class PizzaImplement implements Pizza {
    private int size;
    private boolean peperoni;
    private boolean onion;
    public PizzaImplement() {}
    @Override
    public int getSize() {return size;}
    @Override
    public void setSize(int size) {this.size = size;}
    @Override
    public boolean isPeperoni() {return peperoni;}
    @Override
    public void setPeperoni(boolean peperoni) {this.peperoni = peperoni;}
    @Override
    public boolean isOnion() {return onion;}
    @Override
    public void setOnion(boolean onion) {this.onion = onion;}
    @Override
    public String toString() {
        return "Pizza { " +
                "size=" + getSize() +
                ", peperoni=" + isPeperoni() +
                ", onion=" + isOnion() +
                " } ";
    }
}
interface Pizza {
    int getSize();
    void setSize(int size);
    boolean isPeperoni();
    void setPeperoni(boolean peperoni);
    boolean isOnion();
    void setOnion(boolean onion);
}