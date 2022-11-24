package pop.interface_class;

import pop.interface_class.Car;

public class InterfaceMain {
    public static void main(String[] args) {
        // Declaring
        CarInterface carInterface = new CarImplement();
        Car car = carInterface.createCar("Black", "HONDA", "Civic",
                1300.7d, 15.6f, 180);
        // Printing into screen Car
        System.out.println(car);
        // Updating the Car
        carInterface.updateCar(car, "White", "HUNDAY", "Accent",
                1250.7d, 12.7f, 150);
        // Printing into screen Car
        System.out.println(car);
    }
}
