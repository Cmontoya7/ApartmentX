package com.gcu.apartmentx.controllers;

import com.gcu.apartmentx.business.ApartmentBean;
import com.gcu.apartmentx.models.ApartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductCreationController {

    @Autowired
    ApartmentBean product = new ApartmentBean();

    @GetMapping("/create")
    public String create() {
        return "Create";
    }

    @PostMapping("/create/submit")
    public String submitProduct(@ModelAttribute ApartmentModel apartmentModel, Model model) {
        String success = product.addApartment(apartmentModel.getName(), apartmentModel.getNumBeds(), apartmentModel.getNumBaths(), apartmentModel.getFloorSpace(), apartmentModel.getPrice(), apartmentModel.getQuantity());
        model.addAttribute("message", success);
        return "Create";
    }
}
