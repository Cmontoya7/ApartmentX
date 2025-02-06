package com.gcu.apartmentx.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gcu.apartmentx.business.ApartmentBean;
import com.gcu.apartmentx.data.ApartmentDataService;
import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.models.ApartmentModel;

@Controller
public class ListingController {

	private ApartmentEntity apartment;
	
	@Autowired
	private ApartmentDataService apartmentService;
	
	
    @GetMapping("/listings")
    public String listings(Model model) {
    	List<ApartmentEntity> apartments = apartmentService.findAll();
    	
    	model.addAttribute("title", "Apartment Listings");
    	model.addAttribute("apartments", apartments);
    	return "Listings";
    }

  //Post request (receiving from Listing.html) that handles when a user selects "Delete" on an apartment
    @PostMapping("/deleteApartment/confirm")
    public String confirmDeleteApartment(Model m, @RequestParam(value = "action", required = false) int id) {
        apartment = apartmentService.findById(id); //passes the ApartmentEntity's "id" attribute to the findById method to find the selected item in the database
        m.addAttribute("apartment", apartment); //passes the item (found by its id) to the ConfirmDeleteApartment HTML 
        return "ConfirmDeleteApartment";
    }

    //Post request that handles the function of confirming the deletion of a selected apartment 
    @PostMapping("/deleteApartment/isconfirmed")
    public String doDeleteApartment(Model m, @RequestParam(value = "action", required = false) boolean confirm, RedirectAttributes redirectAttributes) {
        if (confirm) { 
        	apartmentService.delete(apartment.getId());
            String msg = "Apartment: " + apartment.getName() + " was Deleted";
            m.addAttribute("msg", msg);
        }
        List<ApartmentEntity> apartments = apartmentService.findAll();
        m.addAttribute("apartments", apartments);
        return "Listings";
    }

}