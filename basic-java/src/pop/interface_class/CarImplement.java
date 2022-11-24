package pop.interface_class;

public class CarImplement implements CarInterface{
    @Override
    public Car createCar(String color, String manufacturer, String model, Double weight, Float size, Integer speed) {
        return new Car( color, manufacturer, model, weight, size, speed);
    }
    @Override
    public Car updateCar(Car car, String color, String manufacturer, String model, Double weight, Float size, Integer speed) {
        car.setColor(color);
        car.setManufacturer(manufacturer);
        car.setModel(model);
        car.setWeight(weight);
        car.setSize(size);
        car.setSpeed(speed);
        return car;
    }
}
