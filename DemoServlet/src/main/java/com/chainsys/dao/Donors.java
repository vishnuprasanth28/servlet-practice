package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.Donor;
import com.chainsys.util.ConnectionUtil;

public class Donors {
	ArrayList<Donor> donorRegister= new ArrayList<>();
	public void addDonor(Donor donor) {
		
		donorRegister.add(donor);
		System.out.println(donorRegister);
		 
	}
	public ArrayList<Donor> getDonorRegister() {
        return donorRegister;
    }
	public void registerDonor(Donor donor) throws SQLException, ClassNotFoundException {

		 Connection connection = null;
	        PreparedStatement prepareStatement = null;
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = ConnectionUtil.getConnection();

	            String register = "insert into donor_list(donor_name, age, blood_group, location, mobile) values(?,?,?,?,?)";
	            prepareStatement = connection.prepareStatement(register);
	            prepareStatement.setString(1, donor.getDonorName());
	            prepareStatement.setInt(2, donor.getAge());
	            prepareStatement.setString(3, donor.getBloodGrp());
	            prepareStatement.setString(4, donor.getLocation());
	            prepareStatement.setString(5, donor.getMobileNumber());

	            int rows = prepareStatement.executeUpdate();
	            System.out.println("Added : " + rows);
	        } finally {
	            if (prepareStatement != null) {
	                prepareStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }
}

