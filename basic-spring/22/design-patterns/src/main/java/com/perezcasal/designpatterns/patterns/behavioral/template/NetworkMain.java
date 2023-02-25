package com.perezcasal.designpatterns.patterns.behavioral.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NetworkMain {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String username;
        try {
            username = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Input password: ");
        String password;
        try {
            password = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Input message: ");
        String message;
        try {
            message = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("""
                Choose social network for posting message.
                1 - Facebook
                2 - Twitter""");
        int choice;
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (choice == 1) {
            network = new Facebook(username, password);
        } else if (choice == 2) {
            network = new Twitter(username, password);
        }
        assert network != null;
        network.post(message);
    }
}

abstract class Network {
    String username;
    String password;

    Network() {}

    public void post(String message) {
        if (logIn(username, password)) {
            boolean result = sendData(message.getBytes());
            if (result)
                logOut();
        }
    }

    public void simulateNetworkLatency() {
        try {
            int i = 0;
            System.out.println();
            while (i < 10) {
                System.out.print(".");
                Thread.sleep(500);
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    abstract boolean logIn(String username, String password);
    abstract boolean sendData(byte... data);
    abstract void logOut();
}

class Facebook extends Network {

    Facebook(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    boolean logIn(String username, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.username);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Facebook");
        return true;
    }

    @Override
    boolean sendData(byte... data) {
        System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
        return true;
    }

    @Override
    void logOut() {
        System.out.println("User: '" + username + "' was logged out from Facebook");
    }
}

class Twitter extends Network {

    public Twitter(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean logIn(String userName, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Name: " + this.username);
        System.out.print("Password: ");
        for (int i = 0; i < this.password.length(); i++) {
            System.out.print("*");
        }
        simulateNetworkLatency();
        System.out.println("\n\nLogIn success on Twitter");
        return true;
    }

    public boolean sendData(byte[] data) {
        System.out.println("Message: '" + new String(data) + "' was posted on Twitter");
        return true;
    }

    public void logOut() {
        System.out.println("User: '" + username + "' was logged out from Twitter");
    }
}
