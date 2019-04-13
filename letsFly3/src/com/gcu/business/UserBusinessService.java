package com.gcu.business;

import com.gcu.data.FlightDataAccessInterface;
import com.gcu.data.UserDataAccessInterface;
import com.gcu.model.Flight;
import com.gcu.model.User;
import com.gcu.model.UserFlight;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class UserBusinessService implements UserBusinessInterface {

	List<Flight> cart= new ArrayList<Flight>();

	User user;
	Flight flight;
	
	@SuppressWarnings("rawtypes")
	@Autowired
	UserDataAccessInterface dao;


	
	
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public User insertUserDataInSession(User user) {
		User userInfo= new User(user.getFirstname(),user.getLastname(),user.getEmail(),user.getPhone());
		return userInfo;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean insertUserDataInDatabase(List<Flight> cart, User userInfo,UserFlight userFlightInfo)
	{
		String firstname= userInfo.getFirstname();
		String lastname= userInfo.getLastname();
		String email= userInfo.getEmail();
		 int phone= userInfo.getPhone();
		
		userFlightInfo.setFirstname(firstname);
		userFlightInfo.setLastname(lastname);
		userFlightInfo.setEmail(email);
		userFlightInfo.setPhone(phone);
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
