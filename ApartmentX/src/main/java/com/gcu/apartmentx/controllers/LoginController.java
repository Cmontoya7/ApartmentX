package com.gcu.apartmentx.controllers;


import javax.validation.Valid;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.apartmentx.models.LoginModel;

@Controller
public class LoginController
{
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
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model, HttpSession session)
    {
        // Check for submission errors
    	if (bindingResult.hasErrors())
    	{
    		model.addAttribute("title", "Login Form");
    		return "Login";
    	}

        // Return the view name for orders
        System.out.println("received Login: " + loginModel.toString());
        session.setAttribute("username", loginModel.getUsername());
        return "Homepage";
    }

}