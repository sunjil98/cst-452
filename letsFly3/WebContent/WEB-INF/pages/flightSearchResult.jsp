<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- This is the table to display search result -->
<h5>Out Bound flight</h5>
<table>
		<tr>
		<th><label>Flight ID</label></th>
		<th ><label>Origin</label></th>
		<th ><label>Destination</label></th>
		<th ><label>Flight Date</label></th>
		<th ><label>Flight Time</label></th>
		<th ><label>Connection Time</label></th>
		<th ><label>Meal</label></th>
		<th><label>Aircraft Type</label>
		<th><label>Flight Hours</label>
		<th><label>price</label>
		
		</tr>
		<!-- For each loop -->
		<c:forEach var="flights" items="${flights}">
		<tr>	<td><label>${flights.id}</label></td>
				<td><label>${flights.originAirport}</label></td>
				<td><label>${flights.destinationAirport}</label></td>
				<td><label>${flights.flightDate}</label></td>
				<td><label>${flights.flightTime}</label></td>
				<td><label>${flights.connectionFlight}</label></td>
				<td><label>${flights.meal}</label></td>
				<td><label>${flights.aircraftType}</label></td>
				<td><label>${flights.flightHours}</label></td>
				<td><label>${flights.price}</label></td>
				<!-- update button -->
				<td>
					<!-- send shoe data to update page -->
					<form:form method="POST" modelAttribute="flight" action="buy" autocomplete="off">
						<input id="id" name="id" type="hidden" value="${flights.id}"/>
						<button type="submit" class="btn btn-success">Select</button>
						<br/>
					</form:form>
				</td>
		</tr>
				
		</c:forEach>
		</table>
		

		
		<h5>In bound flight</h5>
		<table>
		<tr>
		<th ><label>Origin</label></th>
		<th ><label>Destination</label></th>
		<th ><label>Flight Date</label></th>
		<th ><label>Flight Time</label></th>
		<th ><label>Connection Time</label></th>
		<th ><label>Meal</label></th>
		<th><label>Aircraft Type</label>
		<th><label>Flight Hours</label>
		<th><label>price</label>
		
		</tr>
		<!-- For each loop -->
		<c:forEach var="inBound" items="${inBound}">
		<tr>	
				<td><label>${inBound.originAirport}</label></td>
				<td><label>${inBound.destinationAirport}</label></td>
				<td><label>${inBound.flightDate}</label></td>
				<td><label>${inBound.flightTime}</label></td>
				<td><label>${inBound.connectionFlight}</label></td>
				<td><label>${inBound.meal}</label></td>
				<td><label>${inBound.aircraftType}</label></td>
				<td><label>${inBound.flightHours}</label></td>
				<td><label>${inBound.price}</label></td>
		</tr>
				
		</c:forEach>
		</table>
		
		<a href="/letsFly3/oneWay" role="button">Go Back</a>
		<a href="/letsFly3/viewSelectedFlights" role="button"> See flights</a>
</body>
</html>