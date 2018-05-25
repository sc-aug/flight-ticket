<%@ page import="java.util.List" %>
<%@ page import="com.chuan.servlet.flight.bean.AccountBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - User Management</title>
</head>
<body>

<h2>Admin - User Management</h2>

    <%-- Get Accout List --%>
    <% List<AccountBean> accountList = (List<AccountBean>)request.getAttribute("accountList"); %>

    <table>
        <thead>
            <th>User Id</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role Id</th>
        </thead>
        <tbody>

                <%-- Loop the account list --%>
                <% for(AccountBean acc: accountList) { %>

                <tr>
                    <td><%= acc.getUId() %></td>
                    <td><%= acc.getUsername() %></td>
                    <td><%= acc.getPassword() %></td>
                    <td><%= acc.getRoleId() %></td>

                </tr>

                <% } %>

        </tbody>
    </table>



</body>
</html>
