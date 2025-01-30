package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.business.RegistrationBean;
import com.gcu.apartmentx.business.RegistrationInterface;
import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private RegistrationInterface register = new RegistrationBean();

    @GetMapping("/register")
    public String register() {
        return "Register";
    }

    @PostMapping("/register/submitRegistration") //TEMP will direct to database
    public String submitRegistrationForm(@ModelAttribute ApartmentXUser user, @RequestParam(value = "action", required = false) String type) {
        //Send the new user information to Registration bean to be added to Pseudo-Database
        register.addUser(type, user.getUsername(), user.getEmail(), user.getPassword(), user.getNameFirst(), user.getNameLast());
        return "RegisterSuccess";
    }

    @GetMapping("/deleteuser")
    public String deleteUser(@RequestParam(value = "id", required = true) int id) {
        return "DeleteUser";
    }
}
