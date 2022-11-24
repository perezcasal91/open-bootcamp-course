package pop.polymorphism;

import pop.polymorphism.ElectricCar;
import pop.polymorphism.HybridCar;

public class PolymorphismMain {
    public static void main(String[] args) {
        // Declaring
        Car car1 = new ElectricCar();
        Car car2 = new HybridCar();
        // Using the reserved word instanceof
        if (!(car1 instanceof ElectricCar)){
            System.out.println("The car is electric");
        } else if (car1 instanceof HybridCar) {
            System.out.println("The car is hybrid");
        }else {
            System.out.println("The car is not hybrid");
        }
        if (!(car2 instanceof HybridCar)){
            System.out.println("The car is hybrid");
        }else if (car2 instanceof ElectricCar) {
            System.out.println("The car is electric");
        }else {
            System.out.println("The car is not electric");
        }
    }
}
