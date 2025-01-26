package com.gcu.apartmentx.business;

import com.gcu.apartmentx.models.ApartmentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentBean {

    public String addApartment(String name, int numBeds, int numBaths, int floorSpace, double price, int quantity) {

        //Psuedo-Database of Apartments
        List<ApartmentModel> apartmentList = new ArrayList<>();
        apartmentList.add(new ApartmentModel("Small",3, 2, 1200, 1200, 10));
        apartmentList.add(new ApartmentModel("Small",4, 2, 1500, 1800, 8));
        apartmentList.add(new ApartmentModel("Small", 2, 1, 800, 750, 10));
        apartmentList.add(new ApartmentModel("Large",3, 2, 1800, 2000, 3));
        apartmentList.add(new ApartmentModel("Large",4, 2, 2350, 2500, 3));

        //add new apartment to the Psuedo-Database
        apartmentList.add(new ApartmentModel(name,numBeds, numBaths, floorSpace, price, quantity));

        //Print the Psuedo-Database for testing purposes
        System.out.println("Apartment Database");
        for (ApartmentModel apartment : apartmentList) {
            System.out.println(apartment.toString());
        }
        System.out.println("Apartment Database End");
        return "You have Successfully Added " + name + " to the listings";
    }
}
