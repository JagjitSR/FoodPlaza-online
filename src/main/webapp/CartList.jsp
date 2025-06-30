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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="myJquery.js"></script>
<script type="text/javascript">
$(function(){
	var arr=document.getElementsByClassName("totalPrice");
	var total=0;
	for(var i=0;i<arr.length;i++){
		total+=parseFloat(arr[i].value);
	}
	$("#totalBill").val(total);
});
function updateQuantity(element){
	var cartid=element.previousSibling.value;
	var quantity=element.value;
	if(quantity<1){
		element.value=1;
		quantity=1;
	}
	$post("CartServlet",{"cartid":cartid, "quantity":quantity, "process":"updateCartQuantity"},function(data, message){
	element.nextSibling.value=data;
	var arr=document.getElementsByClassName("totalPrice");
	var total=0;
	for(var i=0;i<arr.length;i++){
		total+=parseFloat(arr[i].value);	
	}
	$("#totalBill").val(total);
	});
}
</script>
</head>
<body>

<% String login=(String)session.getAttribute("login"); %>

<jsp:include page="Header.jsp"/>
<jsp:include page="message.jsp"/>

<form action="OrderServlet" method="post">
<input type="hidden" name="process" value="placeOrder">
<table class="table table-success">
<tr>
<th>Cart ID</th>
<th>Food Name</th>
<th>Quantity &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; SubTotal</th>
<th colspan="3">Action</th>
</tr>
<c:forEach var="c" items="${clist}">
<tr>
<td><input type="text" readonly="readonly" value="${c.cartid}" name="cartid" id="cartid"></td>
<td><input type="text" readonly="readonly" value="${c.fname}" name="foodName"></td>
<td>
<input type="hidden" value="${c.cartid}">
<input type="number" value="${c.fquantity}" name="quantity" id="quantity" onchange="updateQuantity(this)">
<input type="text" readonly="readonly" value="${c.totalPrice}" id="subTotal" class="totalPrice" name="totalPrice">
</td>
<td><a type="button" class="btn btn-success"href="CartServlet?process=deleteCartItem&cartid=${c.cartid}"><label>Remove From Cart</label></a></td>
</tr>
</c:forEach>
<tr>
<td colspan="4" style="text-align:right;">TotalBill:<input id="totalBill" value="" type="text" readonly="readonly" name="totalBill"></td>
</tr>
<tr>
<td colspan="2" style="text-align:right;"><a class="btn btn-outline-danger" href="CartServlet?process=clearCart">ClearCart</a></td>
<td colspan="2" style="text-align:left;"><input class="btn btn-outline-warning" type="submit" value="Order"></td>
</tr>
</table>
</form>

<jsp:include page="Footer.jsp"></jsp:include>


</body>
</html>