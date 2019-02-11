/**
 * Class: GlobalExceptionController
 * Role: Direct user to error page if Database exception is caught
 */
package com.gcu.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.util.DatabaseException;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(DatabaseException.class)
	public ModelAndView catchDataBaseError(Exception e)
	{
		ModelAndView mv= new ModelAndView("errorPage");
		mv.addObject("error", "Seems like something is wrong with database. Please try again later");
		return mv;
	}

}
