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
	
	@RequestMapping(value = "/delete/")
	public @ResponseBody String Informacao1() {
				
		return "<b>Non-existent id!! <br> ";
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
	public String Delete (@PathVariable Long id){
		
		if (huntProfitRepository.countItem(id) > 0) {
			try {
				huntProfitRepository.deleteItem(id);
				
				return "<b>Delete register done! <br> ";
				}
				catch (Exception ex) {
					return "<b>Id isn'n valid <b>" 
				+ ex.toString();					
				}
		}
		else {
			return "<b> Id not found!<b>";
		}
	}	
	
	@RequestMapping(value = "/find/{id}")
	public String Find (@PathVariable Long id){
		String temp = "";
		if (huntProfitRepository.countItem(id) > 0) {
			try {
				 for(HuntProfit item : huntProfitRepository.findItem(id)){
			            temp += (item.getId().toString() + "  -  " 
				 + item.getNomeEd() + "  -  "
				 + item.getEkReal().toString() + "  -  "
				 + item.getSuplyEd().toString() + "<br>");
			        }
				return temp;
				
				}
				catch (Exception ex) {
					return "<b>Id isn'n valid <br>" 
				+ ex.toString();					
				}
		}
		else {
			return "<b> Id not found!<b>";
		}
	}
	
	
	@RequestMapping(value = "/findname/{nomeEd}")
	public String Find (@PathVariable String nomeEd){
		String temp1 = "";
		if (huntProfitRepository.countItem(nomeEd) != null) {
			
				 for(HuntProfit item : huntProfitRepository.findItem(nomeEd)){
			            temp1 += (item.getNomeEd() + "  -  "
			            + item.getProfitParty() + "  -  "
			            + item.getEkReal()
			            + "<br>");
			        }
				return temp1;								
		}
		else {
			return "<b> Name not found!<b>";
		}
	}
}

