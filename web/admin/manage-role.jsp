<%@ page import="com.chuan.servlet.flight.bean.RoleBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Role Management</title>
</head>
<body>

<h2>Admin - Role Management</h2>

<%-- Get Role List --%>
<% List<RoleBean> roleList = (List<RoleBean>)request.getAttribute("roleList"); %>

<table>
    <thead>
    <th>Role Id</th>
    <th>Role Name</th>
    <th>Edit</th>
    </thead>
    <tbody>

    <%-- Loop the role list --%>
    <% for(RoleBean role: roleList) { %>

    <tr>
        <td><%= role.getRoleId() %></td>
        <td><%= role.getRoleName() %></td>
        <td><a href="/EditRoleServlet?role_id=<%= role.getRoleId() %>">edit</a></td>
    </tr>

    <% } %>

    </tbody>
</table>


</body>
</html>
