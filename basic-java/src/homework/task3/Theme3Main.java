package homework.task3;

public class Theme3Main {
    public static void main(String[] args) {
        String[] names = {"Jon", "Klee", "Jess", "Kyle"};
        StringBuilder combinedNames = new StringBuilder();
        int index = 1;
        for (String name : names) {
            if (index != names.length) {
                combinedNames.append(index).append("=").append(name).append(" ");
            } else {
                combinedNames.append(index).append("=").append(name);
            }
            index++;
        }
        System.out.println("Combined Names: " + combinedNames);
    }
}
