package pop.simple_class;

public class SimpleMain {
    public static void main(String[] args) {
        Car cCar1 = new Car();
        cCar1.setColor("Black");
        cCar1.setManufacturer("HONDA");
        cCar1.setModel("Civic");
        cCar1.setWeight(1250.5d);
        cCar1.setSize(11.5f);
        cCar1.setSpeed(160);
        System.out.println("Car 1");
        System.out.println(cCar1);
        cCar1.speedUp(40);
        System.out.println(cCar1);
        Car cCar2 = new Car("White", "HUNDAY", "Accent", 1300.7d, 12.6f, 150);
        System.out.println("Car 2");
        System.out.println(cCar2);
        cCar2.speedUp(30);
        System.out.println(cCar2);
    }
}
