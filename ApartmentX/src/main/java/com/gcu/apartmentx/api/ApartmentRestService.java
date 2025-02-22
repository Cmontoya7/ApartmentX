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

@RestController
@RequestMapping("/api")
public class ApartmentRestService {
	
	@Autowired
	ApartmentBusinessService service;

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
