package homework.task2;

/**
 * Class which objective is to answer the Task 2
 */
public class Task2Main {
    public static void main(String[] args) {
        Task2 cTask2 = new Task2();
        exe1(cTask2);
        exe2(cTask2);
        exe3(cTask2);
        exe4(cTask2);
        exe5(cTask2);
    }
    private static void exe1(Task2 task2) {
        System.out.println("Exe 1");
        System.out.println(task2.verifyNumber(3));
        System.out.println(task2.verifyNumber(-1));
    }
    private static void exe2(Task2 task2) {
        System.out.println("Exe 2");
        task2.whileFunction();
    }
    private static void exe3(Task2 task2) {
        System.out.println("Exe 3");
        task2.doWhileFunction();
    }
    private static void exe4(Task2 task2) {
        System.out.println("Exe 4");
        task2.forFunction();
    }
    private static void exe5(Task2 task2) {
        System.out.println("Exe 5");
        task2.switchFunction("Winter");
        task2.switchFunction("Hot");
    }
}
/**
 * Class Task 2 answering the exercises 1, 2, 3, 4 and 5
 */
class Task2 {
    public boolean verifyNumber(int number) {
        return number > 0;
    }
    public void whileFunction() {
        int sValue = 0;
        while (sValue < 3) {
            sValue++;
            System.out.print(sValue + " ");
        }
        System.out.println();
    }
    public void doWhileFunction() {
        int sValue = 1;
        do {
            sValue++;
            System.out.print(sValue + " ");
        }
        while (sValue < 1);
        System.out.println();
    }
    public void forFunction() {
        for (int i = 0;i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public void switchFunction(String season) {
        switch (season) {
            case "Summer", "Autumn", "Winter", "Springs" ->
                    System.out.println("We are in: " + season);
            default -> System.out.println("The option you select is not Season");
        }
    }
}