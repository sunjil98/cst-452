/**
 * Class: FlightController
 * Role: Controls all the flight related activities
 * Date: 12/10/2018
 * Author: Sunjil Gahatraj
 */
package com.gcu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.FlightBusinessInterface;

import com.gcu.model.Flight;
import com.gcu.model.User;
import com.gcu.model.UserFlight;
import com.gcu.util.FlightNotFoundException;

/**
 * 
 * @author Sunjil Gahatraj
 *
 */
@Controller
@RequestMapping("/")
public class FlightController {
	
	/**
	 * creating instance of logger
	 */
	private static Logger logger= LoggerFactory.getLogger(FlightController.class);
	/**
	 * Business service injection
	 */
	FlightBusinessInterface interf;
	
   /**
    * Initalizing buttonDisabler variable which is user to disable and enabled button on JSP pages
    */
	int buttonDisabler=0;
	
	/**
	 * Initializing instance of Flight to hold flights that are added to the cart. Also initializing variables to count the index of cart                                                                                                                                                                     
	 */
	List<Flight> cart= new ArrayList<Flight>();
	int i=0;
	
	
	/**
	 * This method is used to display view to enter information for One way ticket. This return oneWayFlightSearchPage as a view.
	 * @return View
	 */
	@RequestMapping(path="", method=RequestMethod.GET)
	public ModelAndView displayForm()
	{
		logger.info("Entering displayForm method in flight controller");
		cart.clear();
		 buttonDisabler=0;
		return new ModelAndView("oneWayFlightSearchPage", "flight", new Flight(0, null, null, null, null, null, null, null, 0, 0));
	}
	
	/**
	 * This method is used to display view to enter information for round trip ticket. This return twoWayFlightSearchPage as a view.
	 * @return View
	 */
	@RequestMapping(path="/roundTrip", method=RequestMethod.GET)
	public ModelAndView displayRoundTripForm()
	{
		logger.info("Entering displayRoundTripForm method in flightcontroller");
		cart.clear();
		 buttonDisabler=0;
		return new ModelAndView("twoWayFlightSearchPage", "flight", new Flight(0, null, null, null, null, null, null, null, 0, 0));
	}
	
	/**
	 * This method is used to direct user to the page where they can see all the selected flights
	 * @return ModelAndView: viewSelectedFlightsPage
	 */
	@RequestMapping(path="/viewSelectedFlights", method=RequestMethod.GET)
	public ModelAndView displaySelectedFlights()
	{
		return new ModelAndView("viewSelectedFlightsPage");
	}
	
	
	
	/**
	 * This method is used to take the POST data from one way ticket search and redirect user to search result page.
	 * This returns flight search result as a view.
	 * @param flight
	 * @return view
	 */
	@RequestMapping(path="/oneWayResult", method=RequestMethod.POST)
	public ModelAndView displayOneWayResult(@ModelAttribute("flight") Flight flight)
	{
		logger.info("Entering displayonewayresult method in flightcontroller");
		/**
		 * Initalizing variable of type Flight to hold the list of flights return from the search result as resultset
		 */
		List<Flight> flights;
		
		/**
		 * Getting the list of flights from business service
		 */
	
		/**
		 * ViewType 1 stands for one way search and two for 2 RoundTrip search. This is used in JSTL if statement to show inBound Flight result
		 */
		
		int viewType=1;
		/**
		 * Try and catch block
		 */
		try {
			/**
			 * Getting originairport, destination, and flight data from the return list to add in the view
			 */
			logger.info("Entering try block of oneWayResult");
			System.out.println("######################"+flight.getFlightDate()+"##########################");
			flights = interf.findOneWayFlight(flight);
			String originAirport= flight.getOriginAirport();
			String destinationAirport=flight.getDestinationAirport();
			String departureDate=flight.getFlightDate();
			
			/**
			 * Adding object to view
			 */
			ModelAndView mv = new ModelAndView("flightSearchResult");
			mv.addObject("flights", flights);
			mv.addObject("viewType",viewType);
			mv.addObject("buttonDisabler",buttonDisabler);
			mv.addObject("originAirport",originAirport);
			mv.addObject("destinationAirport",destinationAirport);
			mv.addObject("departureDate", departureDate);
			logger.info("redirecting to flightSearchResult");
			
			return mv;
		} catch (FlightNotFoundException e) {
			logger.error("Could not find flight");
			System.out.println("caught no Flight found");
			ModelAndView mv = new ModelAndView("errorPage");
			mv.addObject("error","No matching flight found");
			return mv;
		}
		
		
	}
	
