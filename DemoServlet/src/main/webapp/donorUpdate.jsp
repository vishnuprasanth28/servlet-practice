<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Donor Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #7197aa;
        background-repeat: no-repeat;
        background-size: cover;
    }

    .container {
        display: flex;
        flex-direction: column;
        justify-content: start;
        margin-left: 30%;
    }

    form {
        max-width: 300px;
        padding: 20px;
        background-color: #c8d2d2;
        transition: background-color 0.6s ease;
    }

    form:hover {
        background-color: #f7e73f;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        padding: 10px 20px;
        border-radius: 4px;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<div class="container">
    <form action="TestServlet" method="post">
        <h2>Edit Donor Details</h2>
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
        
        <label for="name">Donor name</label>
        <input type="text" id="name" placeholder="Your name" name="name"  required>
        
       
        
        <br><br>
        <label for="mobileNumber">Mobile Number:</label>
        <input type="text" id="mobileNumber" name="mobileNumber" placeholder="Enter 10-digit phone number"  required>
        
      
        <br><br>
        <label for="location">Location</label>
        <input type="text" id="location" placeholder="Location" name="location" " required>
        
        <br><br>
         <input type="hidden" name="action" value="update">
         <input type="hidden" name="updateid" value= "<%= request.getParameter("updateid")%>">
         <button type="submit" > Update</button>
    </form>
</div>

</body>
</html>
