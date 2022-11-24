package pop.inherit;

import pop.inherit.Car;

public class InheritMain {
    public static void main(String[] args) {
        // Declaring
        ElectricCar car;
        // Init the object car with empty parameters and setting the properties one by one
        ElectricCar car1 = new ElectricCar();
        car1.setColor("Black");
        car1.setManufacturer("HONDA");
        car1.setModel("Civic");
        car1.setWeight(1250.5d);
        car1.setSize(11.5f);
        car1.setSpeed(160);
        car1.setElectricEngine("TDA");
        // Printing into screen Car 1
        System.out.println("Car 1");
        System.out.println(car1);
        // Changing the behavior to 200
        car1.speedUp(40);
        System.out.println(car1);
        // Init the object car with parameters
        ElectricCar car2 = new ElectricCar("White", "HUNDAY", "Accent",
                1300.7d, 12.6f, 150,"HXZ");
        // Printing into screen Car 2
        System.out.println("Car 2");
        System.out.println(car2);
        // Changing the behavior to 180
        car2.speedUp(30);
        System.out.println(car2);
    }
}
