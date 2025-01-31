package com.gcu.apartmentx.business;

import com.gcu.apartmentx.models.ApartmentModel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


public class ApartmentBean implements ApartmentInterface {

    // Remove static so each instance of ApartmentBean has its own list
    private List<ApartmentModel> apartmentList = new ArrayList<>();
    
    public ApartmentBean() {
        populateApartmentList();
    }

    public void populateApartmentList() {
        apartmentList.add(new ApartmentModel("Small", 3, 2, 1200, 1200, 10));
        apartmentList.add(new ApartmentModel("Small", 4, 2, 1500, 1800, 8));
        apartmentList.add(new ApartmentModel("Small", 2, 1, 800, 750, 10));
        apartmentList.add(new ApartmentModel("Large", 3, 2, 1800, 2000, 3));
        apartmentList.add(new ApartmentModel("Large", 4, 2, 2350, 2500, 3));
    }
    
    @Override
    public List<ApartmentModel> getListings() {
    	return apartmentList;
    }

    public String addApartment(String name, int numBeds, int numBaths, int floorSpace, double price, int quantity) {
        apartmentList.add(new ApartmentModel(name, numBeds, numBaths, floorSpace, price, quantity));

        // Debug: Print the list
        System.out.println("Apartment Database");
        for (ApartmentModel apartment : apartmentList) {
            System.out.println(apartment.toString());
        }
        System.out.println("Apartment Database End");

        return "You have successfully added " + name + " to the listings";
    }

    @Override
    public void init() {
        System.out.println("ApartmentBean init method call");
    }

    @Override
    public void destroy() {
        System.out.println("ApartmentBean destroy method call");
    }
}
