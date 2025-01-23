package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.business.RegistrationBean;
import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    RegistrationBean register = new RegistrationBean();

    @GetMapping("/register")
    public String register(Model model) {
        return "Register";
    }

    @PostMapping("/register/submitRegistration") //TEMP will direct to database
    public String submitRegistrationForm(@ModelAttribute ApartmentXUser user, Model model) {
        register.addUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getNameFirst(), user.getNameLast());
        System.out.println("received registration: " + user.toString());
        return "RegisterSuccess";
    }
}
