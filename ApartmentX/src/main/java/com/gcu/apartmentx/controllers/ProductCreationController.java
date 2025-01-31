package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.business.ApartmentBean;
import com.gcu.apartmentx.business.ApartmentInterface;
import com.gcu.apartmentx.models.ApartmentModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductCreationController {

    @Autowired
    private ApartmentInterface product;

    @GetMapping("/create")
    public String create() {
        return "Create";
    }

    @PostMapping("/create/submit")
    public String submitProduct(@RequestParam String name, @RequestParam int numBeds, @RequestParam int numBaths, @RequestParam int floorSpace, @RequestParam double price, @RequestParam int quantity) {
        product.addApartment(name, numBeds, numBaths, floorSpace, price, quantity);
        return "Create";
    }
    
}