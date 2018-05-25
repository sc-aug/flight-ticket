<%@ page import="com.chuan.servlet.flight.bean.LocationBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Add Location</title>
</head>
<body>

<%-- get airplane by id --%>
<% LocationBean location = (LocationBean)request.getAttribute("location"); %>

<h2>Airplane Add</h2>

<form action="/EditLocationServlet" method="post">

    Location Name: <input type="text"
           value="<%= location.getLocationName() %>" name="location_name"> <br>
    Timezone (UTC): <input type="text"
           value="<%= location.getTimezone() %>" name="timezone"> <br>

    <input type="hidden" value="<%= location.getLocationId() %>" name="location_id">
    <input type="submit" value="edit">

</form>

</body>
</html>
