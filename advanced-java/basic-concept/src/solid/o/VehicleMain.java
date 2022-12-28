package solid.o;

public class VehicleMain {
    public static void main(String[] args) {
        CarI vehicleIC = new CarI();
        vehicleIC.setModel("XXX");
        vehicleIC.speedUp();
        vehicleIC.speedDown();
        System.out.println(vehicleIC.getModel() + " " + vehicleIC.getSpeed());
        System.out.println();
        ElectricCarI vehicleIE = new ElectricCarI();
        vehicleIE.setModel("XXX");
        vehicleIE.setBattery("QWE");
        vehicleIE.speedUp();
        vehicleIE.speedDown();
        System.out.println(vehicleIE.getModel()
                + " " + vehicleIE.getSpeed()
                + " " + vehicleIE.getBattery());
        System.out.println();
        CarA vehicleAC = new CarA();
        vehicleAC.setModel("XXX");
        vehicleAC.speedUp();
        vehicleAC.speedDown();
        System.out.println(vehicleAC.getModel() + " " + vehicleAC.getSpeed());
        System.out.println();
        ElectricCarA vehicleAE = new ElectricCarA();
        vehicleAE.setModel("XXX");
        vehicleAE.setBattery("QWE");
        vehicleAE.speedUp();
        vehicleAE.speedDown();
        System.out.println(vehicleAE.getModel()
                + " " + vehicleAE.getSpeed()
                + " " + vehicleAE.getBattery());

    }
}
interface VehicleI {
     void speedUp();
     void speedDown();
}

class CarI implements VehicleI {
    private String model;
    private int speed;
    public CarI() {}
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getSpeed() {
        return speed;
    }
    @Override
    public void speedUp() {
        speed++;
    }
    @Override
    public void speedDown() {
        speed--;
    }
}
class ElectricCarI implements VehicleI {
    private String model;
    private int speed;
    private String battery;
    public ElectricCarI() {}
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getSpeed() {
        return speed;
    }
    public String getBattery() {
        return battery;
    }
    public void setBattery(String battery) {
        this.battery = battery;
    }
    @Override
    public void speedUp() {
        speed++;
    }
    @Override
    public void speedDown() {
        speed--;
    }
}
abstract class VehicleA {
    private String model;
    private int speed;
    public VehicleA() {}
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public abstract void speedUp();
    public abstract void speedDown();
}

class CarA extends VehicleA {
    public CarA() {
        super();
    }
    @Override
    public void speedUp() {
        setSpeed(getSpeed() + 1);
    }
    @Override
    public void speedDown() {
        setSpeed(getSpeed() - 1);
    }
}
class ElectricCarA extends VehicleA {
    private String battery;
    public ElectricCarA() {
        super();
    }
    public String getBattery() {
        return battery;
    }
    public void setBattery(String battery) {
        this.battery = battery;
    }
    @Override
    public void speedUp() {
        setSpeed(getSpeed() + 1);
    }
    @Override
    public void speedDown() {
        setSpeed(getSpeed() - 1);
    }
}




