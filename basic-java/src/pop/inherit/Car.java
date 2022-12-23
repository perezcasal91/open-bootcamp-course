package pop.inherit;

public class Car {
    private String color;
    private String manufacturer;
    private String model;
    private Double weight;
    private Float size;
    private Integer speed;
    public Car() {}
    public Car(String color, String manufacturer, String model, Double weight, Float size, Integer speed) {
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
        this.size = size;
        this.speed = speed;
    }
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
    public void speedUp(Integer quantity) {
        if(quantity > 0 && quantity < 100) {
            var vNewSpeed = this.speed + quantity;
            if (vNewSpeed < 250) {
                setSpeed(vNewSpeed);
            }
        }
    }
}
