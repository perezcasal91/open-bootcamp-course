package creational_patterns.builder;

public class BuilderMain {
    public static void main(String[] args) {
        CarModel car = new CarBuilder()
                .setModel("XYZ")
                .setColor("Black")
                .build();
        System.out.println(car);
    }
}
class CarBuilder {
    private CarModel carModel;
    public CarBuilder() {
        carModel = new CarModel();
    }
    public CarBuilder setModel(String model){
        carModel.setModel(model);
        return this;
    }
    public CarBuilder setColor(String color){
        carModel.setColor(color);
        return this;
    }
    public CarModel build(){return carModel;}
}
class CarModel {
    private String model;
    private String color;
    public CarModel (){}
    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    @Override
    public String toString() {
        return "CarModel { " +
                "model=" + model +
                ", color=" + color +
                " } ";
    }
}
