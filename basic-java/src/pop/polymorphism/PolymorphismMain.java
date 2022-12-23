package pop.polymorphism;

public class PolymorphismMain {
    public static void main(String[] args) {
        Car cCar1 = new ElectricCar();
        Car cCar2 = new HybridCar();
        if (!(cCar1 instanceof ElectricCar)) {
            System.out.println("The car is electric");
        } else if (cCar1 instanceof HybridCar) {
            System.out.println("The car is hybrid");
        } else {
            System.out.println("The car is not hybrid");
        }
        if (!(cCar2 instanceof HybridCar)) {
            System.out.println("The car is hybrid");
        }else if (cCar2 instanceof ElectricCar) {
            System.out.println("The car is electric");
        } else {
            System.out.println("The car is not electric");
        }
    }
}
