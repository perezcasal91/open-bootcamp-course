package functional_prog;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionalMain {
    public static void main(String[] args) {
        PureFunction pureFunction = new PureFunction();
        System.out.println(pureFunction.pureSum(6,7));
        LambdaFunction lambdaFunction = new LambdaFunction();
        System.out.println(lambdaFunction.sum.apply(5));
        System.out.println(lambdaFunction.toUpperCase.apply("elio"));
        System.out.println(callFunction(lambdaFunction.toUpperCase, "Daylen"));
        StreamFunction streamFunction = new StreamFunction();
        streamFunction.streamStringList();
        streamFunction.streamIntegerList();
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
    public int noPureSum(int a, int b){
        count++;
        return a + b;
    }
}
class LambdaFunction {
    public Function<String, String> toUpperCase = String::toUpperCase;
    public Function<Integer, Integer> sum = a -> a + 5;
}
class StreamFunction {
    private ArrayList<String> stringArrayList;
    private ArrayList<Integer> integerArrayList;
    private void initStringList(){
        stringArrayList = new ArrayList<>();
        stringArrayList.add("Ross");
        stringArrayList.add("Elio");
        stringArrayList.add("Kye");
        stringArrayList.add("Day");
    }
    private void initIntegerList(){
        integerArrayList = new ArrayList<>();
        integerArrayList.add(1);
        integerArrayList.add(2);
        integerArrayList.add(3);
        integerArrayList.add(4);
    }
    public void streamStringList(){
        initStringList();
        Stream<String> mapStream = stringArrayList.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("K"));
        mapStream.forEach(System.out::println);
    }
    public void streamIntegerList(){
        initIntegerList();
        Integer result = integerArrayList.stream()
                .map(n->n+5)
                .filter(n-> n % 2 == 0)
                .reduce(0, (n, m) -> {
                    System.out.println("N: " + n + "" + " M: " + m);
                    return n + m;
                });
        System.out.println(result);
    }
}

