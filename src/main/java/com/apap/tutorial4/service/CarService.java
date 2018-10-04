package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.CarModel;

/**
 * Car Service 
 */

public interface CarService {
	void addCar(CarModel car);
	
	// Delete
	void deleteCar(Long carIdDel);
	
	// Update
	void updateCar(Long carIdUp, String carBrandUp, String carTypeUp, Long carPriceUp, Integer carAmountUp);
}
