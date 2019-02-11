/**
 * Class: FlightBusinessInterface
 * Role: Business service Interface class
 * Date: 12/16/2018
 * Author: Sunjil Gahatraj
 * 
 */
package com.gcu.business;

import java.util.List;

import com.gcu.model.Flight;
import com.gcu.util.FlightNotFoundException;


/**
 * 
 * @author Sunjil Gahatraj
 *
 */
public interface FlightBusinessInterface {
	/**
	 * findOneWayFlight method
	 * @param flight
	 * @return List
	 */
	public List<Flight> findOneWayFlight(Flight flight)throws FlightNotFoundException;
	
	public List<Flight> findBackWayFlight(Flight flight) throws FlightNotFoundException;
	/**
	 * method init
	 * @return void
	 */
	public void init();
	/**
	 * method destroy
	 * @return void
	 */
	public void destroy();

}
