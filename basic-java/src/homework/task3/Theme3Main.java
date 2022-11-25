package homework.task3;

public class Theme3Main {
    public static void main(String[] args) {
        String[] names = {"Jon", "Klee", "Jess", "Kyle"};
        String combinedNames = "";
        int index = 1;
        for (String name : names) {
            if (index != names.length) {
                combinedNames += index + "=" + name + " ";
            } else {
                combinedNames += index + "=" + name;
            }
            index++;
        }
        System.out.println("Combined Names: " + combinedNames);
    }
}
