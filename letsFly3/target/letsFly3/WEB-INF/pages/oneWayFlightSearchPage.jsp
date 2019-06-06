<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<!-- This page display the form to perform one way flight search. -->
<h2>One way Flight</h2>
<!-- Link to get to the page to search for round trip -->
<a  href="roundTrip"><button>Round Trip Flight Search</button></a>
<form:form method = "POST" modelAttribute="flight" action="oneWayResult">

<!-- Input area -->
		  <div class="container">
		  	<div class="row">
		  	
		  	<div class="col">
		  	<br/>
		       <form:label path="flightDate">Flight Date:</form:label>
			<form:input path="flightDate"/>
		     </div>
		     <div class="col">
               <form:label path = "originAirport">From</form:label>
               
                  <form:select path = "originAirport">
                     <form:option value = "Phoenix Sky Harbor International Airport" label = "PHX- Phoenix Sky Harbor International Airport"/>
                     <form:options items = "${airportList}" />
                  </form:select>     	
               </div>
               <div class="col">
               <br/>
                <form:label path = "destinationAirport">To</form:label>
               
                  <form:select path = "destinationAirport">
                     <form:option value = "Phoenix Sky Harbor International Airport" label = "PHX- Phoenix Sky Harbor International Airport"/>
                     <form:options items = "${airportList}" />
                  </form:select>     	
              </div>
              </div>
              <br/>
          
              <div class="col">
              <br/>
              <input id="flightDate" name="flightDate" type="hidden" value="flightDate"/>
				<input type= "submit" value= "submit"/>
				</div>
			
		  </div>
	
</form:form>
</body>
