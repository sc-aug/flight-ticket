<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>Flight Ticket Booking System</h2>

<h3>Register</h3>

<form action="/RegisterServlet" method="post">
    <label for="username">Username</label>
    <input type="text" id="username" name="username">
    <label for="password">Password</label>
    <input type="password" id="password" name="password">
    <input type="submit" value="Register">
</form>

<a href="login.jsp">Login</a>
<a href="/index.html">Home</a>

</body>
</html>
