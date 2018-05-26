<%@ page import="java.util.List" %>
<%@ page import="com.chuan.servlet.flight.bean.AirplaneBean" %>
<%@ page import="com.chuan.servlet.flight.bean.LocationBean" %>
<%@ page import="com.chuan.servlet.flight.bean.FlightBean" %>
<%@ page import="com.chuan.servlet.flight.service.FlightService" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.Duration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Add Flight</title>
</head>
<body>

<%-- Get flight info --%>
<% FlightBean flight = (FlightBean)request.getAttribute("flight"); %>
<%-- Get airplane list --%>
<% List<AirplaneBean> airplaneList = (List<AirplaneBean>)request.getAttribute("airplaneList"); %>
<%-- Get location list --%>
<% List<LocationBean> locationList = (List<LocationBean>)request.getAttribute("locationList"); %>

<h2>Flight Add</h2>
<form action="/EditFlightServlet" method="post">

    Airplane
    <select name="airplane_id">

        <% for (AirplaneBean a: airplaneList) { %>

        <option value="<%= a.getAirplaneId()%>"
                <%= (a.getAirplaneId() == flight.getAirplaneId())? "selected" : ""%>>
            <%= a.getAirplaneName()%>
        </option>

        <% } %>

    </select>

    <br>

    Departure Location
    <select name="departure_loc_id">
        <% for (LocationBean l: locationList) { %>

        <option value="<%= l.getLocationId() %>"
                <%= (l.getLocationId() == flight.getDepartureLocId())? "selected" : ""%>>
            <%= l.getLocationName() + "\t" + l.getTimezone()%>
        </option>

        <% } %>
    </select>

    <br>

    Arrival Location
    <select name="arrival_loc_id">

        <% for (LocationBean l: locationList) { %>

        <option value="<%= l.getLocationId() %>"
                <%= (l.getLocationId() == flight.getArrivalLocId())? "selected" : ""%>>
            <%= l.getLocationName() + " " + l.getTimezone()%>
        </option>

        <% } %>
    </select>

    <br>

    <%
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        int dayChange = flight.getArrivalTime().getDayOfMonth() - flight.getDepartureTime().getDayOfMonth();
    %>

    Departure Time format: 14:20 <br>
    <input type="text" name="dep_time"
           value="<%= flight.getDepartureTime().format(formatter).substring(11,16)%>"> <br>

    Arrival Time: 14:20 <br>
    <input type="text" name="arr_time"
           value="<%= flight.getArrivalTime().format(formatter).substring(11,16)%>"> <br>

    <select name="day_change">

        <% for (int n = -2; n <= 2; n ++) { %>

        <option value="<%= n%>" <%= (n == dayChange)? "selected" : ""%>>
            <%= n %> days
        </option>

        <% }%>

    </select>

    <br>
    <input type="hidden" name="flight_id" value="<%= flight.getFlightId() %>">
    <input type="submit" value="edit flight">
</form>

</body>
</html>
