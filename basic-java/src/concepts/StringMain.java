package concepts;

public class StringMain {
    public static void main(String[] args) {
        String aString = "Hello World";
        if (aString.equals("Hello")){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        System.out.println(aString.length());
        System.out.println(aString.trim());
        System.out.println(aString.toUpperCase());
        System.out.println(aString.toLowerCase());
    }

}
