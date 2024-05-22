<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chainsys.model.Donor" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Donor Details</title>
      <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        button {
            padding: 5px 10px;
            cursor: pointer;
            border: none;
            background-color: #007bff;
            color: white;
            border-radius: 3px;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h1>Donor Details</h1>

<table border="1">
    <thead>
        <tr>
        	<th>SI.No</th>
            <th>Name</th>
            <th>Age</th>
            <th>Mobile Number</th>
            <th>Blood Group</th>
            <th>Location</th>
        </tr>
    </thead>
    <tbody>
        <% 
        int i=0;
        ArrayList<Donor> donorRegister = (ArrayList<Donor>) request.getAttribute("donorRegister");
        if (donorRegister != null) {
            for (Donor donor : donorRegister) {
        %>
        <tr>
        	<td><%= donor.getId() %></td>
            <td><%= donor.getDonorName() %></td>
            <td><%= donor.getAge() %></td>
            <td><%= donor.getMobileNumber() %></td>
            <td><%= donor.getBloodGrp() %></td>
            <td><%= donor.getLocation() %></td>
            <td>
             <form action="TestServlet" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="deleteid" value="<%=donor.getId() %>">
                        <button type="submit">Delete</button>
                    </form></td>
                  <td>
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="updateid" value="<%=donor.getId() %>">
                        <button type="submit" onclick="location.href= 'donorUpdate.jsp?updateid=<%=donor.getId() %>'">Update</button>
                  </td>
        </tr>
       <% }} %>
    </tbody>
   
</table>


</body>
</html>
