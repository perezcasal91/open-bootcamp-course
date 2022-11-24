package concepts;

public class BuclesAndConditionals {

    // IF - ELSE
    private void iFElseFunction(){
        // If - Else check boolean variable
        boolean aBoolean = true;
        if(aBoolean){

        }else {

        }
        // If - Else check variable value
        int anInt = 10;
        if(anInt == 10){

        }else{

        }
    }
    // FOR
    private void forFunction(){
        // For with iteration by variable i
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        // For by item
        String s = "Text";
        for (char a: s.toCharArray()) {
            System.out.println(a);
        }
        // For using continue
        for (int i = 0; i < 10; i++) {
            if (i == 5){
                continue;
            }
            System.out.println(i);
        }
        // For using break
        for (int i = 0; i < 10; i++) {
            if (i == 5){
                break;
            }
            System.out.println(i);
        }
    }
    // WHILE
    private void whileFunction(){
        // While with iteration by variable i
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
        // While check boolean variable
        boolean aBoolean = true;
        while (aBoolean) {
            System.out.println("In");
            aBoolean = false;
            System.out.println("Out");
        }
        // While using continue
        while (i < 10) {
            if (i == 5){
                continue;
            }
            i++;
        }
        // While using break
        while (i < 10) {
            if (i == 5){
                break;
            }
            i++;
        }
    }
    // SWITCH
    private void switchFunction(){
        int option = 3;
        // Within different output for every case
        switch (option){
            case 1:
                System.out.println("Option is A" + option);
                break;
            case 2:
                System.out.println("Option is B" + option);
                break;
            case 3:
                System.out.println("Option is C" + option);
                break;
            default:
                System.out.println("Option is not valid");
                break;
        }
        // If the output of every case is similar
        switch (option){
            case 1:
            case 2:
            case 3:
                System.out.println("Option is" + option);
                break;
            default:
                System.out.println("Option is not valid");
                break;
        }
    }
}
