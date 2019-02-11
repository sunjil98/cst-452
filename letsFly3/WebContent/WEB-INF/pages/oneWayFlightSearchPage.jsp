<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<h2>One way Flight</h2>
<!-- Link to get to the page to search for round trip -->
<a  href="/letsFly3/roundTrip" role="button">Round Trip</a>
<form:form method = "POST" modelAttribute="flight" action="oneWayResult">
	<table>
<!-- Input area -->
		<tr>
			<td><form:label path="flightDate">Flight Date:</form:label></td>
			<td><form:input path="flightDate"/><form:errors path="flightDate"/></td>
		</tr>
		<tr>
               <td><form:label path = "originAirport">From</form:label></td>
               <td>
                  <form:select path = "originAirport">
                     <form:option value = "Phoenix Sky Harbor International Airport" label = "PHX- Phoenix Sky Harbor International Airport"/>
                     <form:options items = "${airportList}" />
                  </form:select>     	
               </td>
                <td><form:label path = "destinationAirport">To</form:label></td>
               <td>
                  <form:select path = "destinationAirport">
                     <form:option value = "Phoenix Sky Harbor International Airport" label = "PHX- Phoenix Sky Harbor International Airport"/>
                     <form:options items = "${airportList}" />
                  </form:select>     	
               </td>
            </tr>   	
		<tr>
			<td colspan="2">
				<input type= "submit" value= "submit"/>
		   </td>
		</tr>
	</table>
	
</form:form>
