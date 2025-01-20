package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class RegisterController {
    @GetMapping("/register")
    public String register(Model model) {
        return "Register";
    }

    @PostMapping("/register/submitRegistration") //TEMP will direct to database
    public String submitRegistrationForm(@ModelAttribute ApartmentXUser user, Model model) {
        System.out.println("received registration: " + user.toString());
        return "RegisterSuccess";
    }
}
