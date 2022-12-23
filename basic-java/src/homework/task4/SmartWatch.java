package homework.task4;

public class SmartWatch extends SmartDevice {
    private String form;
    private String strap;
    public SmartWatch(){}
    public SmartWatch(String form, String strap) {
        this.form = form;
        this.strap = strap;
    }
    public SmartWatch(String brand, String model, String color, String manufacturer,
                      String operativeSystem, boolean sensors, String dimensions,
                      String form, String strap) {
        super(brand, model, color, manufacturer, operativeSystem, sensors, dimensions);
        this.form = form;
        this.strap = strap;
    }
    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }
    public String getStrap() {
        return strap;
    }
    public void setStrap(String strap) {
        this.strap = strap;
    }
    @Override
    public String toString() {
        return "SmartWatch {" +
                " brand=" + super.getBrand() +
                ", model=" + super.getModel() +
                ", color=" + super.getColor() +
                ", manufacturer=" + super.getManufacturer() +
                ", operativeSystem=" + super.getOperativeSystem() +
                ", sensors=" + super.isSensors() +
                ", dimensions=" + super.getDimensions() +
                ", form=" + this.getForm() +
                ", strap=" + this.getStrap() +
                " } ";
    }
}
