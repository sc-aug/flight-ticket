<%@ page import="com.chuan.servlet.flight.bean.AirplaneBean" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Edit Airplane</title>
</head>
<body>

    <h2>Airplane Edit</h2>

    <%-- get airplane by id --%>
    <% AirplaneBean airplane = (AirplaneBean)request.getAttribute("airplane"); %>

    <h3>Airplane Info</h3>

    <input type="hidden" value="<%= airplane.getAirplaneId()%>" name="airplane_id">

    Airplane ID: <%= airplane.getAirplaneId()%> <br>
    Airplane Name: <%= airplane.getAirplaneName()%> <br>

    <hr>

    <form action="/EditAirplaneServlet" method="post">

        <h3>Airplane Info Edit</h3>

        Airplane Name: <input type="text" value="<%= airplane.getAirplaneName()%>" name="airplane_name"> <br>

        <input type="submit" value="edit">

        <h3>Airplane Seat Edit</h3>


        <ul>
            <% for (Map.Entry<Integer, Integer> e: airplane.getSeat().entrySet()) {%>

            <li>
                <%= e.getKey() + " " + e.getValue() %>
            </li>

            <% }%>
        </ul>

    </form>

</body>
</html>
