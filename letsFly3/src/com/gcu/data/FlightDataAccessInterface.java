/**
 * Class:FlightDataAccessInterface
 * Role: DAO Interface
 * Date: 12/10/2018
 * Author: Sunjil Gahatraj
 */
package com.gcu.data;

import java.util.List;

import com.gcu.model.Flight;

/**
 * 
 * @author Sunjil Gahatraj
 *
 * @param <T> Generic
 */
public interface FlightDataAccessInterface <T>{
	
	/**
	 * 
	 * @param t
	 * @return List
	 */
	public List<T> findOneWayFlight(T t);
	/**
	 * 
	 * @param t
	 * @return List
	 */
	public List<Flight> findBackWayFlight(T t);
	
	/**
	 * 
	 * @param t
	 * @return List
	 */
	public List<Flight> findFlightById(T t);

}
