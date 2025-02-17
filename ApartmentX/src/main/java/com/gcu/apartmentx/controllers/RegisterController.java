package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.business.RegistrationBean;
import com.gcu.apartmentx.business.RegistrationInterface;
import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.models.ApartmentXUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

	@Value("${admin.password}")
	private String encryptedAdminPassword;
	
    @Autowired
    private RegistrationInterface register = new RegistrationBean();
    
    @GetMapping("/register")
    public String register() {
        return "Register";
    }

    @PostMapping("/register/submitRegistration")
    public String submitRegistrationForm(@ModelAttribute ApartmentXUser user, @RequestParam(value = "action", required = false) String type, HttpSession session) {
        // if the user selects "Admin" when creating an account, the AdminRegister page will be displayed
    	if (type.equals("Admin")) {
        	session.setAttribute("user", user); //create a session attribute to be accessed from another method
        	return "AdminRegister";
        }
        
    	// if the User selects anything other than "Admin", the profile will be created from the provided credentials
		if (!type.equals("Admin")) {
			if (register.addUser(type, user.getUsername(), user.getEmail(), new BCryptPasswordEncoder().encode(user.getPassword()), user.getNameFirst(), user.getNameLast())) {
				return "RegisterSuccess";
			}
		}
       
    	// Show the registration failure page if it is not successful
        return "RegisterFailure";
    }
    
    
    // receives a POST request from the AdminRegister view to verify the provided admin password.
    @PostMapping("/register/submitAdminRegistration")
    public String submitAdminPasssword(@RequestParam(value = "adminPassword", required = true) String adminPassword, @RequestParam(value = "action", required = false) String type, HttpSession session, @ModelAttribute ApartmentXUser user) {
    	//ApartmentXUser object is retrieved from the session attributes 
    	ApartmentXUser registeredUser = (ApartmentXUser) session.getAttribute("user");
    	
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	
    	//checks if the provided password matches the encrypted one stored in the application.properties file
    	if (encoder.matches(adminPassword, encryptedAdminPassword)) {
    		// if valid, the user is created and added to the database
    		if (register.addUser(type, registeredUser.getUsername(), registeredUser.getEmail(), new BCryptPasswordEncoder().encode(registeredUser.getPassword()), registeredUser.getNameFirst(), registeredUser.getNameLast())) {
                return "RegisterSuccess";
            }
    	}
    	
    	//if the user is unable to be created, the AdminRegisterFailure view is returned
    	return "AdminRegisterFailure";
    }
}
