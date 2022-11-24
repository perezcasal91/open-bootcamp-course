package concepts;

import java.util.Locale;

public class StringMethods {
    private String aString = "Hello World";
    public void equals(){
        if (aString.equals("Hello")){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
    public void length(){
        System.out.println(aString.length());
    }
    public void trim(){
        System.out.println(aString.trim());
    }
    public void upperCase(){
        System.out.println(aString.toUpperCase());
    }
    public void lowerCase(){
        System.out.println(aString.toLowerCase());
    }
}
