package com.gcu.apartmentx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class responsible for handling the home page request
 * Provides method for displaying the home page
 */
@Controller
public class HomeController 
{
	/**
	 * Displays the homepage view when accessing the root URL
	 * @return the Homepage view name
	 */
	@GetMapping("/")
    public String display()
    {
        return "Homepage";
    }
}
