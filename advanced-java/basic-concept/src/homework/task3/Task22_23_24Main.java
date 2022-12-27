package homework.task3;

public class Task22_23_24Main {
    public static void main(String[] args) {

    }
}
abstract class Car {
    private String model;
    private String brand;
    private String color;

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
class ImprovedCar extends Car {
    private int speed;

    public ImprovedCar() {
    }

    public void speedUp() {
        speed++;
    }

    public void speedDown() {
        speed--;
    }
}
class ElectricCar extends Car {
    private String battery;
    public ElectricCar() {
        super();
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }
}
class CombustionCar extends Car {
    private String combustionType;
    public CombustionCar() {
        super();
    }
    public String getCombustionType() {
        return combustionType;
    }
    public void setCombustionType(String combustionType) {
        this.combustionType = combustionType;
    }
}
class HybridCar extends Car {
    private int mode;
    public HybridCar() {
        super();
    }
    public int getMode() {
        return mode;
    }
    public void setMode(int mode) {
        this.mode = mode;
    }
}


