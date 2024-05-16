<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chainsys.servlet.Donor" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Donor Details</title>
</head>
<body>

<h1>Donor Details</h1>

<table border="1">
    <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Mobile Number</th>
            <th>Blood Group</th>
            <th>Location</th>
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<Donor> donorRegister = (ArrayList<Donor>) request.getAttribute("donorRegister");
        if (donorRegister != null) {
            for (Donor donor : donorRegister) {
        %>
        <tr>
            <td><%= donor.getDonorName() %></td>
            <td><%= donor.getAge() %></td>
            <td><%= donor.getMobileNumber() %></td>
            <td><%= donor.getBloodGrp() %></td>
            <td><%= donor.getLocation() %></td>
        </tr>
        <% 
            }
        } else {
        %>
        <tr>
            <td colspan="5">No donors found.</td>
        </tr>
        <% } %>
    </tbody>
</table>

</body>
</html>
