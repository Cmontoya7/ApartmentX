package com.gcu.apartmentx.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;

/**
 * Controller class responsible for handling login functionality
 * Provides methods for displaying the login page and handling login success
 */
@Controller
public class LoginController {
	@Autowired
	UserDataService userDataService;
	
	/**
	 * Displays the login form view when accessing the /login URL
	 * @param model the model to pass data to the view
	 * @return the login view name
	 */
	@GetMapping("/login")
    public String display(Model model)
    {
    	// Display login form view
    	model.addAttribute("title", "Login Form");
    	return "login";
    }
	
	/**
	 * Handles login success and sets session variables for the authenticated user
	 * @param session the current HTTP session to store user data
	 * @return the homepage view after successful login
	 */
    @GetMapping("/login-success")
    public String loginSuccess(HttpSession session) {
        // Get the authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Get the id of the user and convert it to an int
        int id = Integer.parseInt(authentication.getName());
        // Find the userEntity object that corresponds to the user id
        UserEntity userEntity = userDataService.findById(id);
        
        // Set session variables
        session.setAttribute("username", userEntity.getUsername());
        session.setAttribute("level", userEntity.getType());
        session.setAttribute("id", id);

        return "Homepage";
    }
}
