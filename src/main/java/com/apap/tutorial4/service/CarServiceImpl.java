package com.apap.tutorial4.service;

import java.util.List;
import java.util.Optional;

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
	 public Optional<CarModel> getDetailCarById(Long id) {
		 return carDb.findById(id);
	 }
	
	@Override
	public void addCar(CarModel car) {
		carDb.save(car);
	}
	
	@Override
	public List<CarModel> getListCarOrderByPriceAsc(Long dealerId) {
		return carDb.findByDealerIdOrderByPriceAsc(dealerId);
	}
	
	// Delete implementation
	@Override
	public void deleteCar(Long carIdDel) {
		carDb.deleteById(carIdDel);		
	}

	// Update implementation
	@Override
	 public void updateCar(Long id, CarModel carNew) {
		 CarModel carOld = this.getDetailCarById(id).get();
		 carOld.setBrand(carNew.getBrand());
		 carOld.setType(carNew.getType());
		 carOld.setPrice(carNew.getPrice());
		 carOld.setAmount(carNew.getAmount());
	 }
	
	// Delete implementation rev
	 public void deleteCarById(Long id) {
		 carDb.delete(this.getDetailCarById(id).get());
	 }
}
