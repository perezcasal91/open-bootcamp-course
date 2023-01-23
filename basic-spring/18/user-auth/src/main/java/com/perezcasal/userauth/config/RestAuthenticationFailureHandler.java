package com.perezcasal.userauth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@Component
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final Logger logger = LoggerFactory.getLogger(RestAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure
            (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
             AuthenticationException authenticationException) throws IOException {
        logger.info("Executing onAuthenticationFailure");

        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());

        var data = new HashMap<>();
        data.put("timestamp", new Date());
        data.put("status",HttpStatus.FORBIDDEN.value());
        data.put("message", "Access Denied, Bad Credentials!! Try again!");
        data.put("path", httpServletRequest.getRequestURL().toString());

        var out = httpServletResponse.getOutputStream();
        var mapper = new ObjectMapper();
        mapper.writeValue(out, data);
        out.flush();
    }
}
