package pop.polymorphism;

public class Car {

    // Attributes
    private String color;
    private String manufacturer;
    private String model;
    private Double weight;
    private Float size;
    private Integer speed;
    // Empty Constructor
    public Car(){}
    // Constructor with parameter
    public Car(String color, String manufacturer, String model, Double weight, Float size, Integer speed){
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
        this.size = size;
        this.speed = speed;
    }
    // Getter and Setter
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
    }
    public Integer getSpeed() {
        return speed;
    }
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
    // To String Method
    @Override
    public String toString() {
        return "Car {" +
                " color=" + getColor() +
                ", manufacturer=" + getManufacturer() +
                ", model=" + getModel() +
                ", weight=" + getWeight() +
                ", size=" + getSize() +
                ", speed=" + getSpeed() +
                 " } ";
    }
    // Behavior
    public void speedUp(Integer quantity){
        if(quantity > 0 && quantity < 100){
            var newSpeed = this.speed + quantity;
            if (newSpeed < 250) {
                setSpeed(newSpeed);
            }
        }
    }
}
