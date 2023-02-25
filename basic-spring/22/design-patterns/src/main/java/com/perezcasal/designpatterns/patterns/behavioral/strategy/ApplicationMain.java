package com.perezcasal.designpatterns.patterns.behavioral.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ApplicationMain {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.print("""
                        Please, select a product:
                        1 - Mother board
                        2 - CPU
                        3 - HDD
                        4 - Memory
                        """);
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("""
                        Please, select a payment method:
                        1 - PalPay
                        2 - Credit Card""");
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPalStrategy();
                } else {
                    strategy = new PayByCreditCardStrategy();
                }
            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(strategy);

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
}

interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}

class PayByPayPalStrategy implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String email, password;
    private boolean signedIn;

    static {
        DATA_BASE.put("elio", "elio@admin.com");
        DATA_BASE.put("day", "day@user.com");
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using Paypal.");
            return true;
        }
        return false;
    }

    @Override
    public void collectPaymentDetails() {
        try {
            if (!signedIn) {
                System.out.println("Enter the user's email: ");
                email = reader.readLine();
                System.out.println("Enter the password: ");
                password = reader.readLine();
                if (verify(email, password)) {
                    System.out.println("Data verification has been successful.");
                } else {
                    System.out.println("Wrong email or password.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean verify(String email, String password) {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}

class PayByCreditCardStrategy implements PayStrategy {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard creditCard;
    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
        }
        return false;
    }

    private boolean cardIsPresent() {
        return creditCard != null;
    }

    @Override
    public void collectPaymentDetails() {
        try {
            System.out.println("Enter the card number: ");
            String number = reader.readLine();
            System.out.println("Enter the card expiration date 'mm/yy': ");
            String date = reader.readLine();
            System.out.println("Enter the CVV code: ");
            String cvv = reader.readLine();
            creditCard = new CreditCard(number, date, cvv);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class CreditCard {
    private int amount;
    private String number, date, cvv;

    public CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

class Order {
    private int totalCost = 0;
    private boolean isClosed = false;

    public void processOrder(PayStrategy payStrategy) {
        payStrategy.collectPaymentDetails();
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
