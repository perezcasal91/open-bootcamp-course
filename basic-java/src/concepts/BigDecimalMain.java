package concepts;

import java.math.BigDecimal;

public class BigDecimalMain {
    public static void main(String[] args) {
        BigDecimal bigDecimalA = new BigDecimal(5);
        BigDecimal bigDecimalB = new BigDecimal(2);
        BigDecimal resultSum = bigDecimalA.add(bigDecimalB);
        System.out.println(resultSum);
        BigDecimal resultSubtract = bigDecimalA.subtract(bigDecimalB);
        System.out.println(resultSubtract);
        BigDecimal resultMultiply = bigDecimalA.multiply(bigDecimalB);
        System.out.println(resultMultiply);
        BigDecimal resultDivide = bigDecimalA.divide(bigDecimalB);
        System.out.println(resultDivide);
        BigDecimal resultPow = bigDecimalA.pow(2);
        System.out.println(resultPow);
    }
}
