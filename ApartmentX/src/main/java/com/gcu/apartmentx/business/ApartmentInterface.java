package com.gcu.apartmentx.business;

import java.util.List;

import com.gcu.apartmentx.models.ApartmentModel;

/**
 * Interface for apartment business services
 * Defines CRUD operations for apartments
 */
public interface ApartmentInterface
{
	/**
     * Retrieves all apartments as ApartmentModel objects
     * @return a list of ApartmentModel objects representing all apartments
     */
	public List<ApartmentModel> getAllApartments();
	/**
     * Adds a new apartment
     * @param apartment an ApartmentModel object representing the apartment to be added
     * @return a message indicating the result of the add operation
     */
	public String addApartment(ApartmentModel apartment);
	/**
     * Retrieves a specific apartment by its ID
     * @param id the ID of the apartment to retrieve
     * @return an ApartmentModel representing the apartment with the specified ID
     */
	public ApartmentModel findApartmentById(int id);
	/**
     * Updates an existing apartment
     * @param apartmentModel an ApartmentModel object representing the apartment to be updated
     */
	public void updateApartment(ApartmentModel apartmentModel);
	/**
     * Deletes an apartment by its ID
     * @param id the ID of the apartment to delete
     */
	public void deleteApartment(int id);
	/**
     * Initializes the apartment bean
     */
	public void init();
	/**
     * Destroys the apartment bean
     */
	public void destroy();
}