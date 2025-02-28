package com.gcu.apartmentx.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Entity class representing an apartment in the database
 * Maps to the "APARTMENTS" table and provides properties for apartment details
 */
@Table("APARTMENTS")
public class ApartmentEntity {
    @Id
    private int id;
    @Column("NAME")
    private String name;
    @Column("NUMBER_BEDS")
    private int numBeds;
    @Column("NUMBER_BATHS")
    private int numBaths;
    @Column("FLOOR_SPACE")
    private int floorSpace;
    @Column("PRICE")
    private float price;
    @Column("QUANTITY")
    private int quantity;

    /**
     * Default constructor
     */
    public ApartmentEntity() {}

    /**
     * Constructor with all fields including id
     * @param id the unique identifier for the apartment
     * @param name the name of the apartment
     * @param numBeds the number of bedrooms
     * @param numBaths the number of bathrooms
     * @param floorSpace the floor space of the apartment
     * @param price the price of the apartment
     * @param quantity the number of available units
     */
    public ApartmentEntity(int id, String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
        this.id = id;
        this.name = name;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.floorSpace = floorSpace;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Constructor without id
     * @param name the name of the apartment
     * @param numBeds the number of bedrooms
     * @param numBaths the number of bathrooms
     * @param floorSpace the floor space of the apartment
     * @param price the price of the apartment
     * @param quantity the number of available units
     */
    public ApartmentEntity(String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
        this.name = name;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.floorSpace = floorSpace;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the unique identifier for the apartment
     * @return the id of the apartment
     */
	public int getId() {
		return id;
	}
	/**
	 * Sets the unique identifier for the apartment
	 * @param id the unique identifier for the apartment
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Gets the name of the apartment
	 * @return the name of the apartment
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the apartment
	 * @param name the name of the apartment
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the number of bedrooms in the apartment
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
	 * Gets the number of bathrooms in the apartment
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
	 * Gets the floor space of the apartment
	 * @return the floor space of the apartment
	 */
	public int getFloorSpace() {
		return floorSpace;
	}
	/**
	 * Sets the floor space of the apartment
	 * @param floorSpace the floor space of the apartment
	 */
	public void setFloorSpace(int floorSpace) {
		this.floorSpace = floorSpace;
	}
	/**
	 * Gets the price of the apartment
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
	 * Gets the number of available units of the apartment
	 * @return the number of available units
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Sets the number of available units of the apartment
	 * @param quantity the number of available units
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    
   
}
