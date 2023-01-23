package com.perezcasal.userauth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);

    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                       AccessDeniedException accessDeniedException) throws IOException {
        logger.info("Executing CustomAccessDeniedHandler");

        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        httpServletResponse.setContentType("application/json");

        var data = new HashMap<>();
        data.put("timestamp", new Date());
        data.put("status", HttpStatus.FORBIDDEN.value());
        data.put("message", "Access Denied, login again!");
        data.put("path", httpServletRequest.getRequestURL().toString());

        var servletOutputStream = httpServletResponse.getOutputStream();
        var objectMapper = new ObjectMapper();
        objectMapper.writeValue(servletOutputStream, data);
        servletOutputStream.flush();
    }
}
