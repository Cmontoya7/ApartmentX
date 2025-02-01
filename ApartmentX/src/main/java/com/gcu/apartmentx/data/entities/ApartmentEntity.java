package com.gcu.apartmentx.data.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

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

    //default constructor
    public ApartmentEntity() {}

    //constructor with id
    public ApartmentEntity(int id, String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
        this.id = id;
        this.name = name;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.floorSpace = floorSpace;
        this.price = price;
        this.quantity = quantity;
    }

    //constructor without id 
    public ApartmentEntity(String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
        this.name = name;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.floorSpace = floorSpace;
        this.price = price;
        this.quantity = quantity;
    }

    
    //getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumBeds() {
		return numBeds;
	}

	public void setNumBeds(int numBeds) {
		this.numBeds = numBeds;
	}

	public int getNumBaths() {
		return numBaths;
	}

	public void setNumBaths(int numBaths) {
		this.numBaths = numBaths;
	}

	public int getFloorSpace() {
		return floorSpace;
	}

	public void setFloorSpace(int floorSpace) {
		this.floorSpace = floorSpace;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    
   
}
