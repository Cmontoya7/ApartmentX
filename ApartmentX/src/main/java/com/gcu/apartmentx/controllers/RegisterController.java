package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.business.RegistrationBean;
import com.gcu.apartmentx.business.RegistrationInterface;
import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private RegistrationInterface register = new RegistrationBean();

    @GetMapping("/register")
    public String register() {
        return "Register";
    }

    @PostMapping("/register/submitRegistration")
    public String submitRegistrationForm(@ModelAttribute ApartmentXUser user, @RequestParam(value = "action", required = false) String type) {
        // Send the user to the success page if the registration works
    	if (register.addUser(type, user.getUsername(), user.getEmail(), user.getPassword(), user.getNameFirst(), user.getNameLast()))
    	{
    		return "RegisterSuccess";
    	}
    	// Show the registration failure page if it is not successful
        return "RegisterFailure";
    }
}
