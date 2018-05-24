<%@ page import="com.chuan.servlet.flight.bean.SeatTypeBean" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: chuan
  Date: 5/24/18
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin - Seat Type Management</title>
</head>
<body>

<h3><a href="">Add a seat type</a></h3>

<%-- Get Accout List --%>
<% List<SeatTypeBean> seatTypeList = (List<SeatTypeBean>)request.getAttribute("seatTypeList"); %>

<table>
    <thead>
    <th>Seat Type Id</th>
    <th>Seat Type Name</th>
    <th>Edit</th>
    <th>Delete</th>
    </thead>
    <tbody>

    <%-- Loop the account list --%>
    <% for(SeatTypeBean s: seatTypeList) { %>

    <tr>
        <td><%= s.getSeatTypeId() %></td>
        <td><%= s.getSeatTypeName() %></td>
        <td><a href="/EditSeatTypeServlet?seat_type_id=<%= s.getSeatTypeId() %>">edit</a></td>
        <td><a href="/DeleteSeatTypeServlet?seat_type_id=<%= s.getSeatTypeId() %>">delete</a></td>
    </tr>

    <% } %>

    </tbody>
</table>

</body>
</html>
