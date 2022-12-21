package poo;

/**
 * Init with Programming Object-Oriented
 */
public class POOMain {
    public static void main(String[] args) {
        Car cCar1 = new Car();
        System.out.println("Car 1");
        System.out.println("Doors Number: "+ cCar1.getDoorsNumber());
        System.out.println("Current Speed: " + cCar1.getCurrentSpeed());
        cCar1.speedUp();
        System.out.println("Current Speed: " + cCar1.getCurrentSpeed());
        System.out.println("Max Speed: " + cCar1.getMaxSpeed());
        System.out.println("Car 2");
        Car cCar2 = new Car(4, 120, 0);
        System.out.println("Doors Number: "+ cCar2.getDoorsNumber());
        System.out.println("Current Speed: " + cCar2.getCurrentSpeed());
        cCar2.speedUp();
        System.out.println("Current Speed: " + cCar2.getCurrentSpeed());
        System.out.println("Max Speed: " + cCar2.getMaxSpeed());
        System.out.println("Car 3");
        Car cCar3 = new Car();
        cCar3.setDoorsNumber(6);
        System.out.println("Doors Number: "+ cCar3.getDoorsNumber());
        System.out.println("Current Speed: " + cCar3.getCurrentSpeed());
        cCar3.speedUp();
        System.out.println("Current Speed: " + cCar3.getCurrentSpeed());
        cCar3.setMaxSpeed(150);
        System.out.println("Max Speed: " + cCar3.getMaxSpeed());
    }
}

/**
 * An example of POO
 */
class Car {
    private int doorsNumber;
    private int maxSpeed;
    private int currentSpeed;
    public Car() {
        this.doorsNumber = 2;
        this.maxSpeed = 100;
        this.currentSpeed = 0;
    }
    public Car(int doorsNumber, int maxSpeed, int currentSpeed) {
        this.doorsNumber = doorsNumber;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
    }
    public int getDoorsNumber() {return doorsNumber;}
    public void setDoorsNumber(int doorsNumber) {this.doorsNumber = doorsNumber;}
    public int getMaxSpeed() {return maxSpeed;}
    public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}
    public void speedUp() {if (currentSpeed < maxSpeed) this.currentSpeed += 10;}
    public int getCurrentSpeed() {return currentSpeed;}
}
