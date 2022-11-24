package task2.module;

public class HomeWork {
    public boolean verifyNumber(int number) {
        return number > 0;
    }
    public void whileFunction(){
        int whileNumber = 0;
        while (whileNumber < 3){
            whileNumber++;
            System.out.println(whileNumber);
        }
    }
    public void doWhileFunction(){
        int whileNumber = 2;
        do {
            whileNumber++;
            System.out.println(whileNumber);
        }
        while (whileNumber < 3);
    }
    public void forFunction(){
        for (int forNumber = 0;forNumber <= 3; forNumber++){
            System.out.println(forNumber);
        }
    }
    public void switchFunction(String season){
        switch (season){
            case "Summer":
            case "Autumn":
            case "Winter":
            case "Springs":
                System.out.println("We are in: " + season);
                break;
            default:
                System.out.println("The option you select is not Season");
                break;
        }
    }
}
