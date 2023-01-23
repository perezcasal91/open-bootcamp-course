package com.perezcasal.initjwt.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tr_car")
@Tag(name = "Car Entity")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "id", description = "Id",
            type = "Long", example = "1")
    private Long id;
    @Column(name = "manufacturer")
    @Schema(name = "manufacturer", description = "Manufacturer",
            type = "String", example = "BMW")
    private String manufacturer;
    @Column(name = "model")
    @Schema(name = "model", description = "Model",
            type = "String", example = "ACCENT")
    private String model;
    @Column(name = "cc")
    @Schema(name = "cc", description = "Cubic Capacity",
            type = "Double", example = "4.5")
    private Double cc;
    @Column(name = "doors")
    @Schema(name = "doors", description = "Doors",
            type = "Integer", example = "3 or more")
    private Integer doors;
    @Column(name = "year")
    @Schema(name = "year", description = "Year",
            type = "Integer", example = "2023")
    private Integer year;
    @Column(name = "release_date")
    @Schema(name = "releaseDate", description = "Release Date",
            type = "LocalDate", example = "20223-01-13")
    private LocalDate releaseDate;
    @Column(name = "available")
    @Schema(name = "available", description = "Available",
            type = "Boolean", example = "true or false")
    private Boolean available;

    public CarEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getCc() {
        return cc;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarEntity car)) return false;
        return Objects.equals(manufacturer, car.manufacturer)
                && Objects.equals(model, car.model)
                && Objects.equals(cc, car.cc)
                && Objects.equals(doors, car.doors)
                && Objects.equals(year, car.year)
                && Objects.equals(releaseDate, car.releaseDate)
                && Objects.equals(available, car.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, cc, doors, year, releaseDate, available);
    }

    @Override
    public String toString() {
        return String
                .format("Car[id=%d, manufacturer=%s, model=%s," +
                " cc=%s, doors=%d, year=%d, release_date=%s, available=%s",
                id, manufacturer, model, cc, doors, year, releaseDate, available);
    }
}
