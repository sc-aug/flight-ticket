<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Add Account</title>
</head>
<body>

<h2>Account Edit</h2>

<form action="/AddAccountServlet" method="post">

    Username <input type="text" value="" name="username"> <br>
    Password <input type="text" value="" name="password"> <br>
    Role Id <input type="numeric" value="" name="role_id"> <br>

    <input type="submit" value="edit">

</form>

</body>
</html>
