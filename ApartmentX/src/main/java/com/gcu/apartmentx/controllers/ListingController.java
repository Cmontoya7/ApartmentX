package com.gcu.apartmentx.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.apartmentx.business.ApartmentBean;
import com.gcu.apartmentx.data.ApartmentDataService;
import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.models.ApartmentModel;

@Controller
public class ListingController {

	@Autowired
	private ApartmentDataService apartmentService;
	
    @GetMapping("/listings")
    public String listings(Model model) {
    	List<ApartmentEntity> apartmentEntities = apartmentService.findAll();
    	
    	List<ApartmentModel> listings = apartmentEntities.stream().map(entity -> new ApartmentModel(entity.getName(), entity.getNumBeds(), entity.getNumBaths(), entity.getFloorSpace(), entity.getPrice(), entity.getQuantity())).collect(Collectors.toList());
    	model.addAttribute("title", "Listings");
    	model.addAttribute("listings", listings);
    	return "Listings";
    }

    @GetMapping("/deletelisting")
    public String deleteListing() {
        return "DeleteListing";
    }

}