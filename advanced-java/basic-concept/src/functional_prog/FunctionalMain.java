package functional_prog;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionalMain {
    public static void main(String[] args) {
        PureFunction cPureFunction = new PureFunction();
        System.out.println(cPureFunction.pureSum(6,7));
        LambdaFunction cLambdaFunction = new LambdaFunction();
        System.out.println(cLambdaFunction.fSum.apply(5));
        System.out.println(cLambdaFunction.fToUpperCase.apply("elio"));
        System.out.println(callFunction(cLambdaFunction.fToUpperCase, "Daylen"));
        StreamFunction cStreamFunction = new StreamFunction();
        cStreamFunction.streamStringList();
        cStreamFunction.streamIntegerList();
    }
    private static String callFunction(Function<String, String> function, String name){
        return function.apply(name);
    }
}
class PureFunction {
    private int count;
    public int pureSum(int a, int b){
        return a + b;
    }
    public int noPureSum(int a, int b) {
        count++;
        return a + b;
    }
}
class LambdaFunction {
    public Function<String, String> fToUpperCase = String::toUpperCase;
    public Function<Integer, Integer> fSum = a -> a + 5;
}
class StreamFunction {
    private ArrayList<String> alStrings;
    private ArrayList<Integer> alIntegers;
    private void initStringList() {
        alStrings = new ArrayList<>();
        alStrings.add("Ross");
        alStrings.add("Elio");
        alStrings.add("Kye");
        alStrings.add("Day");
    }
    private void initIntegerList() {
        alIntegers = new ArrayList<>();
        alIntegers.add(1);
        alIntegers.add(2);
        alIntegers.add(3);
        alIntegers.add(4);
    }
    public void streamStringList() {
        initStringList();
        var vsStrings = alStrings.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("K"));
        vsStrings.forEach(System.out::println);
    }
    public void streamIntegerList() {
        initIntegerList();
        var viResult = alIntegers.stream()
                .map(n -> n + 5)
                .filter(n -> n % 2 == 0)
                .reduce(0, (n, m) -> {
                    System.out.println("N: " + n + "" + " M: " + m);
                    return n + m;
                });
        System.out.println(viResult);
    }
}

