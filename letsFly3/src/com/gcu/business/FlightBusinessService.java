/**
 * Class: FlightBusinessService
 * Role: Business service class. This class contains all the methods that is responsible for performing logical action in the application.
 * Date: 12/14/2018
 * Author: Sunjil Gahatraj
 */
package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.FlightDataAccessInterface;
import com.gcu.model.Flight;
import com.gcu.util.FlightNotFoundException;

/**
 * 
 * @author Sunjil Gahatraj
 *
 */
public class FlightBusinessService implements FlightBusinessInterface {

	/**
	 * DAO interface injection
	 */
	@SuppressWarnings("rawtypes")
	@Autowired
	FlightDataAccessInterface dao;
	
	/**
	 * This method is reponsible to get list of flights passed on by the findOneWayFlight method in DAO class.
	 * It return List of flights as a result
	 * @throws FlightNotFoundException 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Flight> findOneWayFlight(Flight flight) throws FlightNotFoundException {
		List<Flight> result=dao.findOneWayFlight(flight);
		if(result.size()==0)
		{
			throw new FlightNotFoundException();
		}
		else
		return dao.findOneWayFlight(flight);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Flight> findBackWayFlight(Flight flight) throws FlightNotFoundException
	{
		List<Flight> inBoundList=dao.findBackWayFlight(flight);
		if(inBoundList.size()==0)
		{
			throw new FlightNotFoundException();
		}
		else
			return dao.findBackWayFlight(flight);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Flight> findFlightById(Flight flight) throws FlightNotFoundException
	{
		List<Flight> flightById= dao.findFlightById(flight);
		if(flightById.size()==0)
		{
			throw new FlightNotFoundException();
		}
		else
			return flightById;
	}
	/**
	 * init method to initialize the season
	 * @return void
	 */
	public void init()
	{
		//print init msg
		System.out.println("init() using session FlightrBusinessService");
	}
	
	/**
	 * method to destroy session 
	 * @return void
	 */
	public void destroy()
	{
		//print destroy msg
		System.out.println("destroy() in FlightBusinessService");
	}

}
