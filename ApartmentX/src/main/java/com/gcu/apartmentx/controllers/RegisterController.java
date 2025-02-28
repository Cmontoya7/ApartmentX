package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.business.RegistrationInterface;
import com.gcu.apartmentx.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Controller class responsible for handling user registration functionality
 * Provides methods for displaying registration form, submitting user registration, and handling admin registration
 */
@Controller
public class RegisterController {

	@Value("${admin.password}")
	private String encryptedAdminPassword;
	
    @Autowired
    private RegistrationInterface register;
    
    /**
     * Displays the registration form view when accessing the /register URL
     * @return the registration view name
     */
    @GetMapping("/register")
    public String register() {
        return "Register";
    }

    /**
     * Handles the submission of the registration form and either creates a normal user or redirects to the Admin registration page
     * @param user the user model containing the registration information
     * @param type the type of the user (e.g., Admin or regular user)
     * @param session the current HTTP session to store user data
     * @return the view name based on registration success or failure
     */
    @PostMapping("/register/submitRegistration")
    public String submitRegistrationForm(@ModelAttribute UserModel user, @RequestParam(value = "action", required = false) String type, HttpSession session) {
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
    
    /**
     * Handles the admin registration process by verifying the provided admin password and creating the admin user if valid
     * @param adminPassword the password entered by the admin to validate
     * @param type the type of the user (Admin or regular user)
     * @param session the current HTTP session containing user data
     * @param user the user model containing the registration information
     * @return the view name based on admin registration success or failure
     */
    @PostMapping("/register/submitAdminRegistration")
    public String submitAdminPasssword(@RequestParam(value = "adminPassword", required = true) String adminPassword, @RequestParam(value = "action", required = false) String type, HttpSession session, @ModelAttribute UserModel user) {
    	//ApartmentXUser object is retrieved from the session attributes 
    	UserModel registeredUser = (UserModel) session.getAttribute("user");
    	
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
