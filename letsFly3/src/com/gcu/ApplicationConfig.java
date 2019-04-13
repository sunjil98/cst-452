/**
 * Class: ApplicationConfig
 * Objective: To hold springbean configuration 
 * 
 */
package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.gcu.business.FlightBusinessInterface;
import com.gcu.business.FlightBusinessService;
import com.gcu.business.UserBusinessService;
import com.gcu.business.UserBusinessInterface;
import com.gcu.controller.FlightController;
import com.gcu.controller.UserController;

@Configuration
public class ApplicationConfig {
	@Bean(name="flightController")
	public FlightController getFlightController()
	{
		return new FlightController();
	}
	
	@Bean(name="userController")
	public UserController getUserController()
	{
		return new UserController();
	}
	
	@Bean(name="flightBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public FlightBusinessInterface getFlightService()
	{
		return new FlightBusinessService();
	}
	
	@Bean(name="userBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserBusinessInterface getUserService()
	{
		return new UserBusinessService();
	}
	
	

}
