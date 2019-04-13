<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form:form method = "POST" modelAttribute="user" action="addUserInformation">
	<table>
		<tr>
			<td><form:label path="firstname">First Name:</form:label></td>
			<td><form:input path="firstname"/><form:errors path= "firstname"/></td>
		</tr>
		
		<tr>
			<td><form:label path="lastname">Last Name:</form:label></td>
			<td><form:input path="lastname"/><form:errors path="lastname"/></td>
		</tr>
		<tr>
			<td><form:label path="email">Email</form:label></td>
			<td><form:input path="email"/><form:errors path="email"/></td>
		</tr>
		<tr>
			<td><form:label path="phone">phone</form:label></td>
			<td><form:input path="phone"/><form:errors path="phone"/></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type= "submit" value= "submit"/>
		   </td>
		</tr>
	</table>
	<form:errors path="*"/>
</form:form>
</body>
</html>

