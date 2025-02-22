package com.gcu.apartmentx.business;

import java.util.List;

import com.gcu.apartmentx.models.ApartmentModel;

public interface ApartmentInterface
{
	public List<ApartmentModel> getAllApartments();
	public String addApartment(ApartmentModel apartment);
	public ApartmentModel findApartmentById(int id);
	public void updateApartment(ApartmentModel apartmentModel);
	public void deleteApartment(int id);
	public void init();
	public void destroy();
}
