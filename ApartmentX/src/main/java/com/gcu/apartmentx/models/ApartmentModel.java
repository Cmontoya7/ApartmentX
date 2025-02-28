package com.gcu.apartmentx.models;

/**
 * Model class representing an apartment with details such as name, number of beds, baths, floor space, price, and quantity.
 * Used to map apartment data between the application and the database.
 */
public class ApartmentModel {
	private int id;
    private String name;
    private int numBeds;
    private int numBaths;
    private int floorSpace;
    private float price;
    private int quantity;

    /**
     * Default constructor
     */
    public ApartmentModel() {
    	this.id = 0;
        this.name = "";
        this.numBeds = 0;
        this.numBaths = 0;
        this.floorSpace = 0;
        this.price = 0;
        this.quantity = 0;
    }
    
    /**
     * Constructor to create an apartment model with the id
     * @param id the id of the apartment
     * @param name the name of the apartment
     * @param numBeds the number of bedrooms in the apartment
     * @param numBaths the number of bathrooms in the apartment
     * @param floorSpace the floor space of the apartment in square feet
     * @param price the price of the apartment
     * @param quantity the quantity of apartments available
     */
    public ApartmentModel(int id, String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
    	this.id = id;
        this.name = name;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.floorSpace = floorSpace;
        this.price = price;
        this.quantity = quantity;
    }
    
    /**
     * Constructor to create an apartment model without the id
     * @param name the name of the apartment
     * @param numBeds the number of bedrooms in the apartment
     * @param numBaths the number of bathrooms in the apartment
     * @param floorSpace the floor space of the apartment in square feet
     * @param price the price of the apartment
     * @param quantity the quantity of apartments available
     */
    public ApartmentModel(String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
        this.name = name;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.floorSpace = floorSpace;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the unique identifier for the apartment
     * @return the ID of the apartment
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the unique identifier for the apartment
     * @param id the ID to assign to the apartment
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Retrieves the name of the apartment
     * @return the name of the apartment
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the apartment, ensuring the first letter is capitalized
     * @param name the name of the apartment
     */
    public void setName(String name) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
    /**
     * Retrieves the number of bedrooms in the apartment
     * @return the number of bedrooms
     */
    public int getNumBeds() {
        return numBeds;
    }
    /**
     * Sets the number of bedrooms in the apartment
     * @param numBeds the number of bedrooms
     */
    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }
    /**
     * Retrieves the number of bathrooms in the apartment
     * @return the number of bathrooms
     */
    public int getNumBaths() {
        return numBaths;
    }
    /**
     * Sets the number of bathrooms in the apartment
     * @param numBaths the number of bathrooms
     */
    public void setNumBaths(int numBaths) {
        this.numBaths = numBaths;
    }
    /**
     * Retrieves the floor space of the apartment in square feet
     * @return the floor space
     */
    public int getFloorSpace() {
        return floorSpace;
    }
    /**
     * Sets the floor space of the apartment
     * @param floorSpace the floor space in square feet
     */
    public void setFloorSpace(int floorSpace) {
        this.floorSpace = floorSpace;
    }
    /**
     * Retrieves the price of the apartment
     * @return the price of the apartment
     */
    public float getPrice() {
        return price;
    }
    /**
     * Sets the price of the apartment
     * @param price the price of the apartment
     */
    public void setPrice(float price) {
        this.price = price;
    }
    /**
     * Retrieves the quantity of apartments available
     * @return the number of apartments available
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Sets the quantity of apartments available
     * @param quantity the number of apartments available
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the apartment with its details
     * @return a formatted string displaying apartment details
     */
    @Override
    public String toString() {
        return "ApartmentModel{" +
                "Name= " + name + '\'' +
                ", Beds= " + numBeds + '\'' +
                ", Baths= " + numBaths + '\'' +
                ", Floor Space= " + floorSpace + '\'' +
                ", Price= " + price  + '\'' +
                ", Quantity= " + quantity + '\'' +
                '}';
    }
}
