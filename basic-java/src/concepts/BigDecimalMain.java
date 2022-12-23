package concepts;

import java.math.BigDecimal;

/**
 * Init with Big Decimal.
 * Using some method of the Object BigDecimal.
 */
public class BigDecimalMain {
    public static void main(String[] args) {
        BigDecimal bdA = new BigDecimal(5);
        BigDecimal bdB = new BigDecimal(2);
        BigDecimal bdResultSum = bdA.add(bdB);
        System.out.println(bdResultSum);
        BigDecimal bdResultSubtract = bdA.subtract(bdB);
        System.out.println(bdResultSubtract);
        BigDecimal bdResultMultiply = bdA.multiply(bdB);
        System.out.println(bdResultMultiply);
        BigDecimal bdResultDivide = bdA.divide(bdB);
        System.out.println(bdResultDivide);
        BigDecimal bdResultPow = bdA.pow(2);
        System.out.println(bdResultPow);
    }
}
