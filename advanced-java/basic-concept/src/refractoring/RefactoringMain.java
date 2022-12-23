package refractoring;

import java.util.Arrays;

public class RefactoringMain {
    public static void main(String[] args) {
        Refactor refactor = new Refactor();
        refactor.printMinorAndMajor(1,4,5,6,23,45);
        System.out.println(refactor.isSunday(7));
        refactor.isOpenJDKAndWinOS();
        LargeConstructor largeConstructor = new LargeConstructorBuilder()
                .setString1("1")
                .setString2("2")
                .setString3("3")
                .setString4("4")
                .setString5("5")
                .build();
        System.out.println(largeConstructor);
    }
}
class Refactor {
    public void printMinorAndMajor(int ...numbers) {
        var statistics = Arrays.stream(numbers).summaryStatistics();
        System.out.println("Minor: " + statistics.getMin() + " Major: " + statistics.getMax());
    }
    public boolean isSunday(int day) {
        return day == 7;
    }
    public void isOpenJDKAndWinOS() {
        boolean javaRuntime = System.getProperty("java.runtime.name").contains("OpenJDK");
        boolean osVersion = System.getProperty("os.version").contains("10.0");
        if (javaRuntime && osVersion) {
            System.out.println("Is OpenJDK Runtime Environment and OS Version 10.0");
        }
    }
}
class LargeConstructorBuilder {
    private final LargeConstructor largeConstructor;
    public LargeConstructorBuilder() {this.largeConstructor = new LargeConstructor();}
    public LargeConstructorBuilder setString1(String string1) {this.largeConstructor.setString1(string1); return this;}
    public LargeConstructorBuilder setString2(String string2) {this.largeConstructor.setString2(string2); return this;}
    public LargeConstructorBuilder setString3(String string3) {this.largeConstructor.setString3(string3); return this;}
    public LargeConstructorBuilder setString4(String string4) {this.largeConstructor.setString4(string4); return this;}
    public LargeConstructorBuilder setString5(String string5) {this.largeConstructor.setString5(string5); return this;}
    public LargeConstructor build() {return largeConstructor;}
}
class LargeConstructor {
    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    public LargeConstructor() {}
    public String getString1() {return string1;}
    public void setString1(String string1) {this.string1 = string1;}
    public String getString2() {return string2;}
    public void setString2(String string2) {this.string2 = string2;}
    public String getString3() {return string3;}
    public void setString3(String string3) {this.string3 = string3;}
    public String getString4() {return string4;}
    public void setString4(String string4) {this.string4 = string4;}
    public String getString5() {return string5;}
    public void setString5(String string5) {this.string5 = string5;}

    @Override
    public String toString() {
        return "LargeConstructor " +
                "{" +
                    " string1=" + getString1() +
                    ", string2=" + getString2() +
                    ", string3=" + getString3() +
                    ", string4=" + getString4() +
                    ", string5=" + getString5() +
                " } ";
    }
}