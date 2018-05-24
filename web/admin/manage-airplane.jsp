<%@ page import="com.chuan.servlet.flight.bean.AirplaneBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Airplane Management</title>
</head>
<body>

<h2>Admin - Airplane Management</h2>

<h3><a href="">Add a Airplane</a></h3>

<%-- Get airplane list --%>
<% List<AirplaneBean> airplaneList = (List<AirplaneBean>)request.getAttribute("airplaneList"); %>

<table>
    <thead>
    <th>Airplane Id</th>
    <th>Airplane Name</th>
    <th>Edit</th>
    <th>Delete</th>
    </thead>
    <tbody>

    <%-- Loop the airplane list --%>
    <% for(AirplaneBean a: airplaneList) { %>

    <tr>
        <td><%= a.getAirplaneId() %></td>
        <td><%= a.getAirplaneName() %></td>
        <td><a href="/EditAirplaneServlet?airplane_id=<%= a.getAirplaneId() %>">edit</a></td>
        <td><a href="/DeleteAirplaneServlet?airplane_id=<%= a.getAirplaneId() %>">delete</a></td>
    </tr>

    <% } %>

    </tbody>
</table>

</body>
</html>
