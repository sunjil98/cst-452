<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-6 col-lg-6S"
				style="background-color: yellow;">
				<form:form method="POST" modelAttribute="user"
					action="addUserInformation">
					<div class="form-group">
						<label for="firstname">First Name</label>
						<form:input minlength="4" maxlength="20" path="firstname"
							type="text" class="form-control" id="firstname"
							placeholder="Enter your first name" />
						<small class="form-text text-muted"><form:errors
								path="firstname" /></small>
					</div>

					<div class="form-group">
						<label for="lastname">Last Name</label>
						<form:input minlength="4" maxlength="20" path="lastname"
							type="text" class="form-control" id="lastname"
							placeholder="Enter your last name" />
						<small class="form-text text-muted"><form:errors
								path="lastname" /></small>
					</div>
					<div class="form-group">
						<!-- email address label and input -->
						<label for="email">Email address</label>
						<form:input minlength="4" maxlength="20" path="email" type="email"
							class="form-control" id="email" aria-describedby="emailHelp"
							placeholder="Enter email" />
						<small class="form-text text-muted"><form:errors
								path="email" /></small>
					</div>

					<div class="form-group">
						<label for="phone">Phone</label>
						<form:input minlength="10" maxlength="10" path="phone" type="text"
							class="form-control" id="phone"
							placeholder="Enter your phone number" />
						<small class="form-text text-muted"><form:errors
								path="phone" /></small>
					</div>

					<button type="submit" class="btn btn-secondary">View
						Ticket</button>
				</form:form>
			</div>
			<div class="col-sm-6 col-md-6 col-lg-6S"
				style="background-color: pink;">
				<h1>Flight Info</h1>
				<c:forEach var="cart" items="${sessionScope.cart}">
					<c:set var="total" value="${total+ cart.price}"></c:set>
		
		From:<c:out value="${cart.originAirport}"></c:out>
					<br />
		To:<c:out value="${cart.destinationAirport}"></c:out>
					<br />
		Time:<c:out value="${cart.flightTime}"></c:out>
					<br />
		Date:<c:out value="${cart.flightDate}"></c:out>
					<br />
		Layover:<c:out value="${cart.connectionFlight}"></c:out>
					<br />
		Meal:<c:out value="${cart.meal}"></c:out>
					<br />
					<h2>------------------</h2>
				</c:forEach>
			</div>
		</div>
	</div>

</body>


