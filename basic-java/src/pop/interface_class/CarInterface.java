package pop.interface_class;

public interface CarInterface {
    public Car createCar(String color, String manufacturer, String model, Double weight, Float size, Integer speed);
    public Car updateCar(Car car, String color, String manufacturer, String model, Double weight, Float size, Integer speed);
}
