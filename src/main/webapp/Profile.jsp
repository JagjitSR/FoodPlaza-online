<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="POJO.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<style>
form {
    place-items: center;
}
</style>
<script>
function checkPasswordChange(emailId, originalPassword) {
    let input = document.getElementById('custPassword_' + emailId);
    let link = document.getElementById('updateLink_' + emailId);
    let newPassword = input.value;

    if (newPassword !== originalPassword) {
        let custName = document.getElementById('custName').value;

        let fullHref = "CustomerServlet?process=changePass" +
                       "&custName=" + encodeURIComponent(custName) +
                       "&custPassword=" + encodeURIComponent(newPassword);

        link.href = fullHref;
        link.style.display = 'inline-block';
    } else {
        link.style.display = 'none';
    }
}
</script>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="message.jsp"></jsp:include>

<%
    String login = (String) session.getAttribute("login");
    Customer c = (Customer) session.getAttribute("profile");
%>

<form action="CustomerServlet" method="post">
<input type="hidden" name="process" value="updateProfile">
<table class="table table-success">
    <tr>
        <td>Customer Name:</td>
        <td><input type="text" name="custName" class="form-control" id="custName" value="<%= c.getCustName() %>"></td>
    </tr>
    <tr>
        <td>Email ID:</td>
        <td><input type="text" name="emailId" class="form-control" value="<%= c.getEmailId() %>" readonly></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td>
            <input type="text" name="custPassword" class="form-control" 
                   id="custPassword_<%= c.getEmailId() %>" 
                   value="<%= c.getCustPassword() %>" 
                   oninput="checkPasswordChange('<%= c.getEmailId() %>', '<%= c.getCustPassword() %>')">
        </td>
    </tr>
    <tr>
        <td>Address:</td>
        <td><input type="text" name="custAddress" class="form-control" value="<%= c.getCustAddress() %>"></td>
    </tr>
    <tr>
        <td>Contact No:</td>
        <td><input type="text" name="contactNo" class="form-control" value="<%= c.getContactNo() %>"></td>
    </tr>
    <tr>
        <td>Location:</td>
        <td><input type="text" name="custLocation" class="form-control" value="<%= c.getCustLocation() %>"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Change Details" class="btn btn-success"></td>
        <td><a id="updateLink_<%= c.getEmailId() %>" class="btn btn-secondary text-light" style="display:none;">Update Password</a></td>
    </tr>
</table>
</form>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
