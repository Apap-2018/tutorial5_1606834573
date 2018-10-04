package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.repository.CarDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * Car Service Impl
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDb carDb;
	
	
	@Override
	public void addCar(CarModel car) {
		carDb.save(car);
	}
	
	// Delete implementation
	@Override
	public void deleteCar(Long carIdDel) {
		carDb.deleteById(carIdDel);		
	}

	// Update implementation
	@Override
	public void updateCar(Long carIdUp, String carBrandUp, String carTypeUp, Long carPriceUp, Integer carAmountUp) {
		carDb.getOne(carIdUp).setBrand(carBrandUp);
		carDb.getOne(carIdUp).setType(carTypeUp);
		carDb.getOne(carIdUp).setPrice(carPriceUp);
		carDb.getOne(carIdUp).setAmount(carAmountUp);		
	}
}
