package com.springboot.models;

public class CarModel {
    private Integer id;
    private String color;
    private String manufacturer;
    private String model;
    public CarModel(){}
    public CarModel(Integer id, String color, String manufacturer, String model){
        this.id = id;
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
