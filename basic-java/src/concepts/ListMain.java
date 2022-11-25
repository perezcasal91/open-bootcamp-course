package concepts;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        List<String> stringList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
           numberList.add(i + 1);
        }
        for (Integer number: numberList) {
            System.out.println(number);
        }
        for (int i = 0; i < 5; i++) {
            stringList.add(""+ i);
        }
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
        System.out.println(numberList.contains(3));
        System.out.println(numberList.indexOf(3));
        System.out.println(numberList.isEmpty());
        System.out.println(numberList.remove(4));
    }
}
