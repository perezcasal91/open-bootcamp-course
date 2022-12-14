package com.springboot.springreststarting.models;

public class CarModel {
    private String color;
    private String manufacturer;
    private String model;
    public CarModel(){}
    public CarModel(String color, String manufacturer, String model){
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "CarModel { " +
                "color=" + color +
                ", manufacturer=" + manufacturer +
                ", model=" + model +
                " } ";
    }
}
