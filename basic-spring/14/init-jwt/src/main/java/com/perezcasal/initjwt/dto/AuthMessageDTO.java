package com.perezcasal.initjwt.dto;

public class AuthMessageDTO {
    private String message;
    public AuthMessageDTO() {}
    public AuthMessageDTO(String message) {this.message = message;}
    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
}
