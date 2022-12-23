package homework.task5;

public class Theme5Main {
    public static void main(String[] args) {
        CarInterface cCarInterface = new CarImplement();
        Car cCar1 = cCarInterface.createCar(1, "Black", "HONDA", "Civic",
                1100.7d, 11.6f, 110);
        Car cCar2 = cCarInterface.createCar(2, "White", "HONDA", "Civic",
                1200.7d, 12.6f, 120);
        Car cCar3 = cCarInterface.createCar(3, "Gray", "HONDA", "Civic",
                1300.7d, 13.6f, 130);
        cCarInterface.saveCar(cCar1);
        checkSave(cCarInterface, cCar1);
        cCarInterface.saveCar(cCar2);
        checkSave(cCarInterface, cCar1);
        cCarInterface.saveCar(cCar3);
        checkSave(cCarInterface, cCar1);
        for (Car car : cCarInterface.findAll()) {
            System.out.println(car);
        }
        cCarInterface.deleteCar(cCar1);
        checkDelete(cCarInterface, cCar1);
        cCarInterface.deleteCar(cCar2);
        checkDelete(cCarInterface, cCar2);
        cCarInterface.deleteCar(cCar3);
        checkDelete(cCarInterface, cCar3);
        isEmptyDataBase(cCarInterface);
    }
    private static void checkSave(CarInterface carInterface, Car car) {
        if (carInterface.contain(car)) {
            System.out.println("Saving Car: " + car.getId());
        }
    }
    private static void checkDelete(CarInterface carInterface, Car car) {
        if (carInterface.contain(car)) {
            System.out.println("Deleting was successfully");
        }
    }
    private static void isEmptyDataBase(CarInterface carInterface) {
        if (carInterface.findAll().isEmpty()) {
            System.out.println("The Car Data Base is empty");
        } else {
            System.out.println("The Car Data Base is not empty");
        }
    }
}
