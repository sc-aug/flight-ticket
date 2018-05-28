<%@ page import="java.util.List" %>
<%@ page import="com.chuan.servlet.flight.bean.FlightBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Add Schedule</title>
</head>
<body>

<%-- Get airplane list --%>
<% List<FlightBean> flightList = (List<FlightBean>)request.getAttribute("flightList"); %>

<h2>Add Schedule</h2>
<form action="/AddScheduleServlet" method="post">

    Flight
    <select name="flight_id">
        <option disabled selected value> -- select airplane -- </option>

        <% for (FlightBean f: flightList) { %>

        <option value="<%= f.getFlightId() %>" >
            <%= f.getAirplaneName() + " depart:" + f.getDepartureLoc() + " arrive:" + f.getArrivalLoc()%>
        </option>

        <% } %>

    </select>

    <br>

    Departure <br>
    Date: <input type="datetime-local" name="departure_time">

    <br>
    <input type="submit" value="add flight">
</form>

</body>
</html>
