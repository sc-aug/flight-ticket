<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Add Location</title>
</head>
<body>

<h2>Airplane Add</h2>

<form action="/AddLocationServlet" method="post">

    Location Name: <input type="text" value="" name="location_name"> <br>
    Timezone (UTC): <input type="text" value="" name="timezone"> <br>

    <input type="submit" value="add">

</form>

<hr>

<a href="https://time.is/UTC" target="_blank">Check UTC Timezone</a>

</body>
</html>
