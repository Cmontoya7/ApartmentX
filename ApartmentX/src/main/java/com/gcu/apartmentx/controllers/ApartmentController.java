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

/**
 * Controller class responsible for handling apartment-related requests
 * Provides methods for displaying, updating, deleting, and creating apartments
 */
@Controller
@RequestMapping("/listings")
public class ApartmentController {

	@Autowired
	private ApartmentInterface apartmentInterface;

	/**
	 * Retrieves all apartments and displays them in the Listings view
	 * @param model the model to pass attributes to the view
	 * @return the Listings view name
	 */
	@GetMapping("/getlistings")
	public String listings(Model model) {
		List<ApartmentModel> apartments = apartmentInterface.getAllApartments();

		model.addAttribute("title", "Apartment Listings");
		model.addAttribute("apartments", apartments);
		return "Listings";
	}

	/**
	 * Retrieves the apartment details based on the provided id and displays the UpdateApartment view
	 * @param m the model to pass attributes to the view
	 * @param id the id of the apartment to update
	 * @return the UpdateApartment view name
	 */
	@PostMapping("/update")
	public String updateApartment(Model m, @RequestParam int id) {
		ApartmentModel apartment = apartmentInterface.findApartmentById(id);
		m.addAttribute("apartment", apartment);
		return "UpdateApartment";
	}

	/**
	 * Processes the updates for an apartment based on the provided form data
	 * @param id the id of the apartment to update
	 * @param name the updated name of the apartment
	 * @param numBeds the updated number of beds
	 * @param numBaths the updated number of baths
	 * @param floorSpace the updated floor space
	 * @param price the updated price
	 * @param quantity the updated quantity
	 * @param redirectAttributes used for adding redirect attributes
	 * @param session the current user session
	 * @param m the model to pass attributes to the view
	 * @return redirect to the listings page
	 */
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

	/**
	 * Displays the ConfirmDeleteApartment view when an apartment is selected for deletion
	 * @param m the model to pass attributes to the view
	 * @param id the id of the apartment to delete
	 * @return the ConfirmDeleteApartment view name
	 */
	@PostMapping("/delete")
	public String confirmDeleteApartment(Model m, @RequestParam int id) {
		ApartmentModel apartment = apartmentInterface.findApartmentById(id); // passes the ApartmentModels's "id"
																				// attribute to the findById method to
																				// find the selected item in the
																				// database
		m.addAttribute("apartment", apartment); // passes the item (found by its id) to the ConfirmDeleteApartment HTML
		return "ConfirmDeleteApartment";
	}

	/**
	 * Confirms the deletion of the selected apartment and deletes it if confirmed
	 * @param m the model to pass attributes to the view
	 * @param confirm whether the user confirmed the deletion
	 * @param id the id of the apartment to delete
	 * @param redirectAttributes used for adding redirect attributes
	 * @return redirect to the listings page
	 */
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

	/**
	 * Displays the Create view for adding a new apartment
	 * @return the Create view name
	 */
	@GetMapping("/create")
	public String create() {
		return "Create";
	}

	/**
	 * Submits the new apartment details from the form and creates the apartment
	 * @param apartment the apartment model containing user input
	 * @param model the model to pass attributes to the view
	 * @return redirect to the listings page
	 */
	@PostMapping("/create/submit")
	public String submitProduct(@ModelAttribute ApartmentModel apartment, Model model) {
		String msg = apartmentInterface.addApartment(apartment);
		model.addAttribute("message", msg);
		return "redirect:/listings/getlistings";
	}

}