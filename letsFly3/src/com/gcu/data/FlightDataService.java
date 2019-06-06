/**
 * Class: FlightDataService
 * Role: Data Access Object Class
 * Date: 12/10/2018
 * Author: Sunjil Gahatraj
 */
package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.model.Flight;
import com.gcu.util.DatabaseException;

/**
 * 
 * @author Sunjil Gahatraj
 *
 */
@SuppressWarnings("unused")
public class FlightDataService implements FlightDataAccessInterface<Flight>{

	/**
	 * Variables for Database connection 
	 */
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Default Constructor 
	 */
	public FlightDataService()
	{
		
	}
	

	/**
	 * This method takes Origin airport, destination airport, and flight date as parameter and search database for the matching case.
	 * It returns List of flights as a result. 
	 */
	@Override
	public List<Flight> findOneWayFlight(Flight t) {
		List<Flight> outBoundFlight = new ArrayList<Flight>();
		String flightDate=t.getFlightDate();
		String newFlightDate= flightDate.replace(",flightDate","");
		
		String sql= "SELECT * FROM etpdiccxs02169o9.FLIGHT WHERE ORIGINAIRPORT=? AND DESTINATIONAIRPORT=? AND FLIGHTDATE=?";
		
		try {
			//execute sql
			SqlRowSet srs= jdbcTemplateObject.queryForRowSet(sql, t.getOriginAirport(), t.getDestinationAirport(),newFlightDate);
			while(srs.next()) {
				outBoundFlight.add(new Flight(srs.getInt("FID"),
						srs.getString("ORIGINAIRPORT"),
						srs.getString("DESTINATIONAIRPORT"),
						srs.getString("FLIGHTDATE"),
						srs.getString("FLIGHTTIME"),
						srs.getString("CONNECTIONFLIGHT"),
						srs.getString("MEAL"),
						srs.getString("AIRCRAFTTYPE"),
						srs.getDouble("TOTALFLIGHTTIME"),
						srs.getDouble("PRICE")
								
								));
				
			}
			System.out.println(outBoundFlight.size());
		}
		/**
		 * Catching database exception and throwing custom exception
		 */
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}

		return outBoundFlight;		
		
	}
	
	/**
	 * This method takes Origin airport, destination airport, and flight date as parameter and search database for the matching case.
	 * It returns List of flights as a result. 
	 */
	@Override
	public List<Flight> findBackWayFlight(Flight t) {
		List<Flight> inBoundFlight = new ArrayList<Flight>();
		String returnDate=t.getReturnDate();
		String newreturnDate= returnDate.replace(",returnDate","");
		String sql= "SELECT * FROM etpdiccxs02169o9.FLIGHT WHERE ORIGINAIRPORT=? AND DESTINATIONAIRPORT=? AND FLIGHTDATE=?";
		
		try {
			//execute sql
			SqlRowSet srs= jdbcTemplateObject.queryForRowSet(sql, t.getDestinationAirport(), t.getOriginAirport(),newreturnDate);
			while(srs.next()) {
				inBoundFlight.add(new Flight(srs.getInt("FID"),
						srs.getString("ORIGINAIRPORT"),
						srs.getString("DESTINATIONAIRPORT"),
						srs.getString("FLIGHTDATE"),
						srs.getString("FLIGHTTIME"),
						srs.getString("CONNECTIONFLIGHT"),
						srs.getString("MEAL"),
						srs.getString("AIRCRAFTTYPE"),
						srs.getDouble("TOTALFLIGHTTIME"),
						srs.getDouble("PRICE")
								));
				
			}
			System.out.println(inBoundFlight.size());
		}
		/**
		 * Catching database exception and throwing custom exception
		 */
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}

		return inBoundFlight;		
		
	}
	/**
	 * This method is used to query the flight table based on flight id passed on by POST method. This return arraylist of flight and its information.
	 */
	public List<Flight> findFlightById(Flight t)
	{
		List<Flight> flightById= new ArrayList<Flight>();
		String sql= "SELECT * FROM etpdiccxs02169o9.FLIGHT WHERE FID=?";
		try {
			//execute sql
			SqlRowSet srs= jdbcTemplateObject.queryForRowSet(sql, t.getId());
			while(srs.next()) {
				flightById.add(new Flight(srs.getInt("FID"),
						srs.getString("ORIGINAIRPORT"),
						srs.getString("DESTINATIONAIRPORT"),
						srs.getString("FLIGHTDATE"),
						srs.getString("FLIGHTTIME"),
						srs.getString("CONNECTIONFLIGHT"),
						srs.getString("MEAL"),
						srs.getString("AIRCRAFTTYPE"),
						srs.getDouble("TOTALFLIGHTTIME"),
						srs.getDouble("PRICE")
								));
				
			}
			System.out.println(flightById.size());
		}
		/**
		 * Catching database exception and throwing custom exception
		 */
		catch (DataAccessException e)
		{
			
			throw new DatabaseException(e);
		}
		
	
		return flightById;
	}
	
	/**
	 * setter method
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource= dataSource;
		this.jdbcTemplateObject= new JdbcTemplate(dataSource);
	}
	

}
