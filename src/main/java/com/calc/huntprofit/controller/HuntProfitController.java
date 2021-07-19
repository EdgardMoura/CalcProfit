package com.calc.huntprofit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calc.huntprofit.repository.HuntProfitRepository;
import com.calc.huntprofit.util.HuntProfit;

@RestController
public class HuntProfitController {
	

	@RequestMapping(value = "/")
	public @ResponseBody String Informacao() {
				
		return "<b>Enter the corresponding values! For Example: <br> "
				+ "/imprimi/Elder Druid name/Ed spending/Party profit </b>";
	}
	
	@Autowired
	HuntProfitRepository huntProfitRepository;
	
	@RequestMapping(value = "/imprimi/{nameEd}/{partyProfit}/{suplyEd}")
	public @ResponseBody String imprimi(@PathVariable String nameEd, @PathVariable Double partyProfit,
			@PathVariable Double suplyEd) {
		HuntProfit hunt = new HuntProfit(nameEd, partyProfit, suplyEd);
		huntProfitRepository.save(hunt);

		return hunt.ToStringHTML();

	}
	
	@RequestMapping(value = "/delete/{id}")
	public @ResponseBody String Delete(@PathVariable Long id) {
		huntProfitRepository.deleteById(id);
		
		return "<b>Delete register done! <br> ";
	}
}
