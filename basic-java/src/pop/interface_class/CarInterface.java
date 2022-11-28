package pop.interface_class;

public interface CarInterface {
    Car createCar(String color, String manufacturer, String model, Double weight, Float size, Integer speed);
    Car updateCar(Car car, String color, String manufacturer, String model, Double weight, Float size, Integer speed);
}
