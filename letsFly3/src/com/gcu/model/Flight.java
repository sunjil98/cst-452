/**
 * Class: Flight
 * Role: Flight Model Object
 * Date: 12/10/2018
 * Author: Sunjil Gahatraj
 */
package com.gcu.model;

public class Flight {
	
	/**
	 * Variables
	 */
	int id;
	String originAirport;
	String destinationAirport;
	String flightDate;
	String returnDate;
	String flightTime;
	String connectionFlight;
	String meal;
	String aircraftType;
	double flightHours;
	double price;
	
	/**
	 * Default Constructor 
	 */
	public Flight()
	{
		originAirport="";
		destinationAirport="";
		flightDate="";
		returnDate="";
		 flightTime="";
		 connectionFlight="";
		 meal="";
		 aircraftType="";
		flightHours=0;
		price=0;
		
	}
	
	/**
	 * Parameterized Constructor
	 * @param id
	 * @param originAirport
	 * @param destinationAirport
	 * @param flightDate
	 * @param flightTime
	 * @param connectionFlight
	 * @param meal
	 * @param aircraftType
	 * @param flightHours
	 * @param price
	 */
	public Flight(int id, String originAirport, String destinationAirport, String flightDate, String flightTime,
			String connectionFlight, String meal, String aircraftType, double flightHours, double price) {
	
		this.id = id;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.connectionFlight = connectionFlight;
		this.meal = meal;
		this.aircraftType = aircraftType;
		this.flightHours = flightHours;
		this.price = price;
	}
	
	public void Flight1(int id, String originAirport, String destinationAirport, String returnDate, String flightTime,
			String connectionFlight, String meal, String aircraftType, double flightHours, double price) {
	
		this.id = id;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.returnDate = returnDate;
		this.flightTime = flightTime;
		this.connectionFlight = connectionFlight;
		this.meal = meal;
		this.aircraftType = aircraftType;
		this.flightHours = flightHours;
		this.price = price;
	}
	
	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return String
	 */
	public String getOriginAirport() {
		return originAirport;
	}
	/**
	 * 
	 * @param originAirport
	 */
	public void setOriginAirport(String originAirport) {
		this.originAirport = originAirport;
	}
	/**
	 * 
	 * @return String
	 */
	public String getDestinationAirport() {
		return destinationAirport;
	}
	/**
	 * 
	 * @param destinationAirport
	 */
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	/**
	 * 
	 * @return String
	 */
	public String getFlightDate() {
		return flightDate;
	}
	/**
	 * 
	 * @param flightDate
	 */
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	/**
	 * 
	 * @return String
	 */
	public String getFlightTime() {
		return flightTime;
	}
	
	/**
	 * 
	 * @param flightTime
	 */
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	/**
	 * 
	 * @return String
	 */
	public String getConnectionFlight() {
		return connectionFlight;
	}
	/**
	 * 
	 * @param connectionFlight
	 */
	public void setConnectionFlight(String connectionFlight) {
		this.connectionFlight = connectionFlight;
	}
	/**
	 * 
	 * @return String
	 */
	public String getMeal() {
		return meal;
	}
	/**
	 * 
	 * @param meal
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}
	/**
	 * 
	 * @return String
	 */
	public String getAircraftType() {
		return aircraftType;
	}
	/**
	 * 
	 * @param aircraftType
	 */
	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}
	/**
	 * 
	 * @return double
	 */
	public double getFlightHours() {
		return flightHours;
	}
	/**
	 * 
	 * @param flightHours
	 */
	public void setFlightHours(double flightHours) {
		this.flightHours = flightHours;
	}
	/**
	 * 
	 * @return double
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	

}
