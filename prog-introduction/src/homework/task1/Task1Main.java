package homework.task1.main;

import homework.task1.module.*;

public class Main {
    public static void main(String[] args) {
        // Exe 1
        System.out.println("Exe 1");
        HomeWork hw = new HomeWork();
        int resultSum = hw.sum(1, 2, 3);
        System.out.println(resultSum);
        // Exe 2
        System.out.println("Exe 2");
        Car car = new Car();
        car.incrementDoors();
        System.out.println(car.getDoorsNumber());
    }
}