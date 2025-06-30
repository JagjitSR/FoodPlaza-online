<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="message.jsp"></jsp:include>

	<form action="LoginServlet" method="post">
		<table class="table table-success">
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<td><input type="submit" value="login" class="btn btn-success"></td>
				<td><input type="reset" value="clear" class="btn btn-warning"></td>
			</tr>
		</table>
	</form>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>