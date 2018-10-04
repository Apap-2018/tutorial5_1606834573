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
	private String home() {
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
	
	// Delete
	@RequestMapping(value = "/dealer/delete", method = RequestMethod.GET)
	private String deleteDealerById(@RequestParam("dealerIdDel") Long dealerIdDel, Model model) {
		dealerService.deleteDealer(dealerIdDel);
		return "delete";
	}
	
	// Update
	@RequestMapping(value = "/dealer/update", method = RequestMethod.GET)
	private String updateDealerById(@RequestParam("dealerIdUp") Long dealerIdUp, Model model, @RequestParam("dealerAlamatUp") String dealerAlamatUp, @RequestParam("dealerNoTelpUp") String dealerNoTelpUp) {
		dealerService.updateDealer(dealerIdUp, dealerAlamatUp, dealerNoTelpUp);
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
