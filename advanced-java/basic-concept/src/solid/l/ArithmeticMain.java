package solid.l;

public class ArithmeticMain {
    public static void main(String[] args) {
        Arithmetic arithmetic = new ImproveArithmetic();
        System.out.println(arithmetic.sum(1,2));
        System.out.println(arithmetic.subtract(2,1));
        System.out.println(arithmetic.multiply(1,2));
        System.out.println(arithmetic.divide(2,1));
        System.out.println();
        arithmetic = new InformationArithmetic();
        System.out.println(arithmetic.sum(1,2));
        System.out.println(arithmetic.subtract(2,1));
        System.out.println(arithmetic.multiply(1,2));
        System.out.println(arithmetic.divide(2,1));
    }
}
abstract class Arithmetic {
    public abstract int sum(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract int multiply(int a, int b);
    public abstract int divide(int a, int b);
}
class ImproveArithmetic extends Arithmetic {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
    @Override
    public int divide(int a, int b) {
     return b == 0? 0 : a / b;
    }
}

class InformationArithmetic extends Arithmetic {
    @Override
    public int sum(int a, int b) {
        System.out.println("sum()");
        return a + b;
    }
    @Override
    public int subtract(int a, int b) {
        System.out.println("subtract()");
        return a - b;
    }
    @Override
    public int multiply(int a, int b) {
        System.out.println("multiply()");
        return a * b;
    }
    @Override
    public int divide(int a, int b) {
        System.out.println("divide()");
        return b == 0 ? 0 : a / b;
    }
}
