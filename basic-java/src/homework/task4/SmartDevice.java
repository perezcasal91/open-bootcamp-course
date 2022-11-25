package homework.task4;

public class SmartDevice {
    private String brand;
    private String model;
    private String color;
    private String manufacturer;
    private String operativeSystem;
    private boolean sensors;
    private String dimensions;
    public SmartDevice() {}
    public SmartDevice(String brand, String model, String color, String manufacturer, String operativeSystem, boolean sensors, String dimensions) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.manufacturer = manufacturer;
        this.operativeSystem = operativeSystem;
        this.sensors = sensors;
        this.dimensions = dimensions;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
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
    public String getOperativeSystem() {
        return operativeSystem;
    }
    public void setOperativeSystem(String operativeSystem) {
        this.operativeSystem = operativeSystem;
    }
    public boolean isSensors() {
        return sensors;
    }
    public void setSensors(boolean sensors) {
        this.sensors = sensors;
    }
    public String getDimensions() {
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    @Override
    public String toString() {
        return "SmartDevice {" +
                " brand=" + this.getBrand() +
                ", model=" + this.getModel() +
                ", color=" + this.getColor() +
                ", manufacturer=" + this.getManufacturer() +
                ", operativeSystem=" + this.getOperativeSystem() +
                ", sensors=" + this.isSensors() +
                ", dimensions=" + this.getDimensions() +
                " } ";
    }
}
