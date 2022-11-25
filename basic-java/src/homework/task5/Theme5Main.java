package homework.task5;

public class Theme5Main {
    public static void main(String[] args) {
        // Creating Cars
        CarInterface carInterface = new CarImplement();
        Car car1 = carInterface.createCar(1, "Black", "HONDA", "Civic",
                1100.7d, 11.6f, 110);
        Car car2 = carInterface.createCar(2, "White", "HONDA", "Civic",
                1200.7d, 12.6f, 120);
        Car car3 = carInterface.createCar(3, "Gray", "HONDA", "Civic",
                1300.7d, 13.6f, 130);
        // Save
        carInterface.saveCar(car1);
        if (carInterface.contain(car1)) {
            System.out.println("Saving Car: " + car1.getId());
        }
        carInterface.saveCar(car2);
        if (carInterface.contain(car2)) {
            System.out.println("Saving Car: " + car2.getId());
        }
        carInterface.saveCar(car3);
        if (carInterface.contain(car3)) {
            System.out.println("Saving Car: " + car2.getId());
        }
        // Showing Cars
        for (Car car : carInterface.findAll()) {
            System.out.println(car);
        }
        // Deleting Cars
        carInterface.deleteCar(car1);
        if (!carInterface.contain(car1)) {
            System.out.println("Deleting was successfully");
        }
        carInterface.deleteCar(car2);
        if (!carInterface.contain(car2)) {
            System.out.println("Deleting was successfully");
        }
        carInterface.deleteCar(car3);
        if (!carInterface.contain(car3)) {
            System.out.println("Deleting was successfully");
        }
        // Verifying is the DataBase is empty
        if (carInterface.findAll().isEmpty()){
            System.out.println("The Car Data Base is empty");
        } else {
            System.out.println("The Car Data Base is not empty");
        }
    }
}
