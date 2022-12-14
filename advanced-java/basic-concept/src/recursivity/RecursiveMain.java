package recursivity;

import java.util.stream.IntStream;

public class RecursiveMain {
    public static void main(String[] args) {
        headRecursive(5);
        System.out.println();
        tailRecursive(5);
        System.out.println();
        System.out.println(recursiveSum(5));
        System.out.println(functionalSum(5));
        System.out.println(recursiveFactorial(5));
        System.out.println(functionalFactorial(5));
        recursiveFibonacci(5);
        System.out.println();
        var binary = integerToBinary(5);
        System.out.println(binary);
        System.out.println(binaryToInt(binary));
    }
    private static void headRecursive(int n){
        if (n == 0){
            return;
        }
        tailRecursive(n - 1);
        System.out.print(n + " ");
    }
    private static void tailRecursive(int n){
        if (n == 0){
            return;
        }
        System.out.print(n + " ");
        tailRecursive(n - 1);
    }
    private static int recursiveSum(int n){
        if (n == 1){
            return 1;
        }
        return n + recursiveSum(n - 1);
    }
    private static int functionalSum(int n){
        return IntStream.rangeClosed(1, n)
                .reduce(0, Integer::sum);
    }
    private static int recursiveFactorial(int n){
        if (n == 0){
            return 1;
        }
        return n * recursiveFactorial(n - 1);
    }
    private static int functionalFactorial(int n){
        return IntStream.rangeClosed(1, n)
                .reduce(1, Math::multiplyExact);
    }
    private static void recursiveFibonacci(int n){
        for (int i = 0; i <= n; i++) {
            System.out.print(baseFibonacci(i) + " ");
        }
    }
    private static int baseFibonacci(int n){
        if (n <= 1){
            return n;
        }
        return baseFibonacci(n - 1) + baseFibonacci(n - 2);
    }
    private static String integerToBinary(int n){
        if (n == 1){
            return "" + 1;
        }
        if (n == 0){
            return "" + 0;
        }
        return integerToBinary(n / 2) + n % 2 ;
    }
    private static int binaryToInt(String s){
        var n = 0;
       for (int i = 0; i < s.length(); i++){
           n += Math.pow(i + 1, 2) * Integer.parseInt("" + s.charAt(i));
       }
       return n;
    }
}
