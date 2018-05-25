<%@ page import="com.chuan.servlet.flight.bean.AirplaneBean" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Edit Airplane</title>
</head>
<body>

    <%-- get airplane by id --%>
    <% AirplaneBean airplane = (AirplaneBean)request.getAttribute("airplane"); %>

    <h2>Airplane Edit</h2>

    <form action="/EditAirplaneServlet" method="post">

        Airplane ID: <%= airplane.getAirplaneId()%> <br>
        Airplane Name: <input type="text" value="<%= airplane.getAirplaneName()%>" name="airplane_name"> <br>
        First Class <input type="text" value="<%= airplane.getSeatFirst() %>" name="seat_first"> <br>
        Business <input type="text" value="<%= airplane.getSeatBusiness() %>" name="seat_business"> <br>
        Economy <input type="text" value="<%= airplane.getSeatEconomy() %>" name="seat_economy"> <br>

        <input type="hidden" value="<%= airplane.getAirplaneId()%>" name="airplane_id">
        <input type="submit" value="edit">

    </form>

</body>
</html>
