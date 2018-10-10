package com.apap.tutorial4.controller;

import java.util.List;

import com.apap.tutorial4.model.*;
import com.apap.tutorial4.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
 * Dealer Controller
 */
@Controller
public class DealerController {
	@Autowired
	private DealerService dealerService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("pageTitle", "Home");
		return "home";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("dealer", new DealerModel());
		return "addDealer";
	}
	
	@RequestMapping(value = "/dealer/add", method = RequestMethod.POST)
	private String addDealerSubmit(@ModelAttribute DealerModel dealer) {
		dealerService.addDealer(dealer);
		return "add";
	}
	
	@RequestMapping(value = "/dealer/view", method = RequestMethod.GET)
	private String viewDealer(@RequestParam(value = "dealerId") Long dealerId, Model model) {
		DealerModel archiveDealer = dealerService.getDealerDetailById(dealerId).get();
		/**
		* Untuk mendapatkan list car terurut berdasarkan harga dengan Query
		* Bisa jadi beberda dengan cara Anda
		*/
		List<CarModel> archiveListCar = carService.getListCarOrderByPriceAsc(dealerId);
		archiveDealer.setListCar(archiveListCar);

		model.addAttribute("dealer", archiveDealer);
		model.addAttribute("listCar", archiveListCar);
		return "view-dealer";
	}

	
//	// Delete
//	@RequestMapping(value = "/dealer/delete", method = RequestMethod.GET)
//	private String deleteDealerById(@RequestParam("dealerIdDel") Long dealerIdDel, Model model) {
//		dealerService.deleteDealer(dealerIdDel);
//		return "delete";
//	}
	
	@RequestMapping(value = "/dealer/delete/{dealerIdDel}")
	private String deleteDealer(@PathVariable("dealerIdDel") Long dealerIdDel, Model model) {
		dealerService.deleteDealer(dealerIdDel);
		return "delete";
	}
	
	// Update
	@RequestMapping(value = "/dealer/update/{dealerIdUp}", method = RequestMethod.GET)
	private String updateDealerById(@PathVariable("dealerIdUp") Long dealerIdUp, Model model) {
		DealerModel dealerUp = dealerService.getDealerDetailById(dealerIdUp).get();
		//dealerService.updateDealer(dealerIdUp, dealerAlamatUp, dealerNoTelpUp);		
		model.addAttribute("dealerUp", dealerUp);
		return "updateDealer";
	}
	
	
	@RequestMapping(value = "/dealer/update/{dealerIdUp}", method = RequestMethod.POST)
	private String updateDealer(@ModelAttribute DealerModel dealerUp, @PathVariable("dealerIdUp") Long dealerIdUp, Model model) {
		dealerService.updateDealer(dealerIdUp, dealerUp.getAlamat(), dealerUp.getNoTelp());		
		return "update";
	}
	
	
	// View all dealer
	@RequestMapping(value = "/dealer/view-all", method = RequestMethod.GET)
	public String viewAllDealer(Model model) {
		List<DealerModel> listAllDealer = dealerService.viewAllDealer();
		model.addAttribute("listAllDealer", listAllDealer);
		return "view-all-dealer";
	}
}
