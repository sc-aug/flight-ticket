<%@ page import="com.chuan.servlet.flight.bean.FlightBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
        isELIgnored="true"%>
<html>
<head>
    <title>Admin - Flight Management</title>
</head>
<body>

<h2>Admin - Flight Management</h2>

<h3><a href="/AddFlightServlet">Add a flight</a></h3>

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
        <th>Edit</th>
        <th>Delete</th>
    </thead>
    <tbody>

    <%-- time format --%>
    <% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMdd HH:mm"); %>
    <%-- Loop the account list --%>
    <% for(FlightBean f: flightList) { %>

    <tr>
        <td><%= f.getFlightId() %></td>
        <td><%= f.getDepartureTime().format(formatter) %></td>
        <td><%= f.getArrivalTime().format(formatter) %></td>
        <td><%= f.getDepartureLoc() %></td>
        <td><%= f.getArrivalLoc() %></td>
        <td><%= f.getAirplaneName() %></td>
        <td><a href="/EditFlightServlet?flight_id=<%= f.getFlightId() %>">edit</a></td>
        <td><a href="/DeleteFlightServlet?flight_id=<%= f.getFlightId() %>">delete</a></td>
    </tr>

    <% } %>

    </tbody>
</table>


</body>
</html>
