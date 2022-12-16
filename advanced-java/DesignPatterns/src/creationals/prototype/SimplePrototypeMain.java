package creational_patterns.prototype;

public class SimplePrototypeMain {
    public static void main(String[] args) {
        SimplePrototype simplePrototype = new SimplePrototype();
        simplePrototype.setSimple("Clone");
        SimplePrototype simplePrototypeClone = simplePrototype.clone();
        System.out.println(simplePrototypeClone.getSimple());
    }
}
class SimplePrototype {
    private String simple;
    public SimplePrototype() {}
    public SimplePrototype(SimplePrototype simplePrototype) {this.simple = simplePrototype.simple;}
    public String getSimple() {return simple;}
    public void setSimple(String simple) {this.simple = simple;}
    public SimplePrototype clone(){return new SimplePrototype(this);}
}