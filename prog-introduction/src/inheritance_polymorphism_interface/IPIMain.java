package herite_polimorfismo_interface;

public class InheritanceMain {
    public static void main(String[] args) {
        ElectricCar cElectricCar = new ElectricCar();
        cElectricCar.setPlate("XXX");
        cElectricCar.setMaxSpeed(120);
        cElectricCar.setMotor("WES");
        System.out.println(cElectricCar.getMaxSpeed());
        cElectricCar.verifyPlate("XYZ");
        cElectricCar.verifyMotor("WES");
    }
}
abstract class Vehicle {
    private String plate;
    private int maxSpeed;
    public Vehicle() {
    }
    public String getPlate() {return plate;}
    public void setPlate(String plate) {this.plate = plate;}
    public int getMaxSpeed() {return maxSpeed;}
    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}
    public abstract void verifyPlate(String plate);
}
abstract class Car extends Vehicle {
    private String motor;
    public Car() {}
    @Override
    public void verifyPlate(String plate) {
        if (getPlate().equals(plate)) {
            System.out.println("Is the same plate");
        } else {
            System.out.println("The plate is not the same");
        }
    }
    public String getMotor() {return motor;}
    public void setMotor(String motor) {this.motor = motor;}
    public abstract void verifyMotor(String motor);
}
class ElectricCar extends Car {
    public ElectricCar() {}
    @Override
    public void verifyMotor(String motor) {
        if (getMotor().equals(motor)) {
            System.out.println("Is the same motor");
        } else {
            System.out.println("The motor is not the same");
        }
    }
}