<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- This page is responsible for providing detail of the flights they selected. It will also give user to choose the number of passenger -->
<body>
<div class="container">
	<div class="row">
	<div class="col-sm-6 col-md-6 col-lg-6S" style="background-color:yellow;">
	<div class="form-group">
	<h5>Thank you very much for your business. Please review you personal detail below.</h5>
	</div>
	<div class="form-group">
	Firstname:<c:out value="${userInfo.firstname}"></c:out>
	</div>
	<div class="form-group">
	Lastname:<c:out value="${userInfo.lastname}"></c:out>
	</div>
	<div class="form-group">
	Email:<c:out value="${userInfo.email}"></c:out>
	</div>
	<div class="form-group">
	Phone:<c:out value="${userInfo.phone}"></c:out>
	</div>
</div>
	<div class="col-sm-6 col-md-6 col-lg-6S"style="background-color:pink;">
      <h1>Flight Info</h1>
             <c:set var="actualprice" value="0"></c:set>
       <c:set var="tax" value="0"></c:set>
       <c:set var="total" value="0"></c:set>
       	<c:set var="airportservicecharge" value="0"></c:set>
       <c:forEach var="cart" items="${sessionScope.cart}" varStatus="status">

		
		<c:set var="actualprice" value="${actualprice+ cart.price}"></c:set>	
		
		<c:set var ="tax" value="${actualprice* 0.20}"></c:set>
	
		<c:set var ="airportservicecharge" value="${actualprice* 0.10}"></c:set>
		
		<c:set var="total" value="${actualprice+tax+airportservicecharge}"></c:set>
		
		From:<c:out value="${cart.originAirport}"></c:out>
		<br/>
		To:<c:out value="${cart.destinationAirport}"></c:out>
		<br/>
		Time:<c:out value="${cart.flightTime}"></c:out>
		<br/>
		Date:<c:out value="${cart.flightDate}"></c:out>
		<br/>
		Layover:<c:out value="${cart.connectionFlight}"></c:out>
		<br/>
		Meal:<c:out value="${cart.meal}"></c:out>
		<br/>
	
		<h2>------------------</h2>

				</c:forEach>
					<c:set var="id" value ="cart${status.index}"></c:set>
		Amount:$<c:out value="${actualprice }"></c:out>
		<br/>
		Tax:$<c:out value="${tax }"></c:out>
		<br/>
		Airport tax: $<c:out value="${airportservicecharge }"></c:out>
		<br/>
		Total:$<c:out value="${total }"></c:out>
				
</div>
</div>
</div>
<c:if test="${buttonDisabler==0}">
<form:form method="POST" model="UserFlight" action="saveuser">
<input id="buttonDisabler" name="buttonDisabler" type="hidden" value="${1}"/>
<button type="submit" class="btn btn-success">This information is Correct</button>
</form:form>
</c:if>

<c:if test="${buttonDisabler==0}">
<form:form method="GET" action="userDetail">
<button type="submit" class="btn btn-removal">This information is wrong</button>
</form:form>
</c:if>
<c:if test="${buttonDisabler==1}">
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
</c:if>
</body>