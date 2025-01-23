package com.gcu.apartmentx.controllers;


import javax.validation.Valid;
import javax.servlet.http.HttpSession;

import com.gcu.apartmentx.business.AuthenticationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.apartmentx.models.LoginModel;

@Controller
public class LoginController
{
    @Autowired
    private AuthenticationBean authentication = new AuthenticationBean();
	/**
     * Handles GET requests to the root URI and sets up the model
     */
    @GetMapping("/login")
    public String display(Model model) 
    {
        // Set the title attribute
        model.addAttribute("title", "Login Form");

        // Set the loginModel attribute with an instance of LoginModel
        model.addAttribute("loginModel", new LoginModel());

        // Return the view name "login"
        return "Login";
    }
    
    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, Model model, HttpSession session) {
        // Check for submission errors
        String msg = authentication.authenticate(loginModel.getUsername(), loginModel.getPassword());
        if (!authentication.result){
            model.addAttribute("title", "Login Form");
            model.addAttribute("message", msg);
            return "Login";
        } else {
            // Return the view name for orders
            session.setAttribute("username", loginModel.getUsername());
            return "Homepage";
        }
    }

}