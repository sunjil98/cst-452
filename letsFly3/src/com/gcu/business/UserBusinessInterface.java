package com.gcu.business;

import com.gcu.model.Flight;
import com.gcu.model.User;
import com.gcu.model.UserFlight;

import java.util.List;

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

	public User insertUserDataInSession(User user);
	public boolean insertUserDataInDatabase(List<Flight> cart, User userInfo, UserFlight userFlightInfo);
}
