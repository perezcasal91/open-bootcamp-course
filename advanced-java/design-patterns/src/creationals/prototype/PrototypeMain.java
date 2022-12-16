package creationals.prototype;

public class PrototypeMain {
    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.setPrototype("new");
        System.out.println(prototype.getPrototype());
        Prototype prototypeClone = prototype.cloneS();
        System.out.println(prototypeClone.getPrototype());
    }
}
class Prototype {
    private String prototype;
    public Prototype() {}
    public Prototype(Prototype prototype) {

    }
    public Prototype clone() {
        Prototype prototypeClone = new Prototype();
        prototypeClone.prototype = this.prototype;
        return prototypeClone;
    }
    public Prototype cloneS() {
        return new Prototype(this);
    }
    public String getPrototype() {
        return prototype;
    }
    public void setPrototype(String prototype) {
        this.prototype = prototype;
    }
}
