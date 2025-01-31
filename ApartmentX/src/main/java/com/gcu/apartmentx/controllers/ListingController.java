package com.gcu.apartmentx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.apartmentx.business.ApartmentBean;
import com.gcu.apartmentx.models.ApartmentModel;

@Controller
public class ListingController {

	@Autowired
	private ApartmentBean apartmentBean;
	
    @GetMapping("/listings")
    public String listings(Model model) {
    	List<ApartmentModel> listings = apartmentBean.getListings();
    	
    	model.addAttribute("title", "Listings");
    	model.addAttribute("listings", listings);
        return "/Listings";
    }

    @GetMapping("/deletelisting")
    public String deleteListing() {
        return "DeleteListing";
    }

}