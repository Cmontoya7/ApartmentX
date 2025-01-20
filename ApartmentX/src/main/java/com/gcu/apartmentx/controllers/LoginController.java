package com.gcu.apartmentx.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.apartmentx.models.LoginModel;

@Controller
public class LoginController {
	
	@GetMapping("/login")
    public String display(Model model) 
    {
        // Set the title attribute
        model.addAttribute("title", "Login Form");

        // Set the loginModel attribute with an instance of LoginModel
        model.addAttribute("loginModel", new LoginModel());

        // Return the view name "login"
        return "login";
    }
    
    
}
