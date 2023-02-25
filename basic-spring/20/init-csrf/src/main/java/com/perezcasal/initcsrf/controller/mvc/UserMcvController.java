package com.perezcasal.initcsrf.controller.mvc;

import com.perezcasal.initcsrf.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserMcvController {

    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user-form";
    }
    @PostMapping("/users")
    public String save(@ModelAttribute("user") UserDTO userDTO) {
        System.out.println(userDTO);
        return "success";
    }
}
