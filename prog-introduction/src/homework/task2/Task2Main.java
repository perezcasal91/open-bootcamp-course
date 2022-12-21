package homework.task2.main;

import homework.task2.module.*;

public class Main {
    public static void main(String[] args) {
        HomeWork hm = new HomeWork();
        // Exe 1
        System.out.println("Exe 1");
        System.out.println(hm.verifyNumber(3));
        System.out.println(hm.verifyNumber(-1));
        // Exe 2
        System.out.println("Exe 2");
        hm.whileFunction();
        // Exe 3
        System.out.println("Exe 3");
        hm.doWhileFunction();
        // Exe 4
        System.out.println("Exe 5");
        hm.forFunction();
        // Exe 5
        System.out.println("Exe 6");
        hm.switchFunction("Winter");
        hm.switchFunction("Hot");
    }
}