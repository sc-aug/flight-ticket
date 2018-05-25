<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Flight Ticket Booking System</h2>

<h3>Login</h3>

<form action="/LoginServlet" method="post">
    Username <input type="text" name="username">
    Password <input type="password" name="password">
    <input type="submit">
</form>

<a href="register.jsp">Register</a>
<a href="/index.html">Home</a>

</body>
</html>
