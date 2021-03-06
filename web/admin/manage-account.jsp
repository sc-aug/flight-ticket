<%@ page import="java.util.List" %>
<%@ page import="com.chuan.servlet.flight.bean.AccountBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - User Management</title>
</head>
<body>

    <h2>Admin - User Management</h2>

    <h3><a href="/AddAccountServlet">Add an Account</a></h3>

    <%-- Get Accout List --%>
    <% List<AccountBean> accountList = (List<AccountBean>)request.getAttribute("accountList"); %>

    <table>
        <thead>
            <th>User Id</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </thead>
        <tbody>

            <%-- Loop the account list --%>
            <% for(AccountBean acc: accountList) { %>

            <tr>
                <td><%= acc.getUId() %></td>
                <td><%= acc.getUsername() %></td>
                <td><%= acc.getPassword() %></td>
                <td><%= acc.getRoleName() %></td>
                <td><a href="/EditAccountServlet?uid=<%= acc.getUId() %>">edit</a></td>
                <td><a href="/DeleteAccountServlet?uid=<%= acc.getUId() %>">delete</a></td>
            </tr>

            <% } %>

        </tbody>
    </table>



</body>
</html>
