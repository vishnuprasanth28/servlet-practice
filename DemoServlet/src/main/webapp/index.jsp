<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<%
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
if (session.getAttribute("admin")==null) {
    response.sendRedirect("login.jsp");
    return;
}
String admin = null;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("admin".equals(cookie.getName())) {
                admin = cookie.getValue();
                break;
            }
        }
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
        
        body {
            font-family: Arial, sans-serif;
            background-color: #7197aa;

            background-repeat: no-repeat ;
            background-size: cover;
            
        }
        .container{
            display: flex;
            flex-direction:column;
            justify-content: start;
            margin-left:30% ;
        }
        form {
            
            max-width: 300px;
            /* margin: 20px auto; */
            padding: 20px;
            background-color: #c8d2d2;
            transition: background-color 0.6s ease;
            
        
        }
        form:hover{
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
 <h2><%= admin %> </h2>
    <form action="TestServlet" >
    
 
        <h2>Registration Form</h2>
        <label for="name">Donor name</label>
        <input type="text" id="name" placeholder=" your name" name="name" required>

       
        
       
        <br><br>
        <label for="age">Age</label>
        <input type="text" id="age" name="age" pattern="[1-9]{2}" required>

        <br>
        <br>

        <label for="mobileNumber">Mobile Number:</label>
        <input type="text" id="mobileNumber" name="mobileNumber"  placeholder="enter 10-digit phone number " required>
    
        <br><br>
       
    
        <label for="bloodGrp">Blood group</label>
        <input type="text" id="bloodGrp" placeholder="bloodGrp" name="bloodGrp" required>
        <br><br>
        <label for="location">Location</label>
        <input type="text" id="location" placeholder="location" name="location" required>
        <br><br>
        
        <input type="reset"value="Reset">

        <br>
        <br>
        <div>
         <input type="checkbox" name="Terms&Condition" checked />
            <label>Terms & Conditions</label>
          </div>
       
        <br>
        <input type="submit" value="Register">
    </form>
     
    	<form action="LogOutServlet" method="post">
    <input type="submit" value="Logout">
</form>

    
    
    </div> 
</body>
</html>