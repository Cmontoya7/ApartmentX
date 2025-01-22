package com.gcu.controllers;

import com.gcu.models.ApartmentXUser;
import com.gcu.models.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApartmentXController {
	
	@GetMapping("/")
    public ModelAndView homepage() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Test Homepage");
        mav.setViewName("Homepage");
        return mav;
    }
    
    @GetMapping("/login")
    public String display(Model model){
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "Login";
    }
    
    @GetMapping("/register")
    public String register() {
    	return "Register";
    }
    
    @PostMapping("/register/submitRegistration") //TEMP will direct to database
    public String submitRegistrationForm(@ModelAttribute ApartmentXUser user) {
    	System.out.println("recieved registration: " + user.toString());
    	return "RegisterSuccess";
    }
}
