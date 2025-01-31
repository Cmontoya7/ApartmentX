package com.gcu.apartmentx.business;

import java.util.List;

import com.gcu.apartmentx.models.ApartmentModel;

public interface ApartmentInterface
{
	public List<ApartmentModel> getListings();
	public String addApartment(String name, int numBeds, int numBaths, int floorSpace, double price, int quantity);
	public void init();
	public void destroy();
}
