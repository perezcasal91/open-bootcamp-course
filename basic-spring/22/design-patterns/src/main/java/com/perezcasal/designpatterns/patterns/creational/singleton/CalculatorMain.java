package com.perezcasal.designpatterns.patterns.creational.singleton;

public class CalculatorMain {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.calculateDoublePrice();

        Offer offer = new Offer();
        offer.calculateTotalOffer();

        if (invoice.getCalculator() == offer.getCalculator()) {
            System.out.println("It is the same object.");
        } else {
            System.out.println("Are not the same.");
        }
    }
}

class Calculator {
    private static Calculator calculator;

    private Calculator() {}

    public static Calculator getInstance() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public int sum(int a, int b) {
        return a + b;
    }
}

class Invoice {
    private final Calculator calculator;

    public Invoice() {
        calculator = Calculator.getInstance();
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public double calculateDoublePrice() {
        return calculator.sum(1,3);
    }

}

class Offer {
    private final Calculator calculator;

    public Offer() {
        calculator = Calculator.getInstance();
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public double calculateTotalOffer() {
        return calculator.sum(1,3);
    }

}
