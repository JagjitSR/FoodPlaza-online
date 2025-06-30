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

<form action="FoodServlet" method="post">
<h2>Add New Food</h2>
<input type="hidden" name="process" value="addFood">
<table class="table table-success">
	<tr>
	<td>Name:</td>
	<td><input type="text" name="foodName" class="form-control"></td>
	</tr>
	<tr>
	<td>Type:</td>
	<td><input type="text" name="foodType" class="form-control"></td>
	</tr>
	<tr>
	<td>Category:</td>
	<td><input type="text" name="foodCategory" class="form-control"></td>
	</tr>
	<tr>
	<td>Description:</td>
	<td><input type="text" name="foodDesc" class="form-control"></td>
	</tr>
	<tr>
	<td>Price:</td>
	<td><input type="number" step="0.01" name="foodPrice" class="form-control"></td>
	</tr>
	<tr>
	<td>Img:</td>
	<td><input type="text" name="image" class="form-control"></td>
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