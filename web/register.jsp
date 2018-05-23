<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

Register

<form action="RegisterServlet" method="post">
    <label for="username">Username</label>
    <input type="text" id="username" name="username">
    <label for="password">Password</label>
    <input type="password" id="password" name="password">
    <input type="submit" value="Register">
</form>

</body>
</html>
