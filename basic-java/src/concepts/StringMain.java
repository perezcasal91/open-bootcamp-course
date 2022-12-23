package concepts;

/**
 * Init with String.
 * Using some methods.
 */
public class StringMain {
    public static void main(String[] args) {
        String sString = "Hello World";
        if (sString.contains("Hello")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        System.out.println(sString.length());
        System.out.println(sString.trim());
        System.out.println(sString.toUpperCase());
        System.out.println(sString.toLowerCase());
    }
}
