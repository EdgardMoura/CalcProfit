package com.calc.huntprofit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HuntProfit")

public class HuntProfit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	@Column(name = "NomeEd")
	private String NomeEd;
	@Column(name = "SuplyEd")
	private Double SuplyEd;
	@Column(name = "ProfitParty")
	private Double ProfitParty;
	@Column(name = "ekReal")
	private Double ekReal;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEd() {
		return NomeEd;
	}

	public void setNomeEd(String nomeEd) {
		NomeEd = nomeEd;
	}

	public Double getSuplyEd() {
		return SuplyEd;
	}

	public void setSuplyEd(Double suplyEd) {
		SuplyEd = suplyEd;
	}

	public Double getProfitParty() {
		return ProfitParty;
	}

	public void setProfitParty(Double profitParty) {
		ProfitParty = profitParty;
	}

	public HuntProfit(String nomeEd, Double suplyEd, Double profitParty) {

		this.setNomeEd(nomeEd);
		this.setSuplyEd(suplyEd);
		this.setProfitParty(profitParty);
		this.setEkReal();
	}
		

	public HuntProfit() {
		
	}

	private double edTransfer(Double a, Double b) {
		return a / 2 + b;
	}
	
	public Double getEkReal() {
		return ekReal;
	}

	public void setEkReal() {
		this.ekReal = edTransfer(this.getProfitParty(), this.getSuplyEd()) - this.getSuplyEd();
	}
		

	
	public String ToStringHTML() {
		return "O gasto do ED " 
				+ NomeEd + " foi de : " 
				+ String.format("%.2f", this.getSuplyEd())+ "<br>"
				+ "O PROFIT da party foi de : " 
				+ String.format("%.2f", this.getProfitParty())+ "<br>"
				+ "O valor a ser transferido para o " 
				+ NomeEd 
				+ " é de : " 
				+ String.format("%.2f", this.edTransfer(this.getProfitParty(), this.getSuplyEd()))+ "<br>"				
				+ "O profit REAL do EK foi de: " 
				+ String.format("%.2f", this.getEkReal());
	}
}
