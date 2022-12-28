package solid.s;

public class VehicleMain {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("XXX");
        vehicle.fillTank();
        vehicle.fillTank();
    }
}
class Vehicle {
    private String model;
    private int speed;
    private final Pump pump;
    public Vehicle () {
        this.pump = new Pump();
    }

    public void speedUp() {
        speed++;
    }
    public void speedDown() {
        speed--;
    }
    public void fillTank() {
        pump.pourGasoline(this);
    }
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
}

class Pump {
    private boolean tankIsEmpty;
    public void pourGasoline (Vehicle vehicle) {
        if (!tankIsEmpty) {
            System.out.println("The tank for the " + vehicle.getModel() + " is full now.");
            tankIsEmpty = true;
        } else {
            System.out.println("The tank of the " + vehicle.getModel() + " is already full.");
            tankIsEmpty = false;
        }
    }
}
