package concepts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Init with the List.
 * Using some methods.
 */
public class ListMain {
    public static void main(String[] args) {
        List<Integer> lNumbers = new ArrayList<>();
        List<String> lStrings = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            lNumbers.add(i + 1);
        }
        for (Integer number: lNumbers) {
            System.out.println(number);
        }
        for (int i = 0; i < 5; i++) {
            lStrings.add(""+ i);
        }
        for (String lString : lStrings) {
            System.out.println(lString);
        }
        System.out.println(lNumbers.contains(3));
        System.out.println(lNumbers.indexOf(3));
        System.out.println(lNumbers.isEmpty());
        System.out.println(lNumbers.remove(4));
    }
}
