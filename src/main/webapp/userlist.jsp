<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.advjava.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h2>User List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>CheckIn</th>
            <th>CheckOut</th>
        </tr>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            if (users != null) {
                for (User user : users) {
        %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getCheckIn() %></td>
                <td><%= user.getCheckOut() %></td>
            </tr>
        <%
                }
            }
        %>
    </table>

    <h2>Add User</h2>
    <form action="user-list" method="post">
        <input type="hidden" name="action" value="addUser">
        Username: <input type="text" name="name" required>
        Email: <input type="email" name="email" required>
        Email: <input type="checkIn" name="checkin" required>
        Email: <input type="checkOut" name="checkout" required>
        Email: <input type="roomType" name="roomType" required>
        <button type="submit">Add User</button>
    </form>
</body>
</html>
