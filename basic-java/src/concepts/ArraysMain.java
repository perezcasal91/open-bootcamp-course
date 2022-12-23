package concepts;

/**
 * Init with Arrays.
 * Create two arrays, integer and string.
 * Looping though the arrays.
 */
public class ArraysMain {
    public static void main(String[] args) {
        Integer [] iNumbers = new Integer[5];
        String  [] sStrings = {"a", "b", "c", "d", "e"};
        for (int i = 0; i < 5; i++) {
            iNumbers[i] = i + 1;
        }
        for (Integer number: iNumbers) {
            System.out.println(number);
        }
        for (String string: sStrings) {
            System.out.println(string);
        }
    }
}
