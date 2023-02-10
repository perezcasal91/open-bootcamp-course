package com.perezcasal.userauth.model.dto;

import java.time.LocalDate;

public record ExceptionDTO(int status,
        String message,
        LocalDate date) {
}
