package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.ApartmentDataService;
import com.gcu.apartmentx.data.UserDataService;
import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.data.entities.UserEntity;
import com.gcu.apartmentx.models.ApartmentModel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ApartmentBean implements ApartmentInterface {

    private List<ApartmentModel> apartmentList = new ArrayList<>();
    
    @Autowired
    private ApartmentDataService apartmentDataService;
    
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
    
    @Override
    public void addApartment(String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
        ApartmentEntity apartmentEntity = new ApartmentEntity(name, numBeds, numBaths, floorSpace, price, quantity);
        apartmentDataService.create(apartmentEntity);
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
