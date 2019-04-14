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

@Controller
@RequestMapping("/user")
public class UserController {

	UserBusinessInterface service;
	Flight flight;
	int buttonDisabler=0;
	
	@RequestMapping(path="/userDetail", method=RequestMethod.GET)
	public ModelAndView dispalyUserDetailFormh(@ModelAttribute("user") User user)
	{
		return new ModelAndView("userDetail");
	}
	
	@RequestMapping(path="/addUserInformation", method=RequestMethod.POST)
	public ModelAndView displayUserInformationForm(@ModelAttribute("user") User user, HttpSession session)
	{
		int buttonDisabler=0;
		User userInfo;
		userInfo= service.insertUserDataInSession(user);
		ModelAndView mv = new ModelAndView("viewSelectedFlightsPage");
        session.setAttribute("userInfo", userInfo);
		mv.addObject("userInfo", userInfo);
		mv.addObject("buttonDisabler",buttonDisabler);
		return mv;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(path="/saveuser", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user, @ModelAttribute("UserFlight") UserFlight userFlightInfo, HttpSession session)
	{
		
		ModelAndView mv = new ModelAndView("redirect:/viewSelectedFlights");
		
		User userInfo= (User) session.getAttribute("userInfo");
		List<Flight> cart= new ArrayList<Flight>();
	    cart=(List<Flight>) session.getAttribute("cart");
	    service.insertUserDataInDatabase(cart, userInfo,userFlightInfo);
	    buttonDisabler++;
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
