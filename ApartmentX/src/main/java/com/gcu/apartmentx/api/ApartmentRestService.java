package com.gcu.apartmentx.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.apartmentx.business.ApartmentBusinessService;
import com.gcu.apartmentx.models.ApartmentModel;

/**
 * REST API service for managing apartments
 * Provides endpoints to fetch apartment data
 */
@RestController
@RequestMapping("/api")
public class ApartmentRestService {
	
	@Autowired
	ApartmentBusinessService service;

	/**
     * Retrieves a list of all apartments
     * @return a ResponseEntity containing the list of apartments, or a 404 if no apartments are found
     */
	@GetMapping(value = "/getallapartments", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getApartments() {
	    try {
	        List<ApartmentModel> apartments = service.getAllApartments();
	        if (apartments.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.ok(apartments);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	/**
     * Retrieves an apartment by its ID
     * @param id the ID of the apartment to retrieve
     * @return a ResponseEntity containing the apartment, or a 404 if not found
     */
	@GetMapping(value = "/getapartment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getApartmentById(@PathVariable int id) {
        try {
            ApartmentModel apartment = service.findApartmentById(id);
            if (apartment == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(apartment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
