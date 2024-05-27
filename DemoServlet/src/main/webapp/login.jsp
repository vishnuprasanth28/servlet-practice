<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
        body {
    margin: 0;
    font-family: Arial, sans-serif;
}

header {
    background-color: #333;
    color: white;
    padding: 15px 0;
}

nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 20px;
}

.logo {
    font-size: 24px;
}

.nav-links {
    list-style-type: none;
    display: flex;
}

.nav-links li {
    margin-right: 20px;
}

.nav-links li a {
    color: white;
    text-decoration: none;
}

main {
    display: flex;
    justify-content: center;
    align-items: flex-start;
    padding: 40px 0;
}

.container {
    display: flex;
    justify-content: space-around;
    align-items: flex-start;
    width: 70%;
}

.admin-login,
.donor-login,
.need-blood {
    flex: 1;
    padding: 40px;
}

.admin-login,
.donor-login {
    background-color: #f9f9f9;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.admin-login h2,
.donor-login h2,
.need-blood h2 {
    margin-top: 0;
}

input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
}

button {
    padding: 10px 20px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #45a049;
}


.social-icons a {
    margin: 0 10px;
}

.social-icons img {
    width: 30px;
    height: 30px;
}


    </style>
</head>
<body>
  <header>
        <nav>
            <div class="logo">Blood Bank</div>
            <ul class="nav-links">
                <li><a href="#">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="index.jsp">Become A Donor</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="container">
            <div class="login-container admin-login">
            
                <h2>Admin Login</h2>
                <form action="Login" method="post">
                    <input type="text" name="Username" placeholder="Username">
                    <input type="password" name="Password" placeholder="Password">
                    <button type="submit">Login</button>
                </form>
            </div>
            <div class="login-container donor-login">
                <h2>Donor Login</h2>
                <form>
                    <input type="text" placeholder="Username">
                    <input type="password" placeholder="Password">
                    <button type="submit">Login</button>
                </form>
            </div>
            <div class="login-container need-blood">
                <h2>Need Blood</h2>
                <form>
                    <input type="text" placeholder="Name">
                    <input type="text" placeholder="Blood Type">
                    <input type="text" placeholder="Contact Number">
                    <button type="submit">Submit</button>
                </form>
            </div>
        </div>
    </main>

</body>
</html>