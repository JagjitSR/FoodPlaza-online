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
</head>
<body>

<% String login=(String)session.getAttribute("login"); %>

<jsp:include page="Header.jsp"/>
<jsp:include page="message.jsp"/>

<form action="OrderServlet" method="post">
<input type="hidden" name="process" value="placeOrder">
<table class="table table-success">
<tr>
<th>Order Details ID</th>
<th>Food Name</th>
<th>Quantity</th>
<th>Price</th>
<th>Status</th>
</tr>
<c:forEach var="od" items="${odlist}">
<tr>
<td>${od.orderDetailId}</td>
<td>${od.fname}</td>
<td>${od.fquantity}</td>
<td>${od.fprice}</td>
<td>${od.orderStatus}</td>
</tr>
</c:forEach>
</table>
</form>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>