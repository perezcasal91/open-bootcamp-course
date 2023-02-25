package com.perezcasal.initcsrf.controller.rest;

import com.perezcasal.initcsrf.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @GetMapping("/api/home")
    public String home(){
        return "Welcome Home";
    }

    @GetMapping("/api/test")
    public String test(){
        return "Welcome Test";
    }

    @PostMapping("/api/users")
    public String save(@RequestBody UserDTO userDTO) {
        return "User save successfully with the email" + userDTO.getEmail();
    }
}
