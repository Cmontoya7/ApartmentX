package com.gcu.apartmentx.data;

import java.util.List;

/**
 * Interface for data access operations
 * Defines methods for CRUD operations: create, read, update, and delete
 * @param <T> the type of entity that the implementing class will handle
 */
public interface DataAccessInterface<T>{
	/**
	 * Retrieves all entities of type T from the database
	 * @return a list of all entities of type T
	 */
    public List<T> findAll();
    /**
     * Finds and returns an entity by its ID
     * @param id the ID of the entity to be retrieved
     * @return the entity associated with the ID, or null if not found
     */
    public T findById(int id);
    /**
     * Creates a new entity of type T in the database
     * @param t the entity to be created
     * @return true if the entity was successfully created, false otherwise
     */
    public boolean create(T t);
    /**
     * Updates the properties of an existing entity in the database
     * @param t the updated entity
     * @return true if the entity was successfully updated, false otherwise
     */
    public boolean update(T t);
    /**
     * Deletes the specified entity from the database
     * @param t the entity to be deleted
     * @return true if the entity was successfully deleted, false otherwise
     */
    public boolean delete(T t);
}
