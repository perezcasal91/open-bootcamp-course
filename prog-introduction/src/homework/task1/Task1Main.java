package homework.task1;

/**
 * Class which objective is to answer the Task 1
 */
public class Task1Main {
    public static void main(String[] args) {
        exe1();
        exe2();
    }
    private static void exe1() {
        System.out.println("Exe 1");
        Sum cSum = new Sum();
        int iSumResult = cSum.sum(1, 2, 3);
        System.out.println(iSumResult);
    }
    private static void exe2() {
        System.out.println("Exe 2");
        Car cCar = new Car();
        cCar.incrementDoors();
        System.out.println(cCar.getDoorsNumber());
    }
}
/**
 * Class Sum answering the exercise 1
 */
class Sum {
    public int sum(int a, int b, int c) {return a + b + c;}
}
/**
 * Class Car answering the exercise 2
 */
class Car {
    private int doorsNumber;
    public Car() {}
    public void incrementDoors(){this.doorsNumber++;}
    public int getDoorsNumber() {return doorsNumber;}
}