	/**
	 * This method is used to search for round trip flight and direct user to search result page 
	 * @param flight
	 * @return modelAndView flighSearchResult
	 */
	@RequestMapping(path="/roundWayResult", method=RequestMethod.POST)
	public ModelAndView displayRoundWayResult(@ModelAttribute("flight") Flight flight, HttpSession session)
	{
		logger.info("entering displayRoudWayResult method in flightcontroller");
		/**
		 * Getting the list of flights from business service and stroing in list
		 */
		List<Flight> flights;
		List<Flight> inBound;
		/**
		 * ViewType two stands for round way search. This is used in JSTL if statement to show inBound Flight result
		 */
		int viewType=2;
		try {
			/**
			 * Storing origin airport, destination airport, flightdate, and return flight date in variables, which is then passed on
			 * to view 
			 */
			flights = interf.findOneWayFlight(flight);
			inBound= interf.findBackWayFlight(flight);
			String originAirport= flight.getOriginAirport();
			String destinationAirport=flight.getDestinationAirport();
			String departureDate=flight.getFlightDate();
			String returnDate=flight.getReturnDate();
			/**
			 * Adding object to view
			 */
			ModelAndView mv = new ModelAndView("flightSearchResult");
			mv.addObject("flights", flights);
			session.setAttribute("flights", flights);
			mv.addObject("inBound", inBound);
			session.setAttribute("inBound", inBound);
			mv.addObject("viewType",viewType);
			mv.addObject("buttonDisabler",buttonDisabler);
			mv.addObject("originAirport",originAirport);
			mv.addObject("destinationAirport",destinationAirport);
			mv.addObject("departureDate", departureDate);
			mv.addObject("returnDate",returnDate);
			return mv;
		} catch (FlightNotFoundException e) {
			System.out.println("caught no Flight found");
			ModelAndView mv = new ModelAndView("errorPage");
			mv.addObject("error","No matching flight found");
			return mv;
		}
		
		
	}
	
	/**
	 * This method is used to get the id of user selected flight and storing the information of that particular flight in session. 
	 * @param flight
	 * @param session
	 * @return View that shows the selected flight detail
	 */
	@RequestMapping(value="/buy", method=RequestMethod.POST)
	public ModelAndView selectFlight(@ModelAttribute("flight") Flight flight, HttpSession session,@RequestParam("viewTypeSelector") int viewTypeSelector)
	{
		
    	i=cart.size();
    	  
    	 /**
    	  * Try and catch block. Try block has all the logic required to perform task where as catch block catch flightnotfoundexception
    	  */
    	  try {
    		  /**
    		   * ViewSelector=2 is used to display both inbound and outbound flights in flight result page
    		   */
    		  if(viewTypeSelector==2)
    		  {
    			  /**
    			   * creating instance of modelandview.
    			   * adding flights in the cart and increasing value of i
    			   */
    		   ModelAndView mv = new ModelAndView("flightSearchResult");
    		  cart.addAll(i, interf.findFlightById(flight));
    		  i++;
    		  buttonDisabler++;
    		  int viewType=viewTypeSelector;
    		  mv.addObject("viewType",viewType);
    		  mv.addObject("buttonDisabler",buttonDisabler);
    		  session.setAttribute("cart", cart);
    		  mv.addObject("cart", cart);
    		  return mv;
    		  }
    		  else
    		  {
    			  
    			  ModelAndView mv = new ModelAndView("redirect:/userDetail");
    			  cart.addAll(i, interf.findFlightById(flight));
        		  i++;
        		  int viewType=viewTypeSelector;
        		  mv.addObject("viewType",viewType);
        		  session.setAttribute("cart", cart);
        		  mv.addObject("cart",cart);
        		  String originAirport= flight.getOriginAirport();
      			String destinationAirport=flight.getDestinationAirport();
      			String departureDate=flight.getFlightDate();
      			String returnDate=flight.getReturnDate();
      			mv.addObject("originAirport",originAirport);
    			mv.addObject("destinationAirport",destinationAirport);
    			mv.addObject("departureDate", departureDate);
    			mv.addObject("returnDate",returnDate);
        	      return mv;
    		  }
    		 
			
		} catch (FlightNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  session.setAttribute("cart", cart);
    	  return null;
	}
	
	
/**
 * This method is used to redirect user to payment page
 * @return modelAndView
 */

	/**
	 * List of airport that is being displayed in drop down in views
	 * @return
	 */
	@ModelAttribute("airportList")
	   public Map<String, String> getAirportList() {
	      Map<String, String> airportList = new HashMap<String, String>();
	      airportList.put("Los Angeles International Airport","LAX- Los Angeles International Airport");
		   airportList.put("Tribhuwan International Airport","KTM- Tribhuwan International Airport");
		   airportList.put("San Francisco International Airport","SFO- San Francisco International Airport");
		   airportList.put("John F. Keneddy International Airport","JFK- John F. Keneddy International Airport");
	      return airportList;
	   }
	
	/**
	 * Setter method
	 * @param interf
	 */
	@Autowired
	public void setFlightBusinessService(FlightBusinessInterface interf)
	{
		this.interf=interf;
	}

}
