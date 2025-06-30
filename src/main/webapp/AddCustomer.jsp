<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
<style>
form{
    place-items: center;
}
</style>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="message.jsp"></jsp:include>

<form action="CustomerServlet" method="post">
<h2>Register New Customer</h2>
<input type="hidden" name="process" value="addCustomer">
<table class="table table-success">
	<tr>
	<td>Name:</td>
	<td><input type="text" name="custName" maxlength="25" required class="form-control"></td>
	</tr>
	<tr>
	<td>Address:</td>
	<td><input type="text" name="custAddress" maxlength="25" required class="form-control"></td>
	</tr>
	<tr>
	<td>Contact:</td>
	<td><input type="tel" name="contactNo" maxlength="10" pattern="[0-9]{10}" required class="form-control"></td>
	</tr>
	<tr>
	<td>Location:</td>
	<td><input type="text" name="custLocation" maxlength="25" required class="form-control"></td>
	</tr>
	<tr>
	<td>EmailID:</td>
	<td><input type="email" name="emailId" maxlength="25" required class="form-control"></td>
	</tr>
	<tr>
	<td>Password:</td>
	<td><input type="text" name="custPassword" maxlength="25" required class="form-control"></td>
	</tr>
	<tr>
	<td><input type="submit" value="Add" class="btn btn-success"></td>
	<td><input type="reset" value="Clear"class="btn btn-dark"></td>
	</tr>
</table>
</form>


<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>