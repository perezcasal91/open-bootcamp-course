package com.perezcasal.designpatterns.patterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMain {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product p1 = new Product("a", 2.5);
        Product p2 = new Product("b", 3.5);
        shoppingCart.add(p1, p2);
        shoppingCart.pay(new PayPalStrategy());
    }
}

class Product {
    private String code;
    private Double price;

    public Product(String code, Double price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

class ShoppingCart {
    private final ArrayList<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }
    public void add(Product ... newProducts) {
        this.products.addAll(List.of(newProducts));
    }
    public void remove(Product ... oldProducts) {
        this.products.removeAll(List.of(oldProducts));
    }
    public void pay(PaymentStrategy paymentMethod) {
        Double result = products.stream()
                .map(Product::getPrice)
                .reduce(Double::sum)
                .orElse(0d);
        paymentMethod.pay(result);
    }
}

interface PaymentStrategy {
    void pay(Double amount);
}

class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(Double amount) {
        System.out.println("Paying with CreditCardStrategy: " + amount);
    }
}

class PayPalStrategy implements PaymentStrategy {
    @Override
    public void pay(Double amount) {
        System.out.println("Paying with PayPalStrategy: " + amount);
    }
}