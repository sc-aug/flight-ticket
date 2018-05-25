<%@ page import="com.chuan.servlet.flight.bean.AccountBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Edit Account</title>
</head>
<body>

<%-- get airplane by id --%>
<% AccountBean account = (AccountBean)request.getAttribute("account"); %>

<h2>Airplane Edit</h2>

<form action="/EditAccountServlet" method="post">

    UID: <%= account.getUId() %> <br>
    Username <input type="text" value="<%= account.getUsername() %>" name="username"> <br>
    Password <input type="text" value="<%= account.getPassword() %>" name="password"> <br>
    Role Id <input type="numeric" value="<%= account.getRoleId() %>" name="role_id"> <br>

    <input type="hidden" value="<%= account.getUId() %>" name="uid">
    <input type="submit" value="edit">

</form>

</body>
</html>
