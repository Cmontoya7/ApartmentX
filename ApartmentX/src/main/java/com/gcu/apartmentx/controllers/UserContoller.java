package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller class responsible for handling user-related functionality
 * Provides methods for displaying users, updating user information, and deleting users
 */
@Controller
public class UserContoller {
    private UserEntity user;

    @Autowired
    private UserDataService service;
	
    /**
     * Retrieves all users from the database and displays them in the "Users" view
     * @param m the Model object used to pass data to the view
     * @return the "Users" view name
     */
    @GetMapping("/users")
    public String deleteUser(Model m) {
        List<UserEntity> users = service.findAll();
        m.addAttribute("users", users);
        return "Users";
    }

    /**
     * Retrieves a user by their ID and passes the user to the "UpdateUser" view for updating
     * @param m the Model object used to pass the user to the view
     * @param id the ID of the user to be updated
     * @return the "UpdateUser" view name
     */
    @PostMapping("/users/update")
    public String updateUser(Model m, @RequestParam int id) {
        user = service.findById(id);
        m.addAttribute("user", user);
        return "UpdateUser";
    }
    
    /**
     * Handles updating the user's information with the new input values
     * Only updates non-null and non-blank fields
     * @param id the ID of the user to be updated
     * @param username the new username (optional)
     * @param email the new email (optional)
     * @param password the new password (optional)
     * @param firstName the new first name (optional)
     * @param lastName the new last name (optional)
     * @param redirectAttributes used for redirection after the update
     * @return redirects to the "/users" page after the update
     */
    @PostMapping("/users/update/do-update")
    public String doUpdate(
    		// Get parameters from the HTML form
    		@RequestParam int id,
	        @RequestParam(required = false) String username,
	        @RequestParam(required = false) String email,
	        @RequestParam(required = false) String password,
	        @RequestParam(required = false) String firstName,
	        @RequestParam(required = false) String lastName,
	        RedirectAttributes redirectAttributes
	        )
    {
    	// Get the current user information
    	UserEntity user = service.findById(id);
    	
    	// Only updates if the entry is not null or blank space
    	if (username != null && !username.isBlank()) user.setUsername(username);
    	if (email != null && !email.isBlank()) user.setEmail(email);
    	if (password != null && !password.isBlank()) user.setPassword(password);
    	if (firstName != null && !firstName.isBlank()) user.setFirstName(firstName);
    	if (lastName != null && !lastName.isBlank()) user.setLastName(lastName);

    	// Update the user in the database
    	service.update(user);
    	
    	// Send the user back to the users page
    	return "redirect:/users";
    }
    
    /**
     * Retrieves a user by their ID and displays the confirmation page for deleting the user
     * @param m the Model object used to pass the user to the view
     * @param id the ID of the user to be deleted
     * @return the "ConfirmDeleteUser" view name
     */
    @PostMapping("/users/delete")
    public String confirmDeleteUser(Model m, @RequestParam int id) {
        user = service.findById(id);
        m.addAttribute("user", user);
        return "ConfirmDeleteUser";
    }

    /**
     * Handles the deletion of the user if the confirmation is true
     * After deletion, redirects to the "/users" page with the updated list of users
     * @param m the Model object used to pass messages to the view
     * @param confirm whether the deletion is confirmed or not
     * @return redirects to the "/users" page after deletion
     */
    @PostMapping("/users/delete/do-delete")
    public String doDeleteUser(Model m, @RequestParam boolean confirm) {
        if (confirm) {
            service.delete(user);
            String msg = "Username: " + user.getUsername() + " was Deleted";
            m.addAttribute("msg", msg);
        }
        List<UserEntity> users = service.findAll();
        m.addAttribute("users", users);
        return "redirect:/users";
    }
}
