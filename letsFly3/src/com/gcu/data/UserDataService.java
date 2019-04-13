package com.gcu.data;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.UserFlight;
import com.gcu.util.DatabaseException;

@SuppressWarnings("unused")
public class UserDataService implements UserDataAccessInterface<UserFlight> {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public UserDataService() {}
	
	/**
	 * setter method
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean addUser(UserFlight userFlight) {
		String sql = "INSERT INTO letsfly.FLIGHTANDCUSTOMER(FIRSTNAME,LASTNAME, EMAIL, PHONE, FLIGHTID, ORIGINAIRPORT,DESTINATIONAIRPORT, FLIGHTDATE, FLIGHTTIME) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			//execute sql 
			int rows = jdbcTemplateObject.update(sql, userFlight.getFirstname(), userFlight.getLastname(), userFlight.getEmail(), userFlight.getPhone(), userFlight.getId(), userFlight.getOriginAirport(), userFlight.getDestinationAirport(), userFlight.getFlightDate(), userFlight.getFlightTime());
			
			//if rows returned == 1 return true, else return false
			return rows == 1 ? true : false;
		}
		//catching database exception
		
		//catch (Exception e)
		catch (DataAccessException e)
		{
			
			 //e.printStackTrace();
			throw new DatabaseException(e);
		}
		
	}

}
