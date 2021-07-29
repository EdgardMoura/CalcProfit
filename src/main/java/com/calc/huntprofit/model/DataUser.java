package com.calc.huntprofit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DataUser")

public class DataUser {
	
	@Id
	@Column(name = "Email")
	private String Email;
	@Column(name = "Pass")
	private String Pass;
	@Column(name = "NewPass")
	private String NewPass;
	
		
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getNewPass() {
		return NewPass;
	}
	public void setNewPass(String newPass) {
		NewPass = newPass;
	}

	
	public DataUser(String email, String pass, String newPass) {
		Email = email;
		Pass = pass;
		NewPass = newPass;
	}
	
	public DataUser(String email, String pass) {
			this.setEmail(email);
			this.setPass(pass);
		}
	
	public DataUser() {		
	}
}
