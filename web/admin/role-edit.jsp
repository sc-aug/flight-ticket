<%@ page import="com.chuan.servlet.flight.bean.RoleBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Edit Role</title>
</head>
<body>

<%-- get role by id --%>
<% RoleBean role = (RoleBean)request.getAttribute("role"); %>

<h2>Role Edit</h2>

<form action="/EditRoleServlet" method="post">

    UID: <%= role.getRoleId() %> <br>
    Username <input type="text" value="<%= role.getRoleName() %>" name="role_name"> <br>

    <input type="hidden" value="<%= role.getRoleId() %>" name="role_id">
    <input type="submit" value="edit">

</form>

</body>
</html>
