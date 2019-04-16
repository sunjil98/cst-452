/**
 * Class: UserBusinessInterface
 * Role: Business Service Interface class
 * Date:4/14/2019
 * Author: Sunjil Gahatraj
 */
package com.gcu.business;

import com.gcu.model.Flight;
import com.gcu.model.User;
import com.gcu.model.UserFlight;

import java.util.List;

/**
 * 
 * @author Sunjil Gahatraj
 *
 */
public interface UserBusinessInterface {
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

	/**
	 * 
	 * @param User
	 * @return User
	 */
	public User insertUserDataInSession(User user);
	
	/**
	 * 
	 * @param cart
	 * @param userInfo
	 * @param userFlightInfo
	 * @return boolean
	 */
	public boolean insertUserDataInDatabase(List<Flight> cart, User userInfo, UserFlight userFlightInfo);
}
