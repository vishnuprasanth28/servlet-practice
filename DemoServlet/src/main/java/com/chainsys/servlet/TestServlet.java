package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.dao.Donors;
import com.chainsys.model.Donor;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Donors donors=new Donors();
	Donor donor = new Donor();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name=request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		String Mobile=request.getParameter("mobileNumber");
		String bloodGroup=request.getParameter("bloodGrp");
		String city=request.getParameter("location");
		donor.setDonorName(name);
		donor.setAge(age);
		donor.setBloodGrp(bloodGroup);
		donor.setMobileNumber(Mobile);
		donor.setLocation(city);
		// donors.addDonor(donor);
		 try {
			donors.registerDonor(donor);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// request.setAttribute("donorRegister", donors.getDonorRegister());
		 try {
			request.setAttribute("donorRegister", donors.listOfDonors());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    String name = request.getParameter("name");
	    String phoneNo = request.getParameter("mobileNumber");
	    String location = request.getParameter("location");

	    if (action != null) {
	        switch (action) {
	            case "delete":
	                try {
	                    int idToDelete = Integer.parseInt(request.getParameter("deleteid"));
	                    Donors donors = new Donors();
	                    donors.deleteDonor(idToDelete);
	                } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
	                    e.printStackTrace();
	                    
	                }
				try {
				
					request.setAttribute("donorRegister", donors.listOfDonors());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	                request.getRequestDispatcher("home.jsp").forward(request, response);
	                break;
	            case "update" :
	            	try {
	            		Donors donors = new Donors();
						donor.setDonorName(name);
						donor.setMobileNumber(phoneNo);
						donor.setLocation(location);
	                    int idToUpdate = Integer.parseInt(request.getParameter("updateid"));
	                    donor.setId(idToUpdate);
	                    donors.updateDonor(donor);
	                } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
	                    e.printStackTrace();
	                    
	                }
				try {
					request.setAttribute("donorRegister", donors.listOfDonors());
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	                request.getRequestDispatcher("home.jsp").forward(request, response);
	                break;
	            	
	        }
	    }
	}


}
