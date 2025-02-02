package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.ApartmentDataService;
import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.models.ApartmentModel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class ApartmentBean implements ApartmentInterface {

    private List<ApartmentModel> apartmentList = new ArrayList<>();
    
    @Autowired
    private ApartmentDataService apartmentDataService;
    
    public ApartmentBean() {}

    @Override
    public List<ApartmentModel> getListings() {
    	return apartmentList;
    }
    
    @Override
    public String addApartment(String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
        ApartmentEntity apartmentEntity = new ApartmentEntity(name, numBeds, numBaths, floorSpace, price, quantity);
        apartmentDataService.create(apartmentEntity);
        return "Apartment " + apartmentEntity.getName() + " added";
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
