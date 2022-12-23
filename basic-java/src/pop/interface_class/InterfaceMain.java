package pop.interface_class;

public class InterfaceMain {
    public static void main(String[] args) {
        CarInterface cCarInterface = new CarImplement();
        Car cCar = cCarInterface.createCar("Black", "HONDA", "Civic",
                1300.7d, 15.6f, 180);
        System.out.println(cCar);
        cCarInterface.updateCar(cCar, "White", "HUNDAY", "Accent",
                1250.7d, 12.7f, 150);
        System.out.println(cCar);
    }
}
