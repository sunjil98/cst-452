/**
 * Class: UserController
 * Role: This is a controller classs to control movement between Usermodel, and view.
 * Date:4/14/2019
 * Author: Sunjil Gahatraj
 */
package com.gcu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserBusinessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.gcu.model.Flight;
import com.gcu.model.User;
import com.gcu.model.UserFlight;

/**
 * 
 * @author Sunjil Gahatraj
 *
 */
@Controller
@RequestMapping("/")
public class UserController {

	/**
	 * Injecting Userbusiness service
	 */
	UserBusinessInterface service;
	
	/**
	 * initializing buttondisabler which is used later to disable and enable the button based on its value
	 */
	int buttonDisabler=0;
	
	/**
	 * This method is used to bring the userDetailPage
	 * @param user
	 * @return ModelAndView userDetail
	 */
	@RequestMapping(path="/userDetail", method=RequestMethod.GET)
	public ModelAndView dispalyUserDetailForm(@ModelAttribute("user") User user)
	{
		
		return new ModelAndView("userDetail");
	}
	
	/**
	 * This method is used to add user information to the session. User information is stored in session and then used later to 
	 * provide the overview before storing in the database
	 * @param user
	 * @param session
	 * @return String
	 */
	@RequestMapping(path="/addUserInformation", method=RequestMethod.POST)
	public ModelAndView displayUserInformation(@ModelAttribute("user") User user, HttpSession session)
	{
		/**
		 * instance of UserFlight model
		 */
		User userInfo;
		/**
		 * adding user in the session using insertUserDataInSession method in UserBussinessService class
		 */
		userInfo= service.insertUserDataInSession(user);
		ModelAndView mv = new ModelAndView("viewSelectedFlightsPage");
		session.setAttribute("userInfo", userInfo);
		mv.addObject("userInfo", userInfo);
	    mv.addObject("buttonDisabler",buttonDisabler);
		return mv;
	}
	
	/**
	 * This method is used to insert user and fight infomration into database
	 * @param user
	 * @param userFlightInfo
	 * @param session
	 * @return ModelAndView
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/saveuser", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user, @ModelAttribute("UserFlight") UserFlight userFlightInfo, HttpSession session,@RequestParam("buttonDisabler") int buttonDisabler)
	{
		
		
		User userInfo= (User) session.getAttribute("userInfo");
		List<Flight> cart= new ArrayList<Flight>();
		/**
		 * getting list of flight information from the session and inserting into database using insertUserDataInDatabase method in business class
		 */
	    cart=(List<Flight>) session.getAttribute("cart");
	    service.insertUserDataInDatabase(cart, userInfo,userFlightInfo);
	    /**
		 * Creating instance of modelandview
		 */
		ModelAndView mv = new ModelAndView("viewSelectedFlightsPage");
	    mv.addObject("buttonDisabler",buttonDisabler);
		return mv;
	}
	
	/**
	 * 	setter method
	 * @param service
	 */
		@Autowired
		public void setUserBusinessService(UserBusinessInterface service)
		{
			this.service = service;
		}
}
