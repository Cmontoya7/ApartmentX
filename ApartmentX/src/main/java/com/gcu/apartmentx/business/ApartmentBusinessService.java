package com.gcu.apartmentx.business;

import com.gcu.apartmentx.data.ApartmentDataService;
import com.gcu.apartmentx.data.entities.ApartmentEntity;
import com.gcu.apartmentx.models.ApartmentModel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service class for managing apartment business logic
 * Handles CRUD operations for apartments
 */
public class ApartmentBusinessService implements ApartmentInterface {
    
	// Spring bean which interacts with the repository. Handles database interaction
    @Autowired
    private ApartmentDataService apartmentDataService;
    
    public ApartmentBusinessService() {}
    
    
    
   
    // --------------------- READ --------------------- //
    
    /**
     * Retrieves all apartments as ApartmentModel objects
     * @return a list of ApartmentModel objects representing all apartments in the database
     */
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
    
    /**
     * Retrieves a specific apartment by its ID
     * @param id the ID of the apartment to retrieve
     * @return an ApartmentModel representing the apartment with the specified ID
     */
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
    
    /**
     * Adds a new apartment
     * @param apartment an ApartmentModel object representing the apartment to be added
     * @return a message indicating the result of the add operation
     */
    @Override
    public String addApartment(ApartmentModel apartment) {
        ApartmentEntity apartmentEntity = new ApartmentEntity(apartment.getName(), apartment.getNumBeds(), apartment.getNumBaths(), apartment.getFloorSpace(), apartment.getPrice(), apartment.getQuantity());
        apartmentDataService.create(apartmentEntity);
        return "Apartment " + apartmentEntity.getName() + " added";
    }
    
    // --------------------- UPDATE --------------------- //
    
    /**
     * Updates an existing apartment
     * @param apartmentModel an ApartmentModel object representing the apartment to be updated
     */
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
    
    /**
     * Deletes an apartment by its ID
     * @param id the ID of the apartment to delete
     */
    @Override
    public void deleteApartment(int id) {
    	ApartmentEntity apartmentEntity = apartmentDataService.findById(id); //retrieves the Entity associated with the passed id 
    	apartmentDataService.delete(apartmentEntity);// passes the entity to the Data service layer to be deleted within the database
    }
    
    // --------------------- LIFECYCLE METHODS --------------------- //
    /**
     * Initializes the apartment bean
     */
    @Override
    public void init() {
        System.out.println("ApartmentBean init method call");
    }
    
    /**
     * Destroys the apartment bean
     */
    @Override
    public void destroy() {
        System.out.println("ApartmentBean destroy method call");
    }
}
