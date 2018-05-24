<%@ page import="com.chuan.servlet.flight.bean.FlightBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Flight Management</title>
</head>
<body>

<h2>Admin - Flight Management</h2>

<%-- Get Accout List --%>
<% List<FlightBean> flightList = (List<FlightBean>)request.getAttribute("flightList"); %>

<table>
    <thead>
    <th>Flight Id</th>
    <th>Departure Time</th>
    <th>Arrival Time</th>
    <th>Departure City</th>
    <th>Arrival City</th>
    <th>Airplane</th>
    </thead>
    <tbody>

    <%-- Loop the account list --%>
    <% for(FlightBean f: flightList) { %>

    <tr>
        <td><%= f.getFlightId() %></td>
        <td><%= f.getDepartureTime() %></td>
        <td><%= f.getArrivalTime() %></td>
        <td><%= f.getDepartureCity() %></td>
        <td><%= f.getArrivalCity() %></td>
        <td><%= f.getAirplaneName() %></td>

    </tr>

    <% } %>

    </tbody>
</table>


</body>
</html>
