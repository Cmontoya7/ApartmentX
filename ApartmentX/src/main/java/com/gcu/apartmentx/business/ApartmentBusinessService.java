package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.ApartmentDataService;
import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.models.ApartmentModel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class ApartmentBusinessService implements ApartmentInterface {
    
    @Autowired
    private ApartmentDataService apartmentDataService;
    
    public ApartmentBusinessService() {}

    @Override
    public List<ApartmentModel> getAllApartments() {
    	
    	List<ApartmentEntity> apartmentEntities = apartmentDataService.findAll();
    	List<ApartmentModel> apartments = new ArrayList<>();
    	
    	for (ApartmentEntity entity : apartmentEntities) {
    		apartments.add(new ApartmentModel(entity.getId(), entity.getName(), entity.getNumBeds(), entity.getNumBaths(), entity.getFloorSpace(), entity.getPrice(), entity.getQuantity()));
    	}
    	
    	return apartments;
    }
    
    @Override
    public ApartmentModel findApartmentById(int id) {
    	ApartmentEntity apartmentEntity = apartmentDataService.findById(id);
    	return new ApartmentModel(apartmentEntity.getId(), apartmentEntity.getName(), apartmentEntity.getNumBeds(), apartmentEntity.getNumBaths(), apartmentEntity.getFloorSpace(), apartmentEntity.getPrice(), apartmentEntity.getQuantity());
    }
    
    @Override
    public String addApartment(ApartmentModel apartment) {
        ApartmentEntity apartmentEntity = new ApartmentEntity(apartment.getName(), apartment.getNumBeds(), apartment.getNumBaths(), apartment.getFloorSpace(), apartment.getPrice(), apartment.getQuantity());
        apartmentDataService.create(apartmentEntity);
        return "Apartment " + apartmentEntity.getName() + " added";
    }
    
    @Override
	public void updateApartment(ApartmentModel apartmentModel) {
    	ApartmentEntity apartmentEntity = apartmentDataService.findById(apartmentModel.getId());
    	apartmentEntity.setName(apartmentModel.getName());
    	apartmentEntity.setNumBeds(apartmentModel.getNumBeds());
    	apartmentEntity.setNumBaths(apartmentModel.getNumBaths());
    	apartmentEntity.setPrice(apartmentModel.getPrice());
    	apartmentEntity.setQuantity(apartmentModel.getQuantity());
    	
		apartmentDataService.update(apartmentEntity);
	}
    
    @Override
    public void deleteApartment(int id) {
    	ApartmentEntity apartmentEntity = apartmentDataService.findById(id);
    	apartmentDataService.delete(apartmentEntity);
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
