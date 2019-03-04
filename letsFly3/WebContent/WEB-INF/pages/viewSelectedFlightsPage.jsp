<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- This page is responsible for providing detail of the flights they selected. It will also give user to choose the number of passenger -->
<table>
<!-- Table that goes through the list of flight that are stored in Session and render them -->
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
		<c:set var="total" value="0"></c:set>
		<c:forEach var="flights" items="${sessionScope.cart}">
		<c:set var="total"
			value="${total+ flights.price}"></c:set>
		<tr>
				<td><label>${flights.originAirport}</label></td>
				<td><label>${flights.destinationAirport}</label></td>
				<td><label>${flights.flightDate}</label></td>
				<td><label>${flights.flightTime}</label></td>
				<td><label>${flights.connectionFlight}</label></td>
				<td><label>${flights.meal}</label></td>
				<td><label>${flights.aircraftType}</label></td>
				<td><label>${flights.flightHours}</label></td>
				<td><label>${flights.price}</label></td>
				<td>
				<form:form method="GET" modelAttribute="flight" action="oneWay" autocomplete="off">
						<button type="submit" class="btn btn-remove">Remove</button>
						<br/>
					</form:form>
				</td>
				</tr>
				</c:forEach>
</table>
<!-- This is the form that is responsible for PayPal payment -->
<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

  <!-- Identify your business so that you can collect the payments. -->
  <input type="hidden" name="business" value="sunjilMerchant@letsfly.com">

  <!-- Specify a Buy Now button. -->
  <input type="hidden" name="cmd" value="_xclick">

  <!-- Specify details about the item that buyers will purchase. -->
  <input type="hidden" name="amount" value="${total}">
  <input type="hidden" name="currency_code" value="USD">

  <!-- Display the payment button. -->
  <input type="image" name="submit" border="0"
  src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif"
  alt="Buy Now">
  <img alt="" border="0" width="1" height="1"
  src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" >

</form>