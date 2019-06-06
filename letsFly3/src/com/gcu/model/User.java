package com.gcu.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;


public class User {
	
	
	int customerID;
	
	@NotNull(message="Firstname cannot be null")
	@Size(min=4, max=20, message="Firstname must be between 2 and 20 characters")
	String firstname;
	
	@NotNull(message="Lastname cannot be null")
	@Size(min=4, max=20, message="Lastname must be between 2 and 20 characters")
	String lastname;
	
	@NotNull(message="Email cannot be null")
	@Size(min=4, max=20, message="Email must be between 2 and 20 characters")
	String email;
	
	
	int phone;
	
	int numberOfUser;
	
	public int getNumberOfUser() {
		return numberOfUser;
	}

	public void setNumberOfUser(int numberOfUser) {
		this.numberOfUser = numberOfUser;
	}

	public User()
	{
		
	}
	
    public User(String firstname, String lastname, String email, int phone, int numberOfUser) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.numberOfUser=numberOfUser;
	}
    
	public User(String firstname, String lastname, String email, int phone) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	

}
