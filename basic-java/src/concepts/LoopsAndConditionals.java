package concepts;

public class LoopsAndConditionals {

    // IF - ELSE
    public void ifElseFunction(){
        System.out.println("If - Else check boolean variable");
        boolean aBoolean = true;
        if(!aBoolean){
            System.out.println(aBoolean);
        } else {
            System.out.println(aBoolean);
        }
        System.out.println("If - Else check variable value");
        int anInt = 1;
        if(anInt != 5){
            System.out.println(anInt);
        } else {
            System.out.println(anInt);
        }
    }
    // FOR
    public void forFunction(){
        System.out.println("For with iteration by variable i");
        for (int i = 0; i < 10; i++) {
            if (i != 9) {
                System.out.print(i + " ");
            } else System.out.print(i);
        }
        System.out.println();
        System.out.println("For by item");
        String s = "Text";
        for (char a: s.toCharArray()) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("For using continue");
        for (int i = 0; i < 10; i++) {
            if (i == 5){
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("For using break");
        for (int i = 0; i < 10; i++) {
            if (i == 5){
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
    // WHILE
    public void whileFunction(){
        System.out.println("While with iteration by variable i");
        int i = 0;
        while (i < 10) {
            if (i != 9) {
                System.out.print(i + " ");
            } else System.out.print(i);
            i++;
        }
        System.out.println();
        System.out.println("While check boolean variable");
        boolean aBoolean = true;
        while (aBoolean) {
            System.out.println("In");
            aBoolean = false;
            System.out.println("Out");
        }
        System.out.println("While using continue");
        int j = 0;
        while (j < 10) {
            if (j == 5){
                j++;
                continue;
            }
            System.out.print(j + " ");
            j++;
        }
        System.out.println();
        System.out.println("While using break");
        int k = 0;
        while (k < 10) {
            if (k == 5){
                break;
            }
            System.out.print(k + " ");
            k++;
        }
        System.out.println();
    }
    // SWITCH
    public void switchFunction(int option){
        System.out.println("Within different output for every case");
        switch (option) {
            case 1 -> System.out.println("Option is A" + option);
            case 2 -> System.out.println("Option is B" + option);
            case 3 -> System.out.println("Option is C" + option);
            default -> System.out.println("Option is not valid");
        }
        System.out.println("If the output of every case is similar");
        switch (option) {
            case 1, 2, 3 -> System.out.println("Option is" + option);
            default -> System.out.println("Option is not valid");
        }
    }
}
