package com.perezcasal.initjwt.dto;

import com.perezcasal.initjwt.domain.CarEntity;

public class CarMessageDTO {
    private String message;
    private CarEntity car;
    public CarMessageDTO() {}
    public CarMessageDTO(String message) {this.message = message;}
    public CarMessageDTO(String message, CarEntity car) {this.message = message;this.car = car;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public CarEntity getCar() {return car;}
    public void setCar(CarEntity car) {this.car = car;}
}
