package com.gcu.apartmentx.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
	
	@GetMapping("/")
    public String display()
    {
        return "Homepage";
    }
}
