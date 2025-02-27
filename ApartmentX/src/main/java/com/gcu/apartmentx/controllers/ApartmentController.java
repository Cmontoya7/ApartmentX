package com.gcu.apartmentx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gcu.apartmentx.business.ApartmentInterface;
import com.gcu.apartmentx.models.ApartmentModel;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/listings")
public class ApartmentController {

	@Autowired
	private ApartmentInterface apartmentInterface;

	//finds all apartments and displays them to the Listings view
	@GetMapping("/getlistings")
	public String listings(Model model) {
		List<ApartmentModel> apartments = apartmentInterface.getAllApartments();

		model.addAttribute("title", "Apartment Listings");
		model.addAttribute("apartments", apartments);
		return "Listings";
	}

	// obtains the Apartment associated with the selected id, and passes it to the UpdateApartment view
	@PostMapping("/update")
	public String updateApartment(Model m, @RequestParam int id) {
		ApartmentModel apartment = apartmentInterface.findApartmentById(id);
		m.addAttribute("apartment", apartment);
		return "UpdateApartment";
	}

	// retrieves new inputs representing the Model's properties and sets that Model's existing properties to the new ones 
	@PostMapping("/update/do-update")
	public String doUpdate(@RequestParam int id, @RequestParam(required = false) String name,
			@RequestParam(required = false) Integer numBeds, @RequestParam(required = false) Integer numBaths,
			@RequestParam(required = false) Integer floorSpace, @RequestParam(required = false) Float price,
			@RequestParam(required = false) Integer quantity, RedirectAttributes redirectAttributes,
			HttpSession session, Model m) {
		// Get the current apartment information
		ApartmentModel apartment = apartmentInterface.findApartmentById(id);

		// Only update fields if they are not null or blank spaces
		if (name != null && !name.isBlank())
			apartment.setName(name);
		if (numBeds != null)
			apartment.setNumBeds(numBeds);
		if (numBaths != null)
			apartment.setNumBaths(numBaths);
		if (floorSpace != null)
			apartment.setFloorSpace(floorSpace);
		if (price != null)
			apartment.setPrice(price);
		if (quantity != null)
			apartment.setQuantity(quantity);

		// Update the apartment in the database
		apartmentInterface.updateApartment(apartment);

		// Redirect back to the apartments page
		m.addAttribute("session", session);
		return "redirect:/listings/getlistings";
	}

	// Post request (receiving from Listing.html) that handles when a user selects
	// "Delete" on an apartment
	@PostMapping("/delete")
	public String confirmDeleteApartment(Model m, @RequestParam int id) {
		ApartmentModel apartment = apartmentInterface.findApartmentById(id); // passes the ApartmentModels's "id"
																				// attribute to the findById method to
																				// find the selected item in the
																				// database
		m.addAttribute("apartment", apartment); // passes the item (found by its id) to the ConfirmDeleteApartment HTML
		return "ConfirmDeleteApartment";
	}

	// Post request that handles the function of confirming the deletion of a
	// selected apartment
	@PostMapping("/delete/do-delete")
	public String doDeleteApartment(Model m, @RequestParam boolean confirm, @RequestParam("apartmentId") int id,
			RedirectAttributes redirectAttributes) {
		if (confirm) {
			ApartmentModel apartment = apartmentInterface.findApartmentById(id);
			apartmentInterface.deleteApartment(apartment.getId());
			String msg = "Apartment: " + apartment.getName() + " was Deleted";
			m.addAttribute("msg", msg);
		}
		List<ApartmentModel> apartments = apartmentInterface.getAllApartments();
		m.addAttribute("apartments", apartments);
		return "redirect:/listings/getlistings";
	}

	@GetMapping("/create")
	public String create() {
		return "Create";
	}

	// creates a Model based on the input passed from the view gathered from the user, and calls the interface to create an instance based on the input
	@PostMapping("/create/submit")
	public String submitProduct(@ModelAttribute ApartmentModel apartment, Model model) {
		String msg = apartmentInterface.addApartment(apartment);
		model.addAttribute("message", msg);
		return "redirect:/listings/getlistings";
	}

}