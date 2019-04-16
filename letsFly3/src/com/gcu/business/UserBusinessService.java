/**
 * Class: UserBusinessService
 * Role: This class is responsible for handling all the business logic of the application related to user.
 * Date: 4/14/2019
 * Author: Sunjil Gahatraj
 */
package com.gcu.business;

import com.gcu.data.FlightDataAccessInterface;
import com.gcu.data.UserDataAccessInterface;
import com.gcu.model.Flight;
import com.gcu.model.User;
import com.gcu.model.UserFlight;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Sunjil Gahatraj
 *
 */
public class UserBusinessService implements UserBusinessInterface {

	/**
	 * Variables
	 */
	@SuppressWarnings("rawtypes")
	@Autowired
	UserDataAccessInterface dao;

	/**
	 * Instance of flight model
	 */
    Flight flight;
	
    /**
	 * init method to initialize the season
	 * @return void
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}
	/**
	 * method to destroy session 
	 * @return void
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/**
	 * This method is used to insert user's data into session when is then used in confirmation page. 
	 * The goal is to not enter any user data until verified by user. This return instance of user
	 * @return User
	 * @param User
	 */
	@Override
	public User insertUserDataInSession(User user) {
		User userInfo= new User(user.getFirstname(),user.getLastname(),user.getEmail(),user.getPhone());
		return userInfo;
	}
	/**
	 * This method is used to insert user information into database once verified by the user.
	 * This returns boolean
	 * @return boolean
	 * @param List<Flight>, User, UserFlight
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean insertUserDataInDatabase(List<Flight> cart, User userInfo,UserFlight userFlightInfo)
	{
		/**
		 * Getting user information out of session and storing in variables
		 */
		String firstname= userInfo.getFirstname();
		String lastname= userInfo.getLastname();
		String email= userInfo.getEmail();
		 int phone= userInfo.getPhone();
		
		userFlightInfo.setFirstname(firstname);
		userFlightInfo.setLastname(lastname);
		userFlightInfo.setEmail(email);
		userFlightInfo.setPhone(phone);
		/**
		 * Since one user can choose multiple flight, using for loop to find all the flights and add into database
		 */
		for(int i=0; i<cart.size();i++)
		{
			flight=(cart.get(i));
			
			userFlightInfo.setId(flight.getId());
			userFlightInfo.setOriginAirport(flight.getOriginAirport());
			userFlightInfo.setDestinationAirport(flight.getDestinationAirport());
			userFlightInfo.setFlightDate(flight.getFlightDate());
			userFlightInfo.setFlightTime(flight.getFlightTime());
			dao.addUser(userFlightInfo);
		}
		return false;
	}

}
