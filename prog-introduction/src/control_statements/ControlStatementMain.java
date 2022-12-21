package control_statements;

/**
 * Init with Control Statements
 */
public class ControlStatementMain {
    public static void main(String[] args) {
        ControlStatements cControlStatements = new ControlStatements();
        cControlStatements.ifElseStatement("spring");
        cControlStatements.whileStatement();
        cControlStatements.doWhileStatement();
        cControlStatements.forStatement();
        cControlStatements.switchStatement("spring", "wednesday");
    }
}
/**
 * Class with some examples of Control Statements
 */
class ControlStatements {
    public void ifElseStatement(String season) {
        System.out.println("IF-Else");
        if (season.equals("summer")){
            System.out.println("The season is: " + season);
        } else if (season.equals("spring")) {
            System.out.println("The season is: " + season);
        } else {
            System.out.println("The season is other");
        }
    }
    public void whileStatement() {
        System.out.println("While");
       int iCount = 10;
       while (iCount > 0) {
           System.out.print(iCount + " ");
           iCount--;
       }
        System.out.println();
    }
    public void doWhileStatement() {
        System.out.println("Do-While");
        int iCount = 1;
        do {
            System.out.print(iCount + " ");
            iCount++;
        }
        while (iCount < 11);
        System.out.println();
    }
    public void forStatement() {
        System.out.println("For");
        System.out.print("For-Forward: ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("For-Backward: ");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("For-Each-Array: ");
        int [] aNumbers = {1,2,3,4,5,6,7,8,9,10};
        for (int number: aNumbers) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.print("For-i-Array-Backward: ");
        for (int i = aNumbers.length - 1; i >= 0; i--) {
            System.out.print(aNumbers[i] + " ");
        }
        System.out.println();
    }
    public void switchStatement(String season, String day) {
        System.out.println("Switch");
        switch (season) {
            case "spring", "summer", "autumn", "winter" -> System.out.println("The season is: " + season);
            default -> System.out.println("No exits such season: " + season);
        }
        switch (day) {
            case "monday", "tuesday", "wednesday", "thursday", "friday" ->
                    System.out.println("The " + day + " is a weekday.");
            case "saturday", "sunday" -> System.out.println("The " + day + " is not a weekday.");
            default -> System.out.println("No exits such day: " + day);
        }
    }
}
