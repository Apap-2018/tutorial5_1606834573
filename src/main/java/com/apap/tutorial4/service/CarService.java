package com.apap.tutorial4.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial4.model.CarModel;

/**
 * Car Service 
 */

public interface CarService {
	void addCar(CarModel car);
	
	// Get car by ID
	Optional<CarModel> getDetailCarById(Long id);
	
	// Get by price ascending
	List<CarModel> getListCarOrderByPriceAsc(Long dealerId);
	
	// Delete
	void deleteCar(Long carIdDel);
	
	// Update
	void updateCar(Long carId, CarModel carNew);
	
	void deleteCarById(Long id);
}
