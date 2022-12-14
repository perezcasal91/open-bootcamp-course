package recursivity;

public class RecursivityMain {
    public static void main(String[] args) {

    }
    private static int recursiveSum(int n){
        if (n == 1){
            return 1;
        }
        return n + recursiveSum(n - 1);
    }
    private static int fibonacci(int n){
        return n;
    }
    private static String integerToBinary(int n){
        return "" + n;
    }
    private static int binaryToInt(String n){
        return 0;
    }

}
