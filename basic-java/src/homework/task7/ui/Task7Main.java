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
        checkSave(carInterface, car1);
        carInterface.saveCar(car2);
        checkSave(carInterface, car1);
        carInterface.saveCar(car3);
        checkSave(carInterface, car1);
        // Showing Cars
        for (Car car : carInterface.findAll()) {
            System.out.println(car);
        }
        // Deleting Cars
        carInterface.deleteCar(car1);
        checkDelete(carInterface, car1);
        carInterface.deleteCar(car2);
        checkDelete(carInterface, car2);
        carInterface.deleteCar(car3);
        checkDelete(carInterface, car3);
        // Verifying is the DataBase is empty
        isEmptyDataBase(carInterface);
    }
    private static void checkSave(CarInterface carInterface, Car car){
        if (carInterface.contain(car)) {
            System.out.println("Saving Car: " + car.getId());
        }
    }
    private static void checkDelete(CarInterface carInterface, Car car){
        if (carInterface.contain(car)) {
            System.out.println("Deleting was successfully");
        }
    }
    private static void isEmptyDataBase(CarInterface carInterface) {
        if (carInterface.findAll().isEmpty()){
            System.out.println("The Car Data Base is empty");
        } else {
            System.out.println("The Car Data Base is not empty");
        }
    }
}
