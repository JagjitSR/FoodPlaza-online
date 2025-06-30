<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import ="java.time.format.DateTimeFormatter" %>
<%@ page import="POJO.OrderFood" %>
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

<table class="table table-success">
<tr>
<td>OrderId</td>
<td>OrderDate</td>
<td>TotalBill</td>
<td>OrderStatus</td>
<td>Action</td>
</tr>
<% 
List<OrderFood> olist=(List<OrderFood>)session.getAttribute("olist");
for(OrderFood o:olist){%>
<tr>
<td><%=o.getOrderId() %></td>
<td><%=o.getOrderDate().format(DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm:ss"))%></td>
<td><%=o.getTotalBill() %></td>
<td><%=o.getOrderStatus() %></td>
<td><a href="OrderServlet?process=getDetails&orderId=<%=o.getOrderId()%>">Details</a></td>
</tr>
<%}%>
</table>
<jsp:include page="Footer.jsp"/>

</body>
</html>