package concepts;

import java.util.Vector;

/**
 * Init with the Vector.
 * Using some methods.
 */
public class VectorMain {
    public static void main(String[] args) {
        Vector<String> cVector = new Vector<>();
        cVector.add("Test");
        System.out.println(cVector.get(0));
        System.out.println(cVector.capacity());
        cVector.add(1, "Second");
        System.out.println(cVector.capacity());
        for (String sValue : cVector) {
            System.out.println(sValue);
        }
    }
}
