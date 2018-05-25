<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Add Airplane</title>
</head>
<body>

<h2>Airplane Add</h2>

<form action="/AddAirplaneServlet" method="post">

    Airplane Name: <input type="text" value="" name="airplane_name"> <br>
    First Class <input type="text" value="" name="seat_first"> <br>
    Business <input type="text" value="" name="seat_business"> <br>
    Economy <input type="text" value="" name="seat_economy"> <br>

    <input type="hidden" value="-1" name="airplane_id">
    <input type="submit" value="add">

</form>

</body>
</html>
