package concepts;

import java.util.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Test");
        System.out.println(vector.get(0));
        System.out.println(vector.capacity());
        vector.add(1, "Second");
        System.out.println(vector.capacity());
        for (String s : vector) {
            System.out.println(s);
        }
    }
}
