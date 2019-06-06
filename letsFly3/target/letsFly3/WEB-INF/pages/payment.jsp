<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<body>
<form class="needs-validation" novalidate>
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="validationCustom01">First name</label>
      <input type="text" class="form-control" id="validationCustom01" placeholder="First name" value="Sunjil" required>
      
    </div>
    <div class="col-md-4 mb-3">
      <label for="validationCustom02">Last name</label>
      <input type="text" class="form-control" id="validationCustom02" placeholder="Last name" value="Gahatraj" required>
    </div>
  </div>
  <div class="form-row">

    <div class="col-md-3 mb-3">
      <label for="validationCustom03">Date of Birth</label>
      <input type="text" class="form-control" id="validationCustom04" placeholder="dob" required>
      
    </div>
    <div class="col-md-3 mb-3">
      <label for="validationCustom04">Phone Number</label>
      <input type="text" class="form-control" id="validationCustom05" placeholder="phone" required>
    </div>
  </div>

  <button class="btn btn-primary" type="submit">Submit form</button>
</form>
</body>
