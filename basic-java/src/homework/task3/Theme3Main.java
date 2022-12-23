package homework.task3;

public class Theme3Main {
    public static void main(String[] args) {
        String [] aNames = {"Jon", "Klee", "Jess", "Kyle"};
        StringBuilder sbCombinedNames = new StringBuilder();
        int index = 1;
        for (String sName : aNames) {
            if (index != aNames.length) {
                sbCombinedNames.append(index).append("=").append(sName).append(" ");
            } else {
                sbCombinedNames.append(index).append("=").append(sName);
            }
            index++;
        }
        System.out.println("Combined Names: " + sbCombinedNames);
    }
}
