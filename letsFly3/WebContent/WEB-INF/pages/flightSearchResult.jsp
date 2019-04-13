<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- This page display the search result based on the data entered by user. It is divided into two display area, one to display outbound flight and \
another one to display inBound flight. Inbound flight result is only displayed for round trip search result -->
<body>
<!-- This is the table to display inBound result -->
<h5>Out Bound flight</h5>

<div class="container">
<div class="info-grid">
	<div class="row">
		<div class="col">
			From:<c:out value="${originAirport}"></c:out>
		</div>
		<div class="col">
			To:<c:out value="${destinationAirport}"></c:out>
		</div>
		<div class="col">
			Departure:<c:out value="${departureDate}"></c:out>
		</div>
	</div>
	</div>
</div>


		<!-- For each loop to dispaly all the outBound flight matching the criteria-->
		<c:forEach var="flights" items="${flights}">
		       <div class="container">
		       <div class="row" style="background-color:yellow;">
				       <div class="col">
							<c:out value="${flights.originAirport}"></c:out>--------------
						</div>
						<div class="col">
						<c:out value="${flights.destinationAirport}"></c:out>
						</div>
						<div class="col">
						<c:out value="${flights.flightDate}"></c:out>
						</div>
						<div class="col">
						<c:out value="${flights.flightTime}"></c:out>
						</div>
					    <div class="col">
						<c:out value="${flights.flightHours}"></c:out>
						</div>
						<div class="col">
						<c:out value="${flights.price}"></c:out>
						</div>
				<!-- Select button to select flight-->
				
				<c:if test="${viewType==1}">
				<div class="col">
					<div class="button-class" style="margin:auto;">
				<form:form method="POST" modelAttribute="flight" action="buy" autocomplete="off">
						<input id="id" name="id" type="hidden" value="${flights.id}"/>
						<input id="viewTypeSelector" name="viewTypeSelector" type="hidden" value="${viewType}"/>
						<button type="submit" class="btn btn-success" style="margin:center;">Select</button>
						<br/>
					</form:form>
					</div>
				</div>
					</c:if>
					
				<c:if test="${viewType==2}">
				<div class="col">
					<!-- send select data to viewSelectedFlight page -->
					<form:form method="POST" modelAttribute="flight" action="buy" autocomplete="off">
						<input id="id" name="id" type="hidden" value="${flights.id}"/>
						<input id="viewTypeSelector" name="viewTypeSelector" type="hidden" value="${viewType}"/>
						<button type="submit" class="btn btn-success" style="margin:center;" ${ buttonDisabler!=0  ? 'disabled="disabled"' : ''}>Select</button>
						<br/>
					</form:form>
					</div>
					</c:if>			
					</div>
					</div>
		</c:forEach>
		
		</table>
		<h1><c:out value="${buttonDisabler}"></c:out></h1>
		<c:if test="${viewType==2}">
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
		<!-- For each loop to display inBound flight for matching criteria-->
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
				<td>
					<!-- send select data to viewSelectedFlight page -->
					<form:form method="POST" modelAttribute="flight" action="buy" autocomplete="off">
						<input id="id" name="id" type="hidden" value="${inBound.id}"/>
						<input id="viewTypeSelector" name="viewTypeSelector" type="hidden" value="1"/>
						<button type="submit" class="btn btn-success" ${ buttonDisabler==0  ? 'disabled="disabled"' : ''}>Select</button>
						<br/>
					</form:form>
				</td>
		</tr>
				
		</c:forEach>
		</table>
		</c:if>
		<a href="/letsFly3/oneWay" role="button">Go Back</a>
		<a href="/letsFly3/viewSelectedFlights" role="button"> See flights</a>
</body>
