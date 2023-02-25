package com.perezcasal.csrf.controller.rest;

import com.perezcasal.csrf.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @GetMapping("/home")
    public String home(){
        return "Welcome Home";
    }

    @GetMapping("/users")
    public String save(@RequestBody UserDTO userDTO) {
        return "User save successfully with the email " + userDTO.getEmail();
    }
}
