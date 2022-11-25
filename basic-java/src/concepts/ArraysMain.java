package concepts;

public class ArraysMain {
    public static void main(String[] args) {
        Integer [] numbers = new Integer[5];
        String  [] strings = new String[]{"a", "b", "c", "d", "e"};
        for (int i = 0; i < 5; i++) {
            numbers[i] = i + 1;
        }
        for (Integer number: numbers) {
            System.out.println(number);
        }
        for (String string: strings) {
            System.out.println(string);
        }
    }
}
