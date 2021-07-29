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
	@Column(name = "Password")
	private String Password;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public DataUser(String email, String password) {
			this.setEmail(email);
			this.setPassword(password);
		}
	public DataUser() {		
	}
}
