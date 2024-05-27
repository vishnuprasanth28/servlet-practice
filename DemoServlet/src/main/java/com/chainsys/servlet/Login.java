package com.chainsys.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dao.Donors;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userName = request.getParameter("Username");
	    int passWord = Integer.parseInt(request.getParameter("Password"));
	    Donors donors = new Donors();
	    
	    try {
	        if (donors.adminLogin(userName, passWord)) {
	        	 HttpSession session = request.getSession();
	        	 Cookie cookie=new Cookie("admin", userName);
	        	  session.setAttribute("admin", userName);
	        	response.addCookie(cookie);
	            response.sendRedirect("index.jsp");
	        } else {
	            
	            response.sendRedirect("login.jsp");
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        
	        e.printStackTrace();
	    }   
	}

}
