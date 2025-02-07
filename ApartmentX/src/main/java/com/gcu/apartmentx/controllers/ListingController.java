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

    @PostMapping("/listings/update")
    public String updateApartment(Model m, @RequestParam int id) {
        ApartmentEntity apartment = apartmentService.findById(id);
        m.addAttribute("apartment", apartment);
        return "UpdateApartment";
    }

    @PostMapping("/listings/update/do-update")
    public String doUpdate(
            @RequestParam int id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer numBeds,
            @RequestParam(required = false) Integer numBaths,
            @RequestParam(required = false) Integer floorSpace,
            @RequestParam(required = false) Float price,
            @RequestParam(required = false) Integer quantity,
            RedirectAttributes redirectAttributes
    ) {
        // Get the current apartment information
        ApartmentEntity apartment = apartmentService.findById(id);

        // Only update fields if they are not null or blank spaces
        if (name != null && !name.isBlank()) apartment.setName(name);
        if (numBeds != null) apartment.setNumBeds(numBeds);
        if (numBaths != null) apartment.setNumBaths(numBaths);
        if (floorSpace != null) apartment.setFloorSpace(floorSpace);
        if (price != null) apartment.setPrice(price);
        if (quantity != null) apartment.setQuantity(quantity);

        // Update the apartment in the database
        apartmentService.update(apartment);

        // Redirect back to the apartments page
        return "redirect:/listings";
    }

  //Post request (receiving from Listing.html) that handles when a user selects "Delete" on an apartment
    @PostMapping("/listings/delete")
    public String confirmDeleteApartment(Model m, @RequestParam int id) {
        apartment = apartmentService.findById(id); //passes the ApartmentEntity's "id" attribute to the findById method to find the selected item in the database
        m.addAttribute("apartment", apartment); //passes the item (found by its id) to the ConfirmDeleteApartment HTML 
        return "ConfirmDeleteApartment";
    }

    //Post request that handles the function of confirming the deletion of a selected apartment 
    @PostMapping("/listings/delete/do-delete")
    public String doDeleteApartment(Model m, @RequestParam boolean confirm, RedirectAttributes redirectAttributes) {
        if (confirm) { 
        	apartmentService.delete(apartment.getId());
            String msg = "Apartment: " + apartment.getName() + " was Deleted";
            m.addAttribute("msg", msg);
        }
        List<ApartmentEntity> apartments = apartmentService.findAll();
        m.addAttribute("apartments", apartments);
        return "redirect:/listings";
    }

}