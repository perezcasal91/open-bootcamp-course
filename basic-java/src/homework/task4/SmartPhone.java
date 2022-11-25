package homework.task4;

public class SmartPhone extends SmartDevice{
    private boolean wireless;
    private String broadband;
    private boolean frontCamera;
    private boolean backCamera;
    public SmartPhone(){}
    public SmartPhone(boolean wireless, String broadband, boolean frontCamera, boolean backCamera) {
        this.wireless = wireless;
        this.broadband = broadband;
        this.frontCamera = frontCamera;
        this.backCamera = backCamera;
    }
    public SmartPhone(String brand, String model, String color, String manufacturer, String operativeSystem, boolean sensors, String dimensions, boolean wireless, String broadband, boolean frontCamera, boolean backCamera) {
        super(brand, model, color, manufacturer,operativeSystem, sensors, dimensions);
        this.wireless = wireless;
        this.broadband = broadband;
        this.frontCamera = frontCamera;
        this.backCamera = backCamera;
    }
    public boolean isWireless() {
        return wireless;
    }
    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }
    public String getBroadband() {
        return broadband;
    }
    public void setBroadband(String broadband) {
        this.broadband = broadband;
    }
    public boolean isFrontCamera() {
        return frontCamera;
    }
    public void setFrontCamera(boolean frontCamera) {
        this.frontCamera = frontCamera;
    }
    public boolean isBackCamera() {
        return backCamera;
    }
    public void setBackCamera(boolean backCamera) {
        this.backCamera = backCamera;
    }
    @Override
    public String toString() {
        return "SmartPhone {" +
                " brand=" + super.getBrand() +
                ", model=" + super.getModel() +
                ", color=" + super.getColor() +
                ", manufacturer=" + super.getManufacturer() +
                ", sensors=" + super.isSensors() +
                ", dimensions=" + super.getDimensions() +
                ", operativeSystem=" + super.getOperativeSystem() +
                ", wireless=" + this.isWireless() +
                ", broadband=" + this.getBroadband() +
                ", frontCamera=" + this.isFrontCamera() +
                ", backCamera=" + this.isBackCamera() +
                " } ";
    }
}
