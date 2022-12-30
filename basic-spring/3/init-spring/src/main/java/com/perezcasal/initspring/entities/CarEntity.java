package com.perezcasal.initspring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model;
    private String manufacturer;
    private String color;
    private Integer carYear;
    public CarEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return carYear;
    }

    public void setYear(Integer year) {
        this.carYear = year;
    }

    @Override
    public String toString() {
        return String
                .format("Car[id=%d, model='%s', manufacturer='%s', color='%s', year='%d']",
                id, model, manufacturer, color, carYear);
    }
}
