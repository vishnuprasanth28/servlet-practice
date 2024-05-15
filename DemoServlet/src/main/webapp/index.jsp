<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <form  action="TestServlet" method="post">
            <table border="1" bgcolor="A9A9A9">
              
                <tr>
                    <th>Enter your name : </th>
                    <td><input type="text" name="name" value=""></td>
                </tr>
                  <tr>
                    <th>Enter Phone number : </th>
                    <td><input type="number" name="mobile" value=""></td>
                </tr>
                <tr>
                    <th>Enter your age</th>
                    <td><input type="number" name="age" value=""></td>
                </tr>
                   <tr>
                    <th>Enter your blood group</th>
                    <td><input type="text" name="blood" value=""></td>
                </tr>
                </table>
                <table>
                
                    <tr>
                        <td><input type="submit" name="submit" value="Insert"></td>
                        
                    </tr>
                 
                
            </table>
        </form>
 
</body>
</html>