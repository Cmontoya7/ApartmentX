package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.business.ApartmentBean;
import com.gcu.apartmentx.business.ApartmentInterface;
import com.gcu.apartmentx.business.RegistrationBean;
import com.gcu.apartmentx.business.RegistrationInterface;
import com.gcu.apartmentx.models.ApartmentModel;
import com.gcu.apartmentx.models.ApartmentXUser;

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
    private ApartmentInterface apartmentInterface = new ApartmentBean();

    @GetMapping("/create")
    public String create() {
        return "Create";
    }

    @PostMapping("/create/submit")
    public String submitProduct(@ModelAttribute ApartmentModel apartment, Model model) {
        String msg = apartmentInterface.addApartment(apartment.getName(), apartment.getNumBeds(), apartment.getNumBaths(), apartment.getFloorSpace(), apartment.getPrice(), apartment.getQuantity());
        model.addAttribute("message", msg);
        return "Create";
    }
    
}