<%@ page import="java.util.List" %>
<%@ page import="com.chuan.servlet.flight.bean.AirplaneBean" %>
<%@ page import="com.chuan.servlet.flight.bean.LocationBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Add Flight</title>
</head>
<body>

<%-- Get airplane list --%>
<% List<AirplaneBean> airplaneList = (List<AirplaneBean>)request.getAttribute("airplaneList"); %>
<%-- Get location list --%>
<% List<LocationBean> locationList = (List<LocationBean>)request.getAttribute("locationList"); %>

<h2>Flight Add</h2>
<form action="/AddFlightServlet" method="post">

    Airplane
    <select name="airplane_id">
        <option disabled selected value> -- select airplane -- </option>

        <% for (AirplaneBean a: airplaneList) { %>

        <option value="<%= a.getAirplaneId()%>" >
            <%= a.getAirplaneName()%>
        </option>

        <% } %>

    </select>

    <br>

    Departure Location
    <select name="departure_loc_id">
        <option disabled selected value> -- select departure -- </option>

        <% for (LocationBean l: locationList) { %>

        <option value="<%= l.getLocationId() %>" >
            <%= l.getLocationName() + "\t" + l.getTimezone()%>
        </option>

        <% } %>
    </select>

    <br>

    Arrival Location
    <select name="arrival_loc_id">
        <option disabled selected value> -- select arrival -- </option>

        <% for (LocationBean l: locationList) { %>

        <option value="<%= l.getLocationId() %>" >
            <%= l.getLocationName() + " " + l.getTimezone()%>
        </option>

        <% } %>
    </select>

    <br>

    Departure Time format: 14:20 <br>
    <input type="text" name="dep_time"> <br>

    Arrival Time: 14:20 <br>
    <input type="text" name="arr_time">

    <select name="day_change">
        <option value="-2">back 2 days</option>
        <option value="-1">back 1 days</option>
        <option selected value="0">on same day</option>
        <option value="1">after 1 days</option>
        <option value="2">after 2 days</option>
    </select>

    <br>
    <input type="submit" value="add flight">
</form>

</body>
</html>
