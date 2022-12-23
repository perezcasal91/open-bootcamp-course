package homework.task7.model;

public class Car {
    private Integer id;
    private String color;
    private String manufacturer;
    private String model;
    private CarWeightOrSpeed weight;
    private CarSize size;
    private CarWeightOrSpeed speed;
    public Car() {}
    public Car(Integer id, String color, String manufacturer, String model,
               CarWeightOrSpeed weight, CarSize size, CarWeightOrSpeed speed){
        this.id = id;
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
        this.size = size;
        this.speed = speed;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public CarWeightOrSpeed getWeight() {
        return weight;
    }
    public void setWeight(CarWeightOrSpeed weight) {
        this.weight = weight;
    }
    public CarSize getSize() {
        return size;
    }
    public void setSize(CarSize size) {
        this.size = size;
    }
    public CarWeightOrSpeed getSpeed() {
        return speed;
    }
    public void setSpeed(CarWeightOrSpeed speed) {
        this.speed = speed;
    }
    @Override
    public String toString() {
        return this.getColor();
    }
}
