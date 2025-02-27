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

@Controller
public class UserContoller {
    private UserEntity user;

    @Autowired
    private UserDataService service;
	
    //finds all users and displays them to the Users view
    @GetMapping("/users")
    public String deleteUser(Model m) {
        List<UserEntity> users = service.findAll();
        m.addAttribute("users", users);
        return "Users";
    }
    // obtains the User associated with the selected id, and passes it to the UpdateUser view
    @PostMapping("/users/update")
    public String updateUser(Model m, @RequestParam int id) {
        user = service.findById(id);
        m.addAttribute("user", user);
        return "UpdateUser";
    }
    
    // retrieves new inputs representing the Model's properties and sets that Model's existing properties to the new ones 
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
    
    // Post request (receiving from Listing.html) that handles when a user selects
 	// "Delete" on an apartment
    @PostMapping("/users/delete")
    public String confirmDeleteUser(Model m, @RequestParam int id) {
        user = service.findById(id);
        m.addAttribute("user", user);
        return "ConfirmDeleteUser";
    }

	// Post request that handles the function of confirming the deletion of a
	// selected apartment
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
