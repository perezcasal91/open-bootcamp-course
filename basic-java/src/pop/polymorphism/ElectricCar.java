package pop.polymorphism;

public class ElectricCar extends Car {
    private String electricEngine;
    public ElectricCar() {}
    public ElectricCar(String electricEngine){
        this.electricEngine = electricEngine;
    }
    public ElectricCar(String color, String manufacturer, String model, Double weight,
                       Float size, Integer speed, String electricEngine) {
        super(color, manufacturer, model, weight, size, speed);
        this.electricEngine = electricEngine;
    }
    public String getElectricEngine() {
        return electricEngine;
    }
    public void setElectricEngine(String electricEngine) {
        this.electricEngine = electricEngine;
    }
    @Override
    public void speedUp(Integer quantity) {
        quantity += 10;
        super.speedUp(quantity);
    }
    @Override
    public String toString() {
        return "ElectricCar {" +
                " color=" + super.getColor() +
                ", manufacturer= " + super.getManufacturer()  +
                ", model=" + super.getModel() +
                ", weight=" + super.getWeight() +
                ", size=" + super.getSize() +
                ", speed=" + super.getSpeed() +
                ", electricEngine='" + getElectricEngine() +
                " } ";
    }
}
