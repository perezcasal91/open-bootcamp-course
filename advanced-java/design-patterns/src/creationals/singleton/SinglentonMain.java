package creationals.singleton;

public class SinglentonMain {

public static void main(String []args){
    // First Instance
    Singleton singleton = Singleton.getInstance();
    // First Set the counter to 1
    singleton.setCount(1);
    System.out.println(singleton.getCount());
    // Second Instance
    Singleton singletonInstance = Singleton.getInstance();
    // Second Get the counter, has to be 1
    System.out.println(singletonInstance.getCount());
    // Second Set the counter to 2
    singletonInstance.setCount(2);
    // First Get the counter and is 2
    System.out.println(singleton.getCount());
    // All this happens because the patter Singleton use the same Instance.
}
}
class Singleton{
    private int count;
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
