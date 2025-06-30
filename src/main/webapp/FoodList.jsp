<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
<style>

</style>
</head>
<body>

<%
String login=(String)session.getAttribute("login");
%>

<jsp:include page="Header.jsp"/>
<jsp:include page="message.jsp"/>
<table>
<tr>
<th>Food ID</th>
<th>Food Name</th>
<th>Food Type</th>
<th>Food Category</th>
<th>Food Description</th>
<th>Food Price</th>
<th>Food Image</th>
<th colspan="3">Action</th>
</tr>
<c:forEach var="f" items="${list}">
<tr>
<td>${f.foodId}</td>
<td>${f.foodName}</td>
<td>${f.foodType}</td>
<td>${f.foodCategory}</td>
<td>${f.foodDesc}</td>
<td>${f.foodPrice}</td>
<td><img src="${f.image}" height="100px" width="125px"></td>
<%if(login!=null && login.equals("admin")){%>
<td><a type="button" class="btn btn-warning" href="FoodServlet?process=updateFood&foodId=${f.foodId}"><label>Update</label></a></td>
<td><a type="button" class="btn btn-danger" href="FoodServlet?process=deleteFood&foodId=${f.foodId}"><label>Delete</label></a></td>
<%}%>
<%if(login!=null && login.equals("customer")){%>
<td><a type="button" class="btn btn-success"href="CartServlet?process=addToCart&foodId=${f.foodId}"><label>Add to Cart</label></a></td>
<%}%>
</tr>
</c:forEach>
</table>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>