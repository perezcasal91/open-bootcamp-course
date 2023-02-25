package com.perezcasal.junit.operation;

public class Arithmetic {

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("The division by 0 is not allowed.");
        }
        return a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
