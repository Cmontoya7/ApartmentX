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

    @GetMapping("/users")
    public String deleteUser(Model m) {
        List<UserEntity> users = service.findAll();
        m.addAttribute("users", users);
        return "Users";
    }

    @PostMapping("/users/update")
    public String updateUser(Model m, @RequestParam int id) {
        user = service.findById(id);
        m.addAttribute("user", user);
        return "UpdateUser";
    }
    
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
    
    @PostMapping("/users/delete")
    public String confirmDeleteUser(Model m, @RequestParam int id) {
        user = service.findById(id);
        m.addAttribute("user", user);
        return "ConfirmDeleteUser";
    }

    @PostMapping("/users/delete/do-delete")
    public String doDeleteUser(Model m, @RequestParam boolean confirm, RedirectAttributes redirectAttributes) {
        if (confirm) {
            service.delete(user.getId());
            String msg = "Username: " + user.getUsername() + " was Deleted";
            m.addAttribute("msg", msg);
        }
        List<UserEntity> users = service.findAll();
        m.addAttribute("users", users);
        return "redirect:/users";
    }
}
