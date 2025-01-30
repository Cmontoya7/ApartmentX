package com.gcu.apartmentx.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListingController {

    @GetMapping("/listings")
    public String listings() {
        return "Listings";
    }

    @GetMapping("/deletelisting")
    public String deleteListing() {
        return "DeleteListing";
    }

}
