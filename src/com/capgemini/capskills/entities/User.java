package com.capgemini.capskills.entities;

import com.capgemini.capskills.entities.base.BaseEntity;

public class User extends BaseEntity {

	/**
	 * Class Attributes
	 */
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;

	
	/**
	 * Getters and Setters
	 * @return
	 */
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLogin() {
		return this.firstname + "." + this.lastname;
	}

	@Override
	public String toString() {
		return "User [lastname=" + lastname + ", firstname=" + firstname
				+ ", email=" + email + ", password=" + password + ", getId()="
				+ getId() + "]";
	}
	
}
