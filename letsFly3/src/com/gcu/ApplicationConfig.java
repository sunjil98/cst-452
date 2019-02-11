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
import com.gcu.controller.FlightController;

@Configuration
public class ApplicationConfig {
	@Bean(name="flightController")
	public FlightController getFlightController()
	{
		return new FlightController();
	}

	@Bean(name="flightBusinessService", initMethod="init", destroyMethod="destroy")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public FlightBusinessInterface getFlightService()
	{
		return new FlightBusinessService();
	}
	

}
