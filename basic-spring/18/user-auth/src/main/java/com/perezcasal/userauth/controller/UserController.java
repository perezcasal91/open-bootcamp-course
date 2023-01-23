package com.perezcasal.userauth.controller;

import com.perezcasal.userauth.config.RestAuthenticationFailureHandler;
import com.perezcasal.userauth.config.TokenProvider;
import com.perezcasal.userauth.model.dto.AuthToken;
import com.perezcasal.userauth.model.dto.LoginUser;
import com.perezcasal.userauth.model.dto.UserDTO;
import com.perezcasal.userauth.model.entity.UserEntity;
import com.perezcasal.userauth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final UserService userService;

    public UserController(AuthenticationManager authenticationManager, TokenProvider tokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {
        final Authentication authentication;
        authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = tokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new AuthToken(token));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new RestAuthenticationFailureHandler());
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserEntity saveUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage() {
        return "Admin Page";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage() {
        return "User Page";
    }

    @PreAuthorize("hasRole('MANAGER')")
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String managerPage() {
        return "Manger Page";
    }
}
