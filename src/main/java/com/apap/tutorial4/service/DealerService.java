package com.apap.tutorial4.service;

import java.util.Optional;
import java.util.List;

import com.apap.tutorial4.model.DealerModel;


/**
 * Dealer Service
 */
public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	
	void addDealer(DealerModel dealer);
	
	// Delete
	void deleteDealer(Long dealerIdDel);
		
	// Update
	void updateDealer(Long dealerIdUp, String dealerAlamatUp, String dealerBoTelpUp);
	
	// View all
	List<DealerModel> viewAllDealer();
	
}
