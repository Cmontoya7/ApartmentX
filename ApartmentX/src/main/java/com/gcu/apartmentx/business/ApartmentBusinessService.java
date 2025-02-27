package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.ApartmentDataService;
import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.models.ApartmentModel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class ApartmentBusinessService implements ApartmentInterface {
    
	//Spring bean which interacts with the repository. Handles database interaction
    @Autowired
    private ApartmentDataService apartmentDataService;
    
    public ApartmentBusinessService() {}
    
    
    
   
    // --------------------- READ --------------------- //
    
    //returns all apartment objects in the form of ApartmentModel's
    @Override
    public List<ApartmentModel> getAllApartments() {
    	
    	List<ApartmentEntity> apartmentEntities = apartmentDataService.findAll(); //Grab all ApartmentEntities from the repository
    	List<ApartmentModel> apartments = new ArrayList<>(); // list which will be returned to the method call
    	
    	// for each Entity living in the list of entities, create a new model that will represent the entity
    	for (ApartmentEntity entity : apartmentEntities) {
    		apartments.add(new ApartmentModel(entity.getId(), entity.getName(), entity.getNumBeds(), entity.getNumBaths(), entity.getFloorSpace(), entity.getPrice(), entity.getQuantity()));
    	}
    	
    	//return the newly created list of ApartmentModels that represent the data within the database
    	return apartments;
    }
    
    // returns a specific ApartmentModel associated with the id passed to the method
    @Override
    public ApartmentModel findApartmentById(int id) {
    	ApartmentEntity apartmentEntity = apartmentDataService.findById(id); // find the ApartmentEntity in the database associated with the id using the dataService layer,
    	return new ApartmentModel(apartmentEntity.getId(), // return a new ApartmentModel representing the ApartmentEntity stored in the database by using the get methods of the Entity's properties to store the same values in the returned model 
    							  apartmentEntity.getName(),
    							  apartmentEntity.getNumBeds(),
    							  apartmentEntity.getNumBaths(),
    							  apartmentEntity.getFloorSpace(),
    							  apartmentEntity.getPrice(),
    							  apartmentEntity.getQuantity());
    }
    
    // --------------------- CREATE --------------------- //
    
    // receives an ApartmentModel object, and creates an ApartmentEntity object using the Model's properties. The Entity is then stored in the database using the DataService's create() method
    @Override
    public String addApartment(ApartmentModel apartment) {
        ApartmentEntity apartmentEntity = new ApartmentEntity(apartment.getName(), apartment.getNumBeds(), apartment.getNumBaths(), apartment.getFloorSpace(), apartment.getPrice(), apartment.getQuantity());
        apartmentDataService.create(apartmentEntity);
        return "Apartment " + apartmentEntity.getName() + " added";
    }
    
    // --------------------- UPDATE --------------------- //
    
    // receives an ApartmentModel
    @Override
	public void updateApartment(ApartmentModel apartmentModel) {
    	ApartmentEntity apartmentEntity = apartmentDataService.findById(apartmentModel.getId()); //grabs the ApartmentEntity that is associated with the Model's ID
    	
    	//update the Entity's properties based on the properties of the Model passed to the method 
    	apartmentEntity.setName(apartmentModel.getName());
    	apartmentEntity.setNumBeds(apartmentModel.getNumBeds());
    	apartmentEntity.setNumBaths(apartmentModel.getNumBaths());
    	apartmentEntity.setPrice(apartmentModel.getPrice());
    	apartmentEntity.setQuantity(apartmentModel.getQuantity());
    	
    	//pass the newly updated entity to the data service to be updated within the database
		apartmentDataService.update(apartmentEntity);
	}
    
    // --------------------- DELETE --------------------- //
    
    // receives an id, which is used to delete the ApartmentEntity that is associated with the given id
    @Override
    public void deleteApartment(int id) {
    	ApartmentEntity apartmentEntity = apartmentDataService.findById(id); //retrieves the Entity associated with the passed id 
    	apartmentDataService.delete(apartmentEntity);// passes the entity to the Data service layer to be deleted within the database
    }
    
    // --------------------- LIFECYCLE METHODS --------------------- //

    @Override
    public void init() {
        System.out.println("ApartmentBean init method call");
    }

    @Override
    public void destroy() {
        System.out.println("ApartmentBean destroy method call");
    }
}
