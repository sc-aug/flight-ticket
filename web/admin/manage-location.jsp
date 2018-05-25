<%@ page import="com.chuan.servlet.flight.bean.LocationBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Location Management</title>
</head>
<body>

<h2>Admin - Location Management</h2>

<h3><a href="/AddLocationServlet">Add a Location</a></h3>

<%-- Get airplane list --%>
<% List<LocationBean> locationList = (List<LocationBean>)request.getAttribute("locationList"); %>

<table>
    <thead>
        <th>Location Id</th>
        <th>Location Name</th>
        <th>Timezone</th>
        <th>Edit</th>
        <th>Delete</th>
    </thead>
    <tbody>

    <%-- Loop the airplane list --%>
    <% for(LocationBean l: locationList) { %>

    <tr>
        <td><%= l.getLocationId() %></td>
        <td><%= l.getLocationName() %></td>
        <td><%= l.getTimezone() %></td>
        <td><a href="/EditLocationServlet?location_id=<%= l.getLocationId() %>">edit</a></td>
        <td><a href="/DeleteLocationServlet?location_id=<%= l.getLocationId() %>">delete</a></td>
    </tr>

    <% } %>

    </tbody>
</table>

</body>
</html>
