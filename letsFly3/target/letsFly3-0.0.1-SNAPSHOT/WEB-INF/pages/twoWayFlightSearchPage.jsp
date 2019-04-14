<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<body>
<!-- This page display the form where user can input information to perform two way flight search. The difference between
this form and one way flight search form is it has extra field to enter return data -->

<h2>Two way Flight</h2>
<!-- Link to get the page to do one way ticket search -->
<a  href="/letsFly3/oneWay" role="button">One Way</a>
<form:form method = "POST" modelAttribute="flight" action="roundWayResult">
	        <div class="container">
	        <div class="row">
	        <div class="col">
			<form:label path="flightDate">Flight Date:</form:label>
			<form:input path="flightDate"/>
	     	</div>
		
			<div class="col">
			<form:label path="returnDate">Return Date:</form:label>
			<form:input path="returnDate"/>
		   </div>
		
				<div class="col">
               <form:label path = "originAirport">From</form:label>
               
                  <form:select path = "originAirport">
                     <form:option value = "Phoenix Sky Harbor International Airport" label = "PHX- Phoenix Sky Harbor International Airport"/>
                     <form:options items = "${airportList}" />
                  </form:select>     	
               </div>
               <div class="col">
                <form:label path = "destinationAirport">To</form:label>
               
                  <form:select path = "destinationAirport">
                     <form:option value = "Phoenix Sky Harbor International Airport" label = "PHX- Phoenix Sky Harbor International Airport"/>
                     <form:options items = "${airportList}" />
                  </form:select>     	
                  </div>
                  </div>
                  <div class="row">
                  <div class="col">
				<input type= "submit" value= "submit"/>
				</div>
                  </div>
				
</div>
</form:form>

</body>

