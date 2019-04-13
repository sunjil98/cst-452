package com.gcu.model;

public class UserFlight {
	int ufid;
	String firstname;
	String lastname;
	String email;
	int phone;
	int id;
	String originAirport;
	String destinationAirport;
	String flightDate;

	String flightTime;
	
	public UserFlight(){
		
	}
	
	
	public UserFlight(int ufid,String firstname, String lastname, String email, int phone, int id,
			String originAirport, String destinationAirport, String flightDate, String flightTime) {
	
		this.ufid=ufid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.id = id;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.flightDate = flightDate;
		this.flightTime=flightTime;
		
	}
	
	public int getUfid() {
		return ufid;
	}

	public void setUfid(int ufid) {
		this.ufid = ufid;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	

}
