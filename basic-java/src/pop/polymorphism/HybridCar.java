package pop.polymorphism;

public class HybridCar extends Car {
    private String hybridEngine;
    public HybridCar(){
    }
    public HybridCar(String hybridEngine){
        this.hybridEngine = hybridEngine;
    }
    public HybridCar(String color, String manufacturer, String model, Double weight,
                     Float size, Integer speed, String hybridEngine){
        super(color, manufacturer, model, weight, size, speed);
        this.hybridEngine = hybridEngine;
    }
    public String getHybridEngine() {
        return hybridEngine;
    }
    public void setHybridEngine(String hybridEngine) {
        this.hybridEngine = hybridEngine;
    }
    @Override
    public void speedUp(Integer quantity){
        quantity += 20;
        super.speedUp(quantity);
    }
    @Override
    public String toString() {
        return "HybridCar {" +
                " color=" + super.getColor() +
                ", manufacturer= " + super.getManufacturer()  +
                ", model=" + super.getModel() +
                ", weight=" + super.getWeight() +
                ", size=" + super.getSize() +
                ", speed=" + super.getSpeed() +
                ", hybridEngine='" + getHybridEngine() +
                " } ";
    }
}
