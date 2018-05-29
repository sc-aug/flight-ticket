<%@ page import="com.chuan.servlet.flight.bean.ScheduleBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Flight Scheduling</title>
</head>
<body>

<h2>Admin - Flight Scheduling</h2>

<h3><a href="/AddScheduleServlet">Add a schedule</a></h3>

<%-- Get Schedule List --%>
<% List<ScheduleBean> scheduleList = (List<ScheduleBean>)request.getAttribute("scheduleList"); %>



<table>
    <thead>
    <th>Schedule Id</th>
    <th>Status</th>
    <th>Flight Id</th>
    <th>Airplane Name</th>
    <th>Departure Time</th>
    <th>Arrival Time</th>
    <th>First Class</th>
    <th>Business</th>
    <th>Economy</th>
    <th>Edit</th>
    <th>Delete</th>
    </thead>
    <tbody>

    <%-- time format --%>
    <% DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm"); %>
    <%-- Loop the account list --%>
    <% for(ScheduleBean s: scheduleList) { %>

    <tr>
        <td><%= s.getScheduleId() %></td>
        <td><%= s.getStatusName() %></td>
        <td><%= s.getFlightId() %></td>
        <td><%= s.getAirplaneName() %></td>
        <td><%= s.getDepartureTime().format(formatter) %></td>
        <td><%= s.getArrivalTime().format(formatter) %></td>
        <td><%= s.getAvailableSeatsFirst() %></td>
        <td><%= s.getAvailableSeatsBusiness()%></td>
        <td><%= s.getAvailableSeatsEconomy() %></td>
        <td><a href="/EditFlightServlet?schedule_id=<%= s.getScheduleId() %>">edit</a></td>
        <td><a href="/DeleteFlightServlet?schedule_id=<%= s.getScheduleId() %>">delete</a></td>
    </tr>

    <% } %>

    </tbody>
</table>









</body>
</html>
