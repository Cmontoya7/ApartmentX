package com.gcu.apartmentx.business;

import java.util.List;

import com.gcu.apartmentx.models.ApartmentModel;

public interface ApartmentInterface
{
	public List<ApartmentModel> getListings();
	public void addApartment(String name, int numBeds, int numBaths, int floorSpace, float price, int quantity);
	public void init();
	public void destroy();
}
