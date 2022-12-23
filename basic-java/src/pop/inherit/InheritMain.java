package pop.inherit;

public class InheritMain {
    public static void main(String[] args) {
        ElectricCar cElectricCar1 = new ElectricCar();
        cElectricCar1.setColor("Black");
        cElectricCar1.setManufacturer("HONDA");
        cElectricCar1.setModel("Civic");
        cElectricCar1.setWeight(1250.5d);
        cElectricCar1.setSize(11.5f);
        cElectricCar1.setSpeed(160);
        cElectricCar1.setElectricEngine("TDA");
        System.out.println("Car 1");
        System.out.println(cElectricCar1);
        cElectricCar1.speedUp(40);
        System.out.println(cElectricCar1);
        ElectricCar cElectricCar2 = new ElectricCar("White", "HUNDAY", "Accent",
                1300.7d, 12.6f, 150,"HXZ");
        System.out.println("Car 2");
        System.out.println(cElectricCar2);
        cElectricCar2.speedUp(30);
        System.out.println(cElectricCar2);
    }
}
