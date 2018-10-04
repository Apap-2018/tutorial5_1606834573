package com.apap.tutorial4.service;

import java.util.Optional;
import java.util.List;

import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.repository.DealerDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DealerService 
 */
@Service
@Transactional

public class DealerServiceImpl implements DealerService{
	@Autowired
	private DealerDb dealerDb;
	
	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		return dealerDb.findById(id);
	}
	
	@Override
	public void addDealer(DealerModel dealer) {
		dealerDb.save(dealer);
	}
	
	// Delete implementation
	@Override
	public void deleteDealer(Long dealerIdDel) {
		dealerDb.deleteById(dealerIdDel);
	}

	// Update implementation
	public void updateDealer(Long dealerIdUpdate, String alamat, String noTelp) {
		dealerDb.getOne(dealerIdUpdate).setAlamat(alamat);
		dealerDb.getOne(dealerIdUpdate).setNoTelp(noTelp);		
	}

	// View all dealer
	@Override
	public List<DealerModel> viewAllDealer() {
		return dealerDb.findAll();		
	}
}
