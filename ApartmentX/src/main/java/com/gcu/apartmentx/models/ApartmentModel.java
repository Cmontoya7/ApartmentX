package com.gcu.apartmentx.models;

public class ApartmentModel {
	
    private String name;
    private int numBeds;
    private int numBaths;
    private int floorSpace;
    private float price;
    private int quantity;


    public ApartmentModel(String name, int numBeds, int numBaths, int floorSpace, float price, int quantity) {
        this.name = name;
        this.numBeds = numBeds;
        this.numBaths = numBaths;
        this.floorSpace = floorSpace;
        this.price = price;
        this.quantity = quantity;
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
