package com.perezcasal.designpatterns.patterns.behavioral.template;

public class ComputerStationMain {
    public static void main(String[] args) {
       ComputerBuilder standardComputer = new StandardComputerBuilder().buildComputer();
        System.out.println(standardComputer.getComputer().getMotherBoard());
        ComputerBuilder highEndComputer = new HighEndComputerBuilder().buildComputer();
        System.out.println(highEndComputer.getComputer().getMotherBoard());
    }
}

/**
 * This an abstract computer template
 */
abstract class ComputerBuilder {
    private Computer computer;

    public final ComputerBuilder buildComputer() {
        computer = new Computer(addMotherBoard(), addSetupMotherBoard(), addProcessor());
       return this;
    }

    public Computer getComputer() {
        return computer;
    }

    public abstract String addMotherBoard();
    public abstract String addSetupMotherBoard();
    public abstract String addProcessor();
}

class Computer {

    private String motherBoard, setupMotherBoard, processor;

    public Computer(String motherBoard, String setupMotherBoard, String processor) {
        this.motherBoard = motherBoard;
        this.setupMotherBoard = setupMotherBoard;
        this.processor = processor;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public String getSetupMotherBoard() {
        return setupMotherBoard;
    }

    public void setSetupMotherBoard(String setupMotherBoard) {
        this.setupMotherBoard = setupMotherBoard;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
}

class StandardComputerBuilder extends ComputerBuilder {

    @Override
    public String addMotherBoard() {
        return "Motherboard: Standard Motherboard";
    }

    @Override
    public String addSetupMotherBoard() {
        return "Screwing the standard motherboard to the case.";
    }

    @Override
    public String addProcessor() {
        return "Processor: Standard Processor";
    }
}

class HighEndComputerBuilder extends ComputerBuilder {

    @Override
    public String addMotherBoard() {
        return "Motherboard: High-end Motherboard";
    }

    @Override
    public String addSetupMotherBoard() {
        return "Screwing the high-end motherboard to the case.";
    }

    @Override
    public String addProcessor() {
        return "Processor: High-end Processor";
    }
}
