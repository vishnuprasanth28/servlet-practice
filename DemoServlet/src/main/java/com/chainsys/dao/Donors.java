package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.Donor;
import com.chainsys.util.ConnectionUtil;

public class Donors {
	ArrayList<Donor> donorRegister= new ArrayList<>();
	Donor donor=  new Donor();
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
	
	public ArrayList<Donor> listOfDonors() throws SQLException, ClassNotFoundException {
	    ArrayList<Donor> donorRegister = new ArrayList<>(); 
	    Connection connection = null;
	    PreparedStatement prepareStatement = null;
	    ResultSet donorSet = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = ConnectionUtil.getConnection();
	        
	        String donorList = "select id,donor_name,age,blood_group,location,mobile from donor_list";
	        prepareStatement = connection.prepareStatement(donorList);
	        donorSet = prepareStatement.executeQuery();
	        
	        while (donorSet.next()) {
	            Donor donor = new Donor(); 
	            donor.setId(donorSet.getInt("id"));
	            donor.setDonorName(donorSet.getString("donor_name"));
	            donor.setAge(donorSet.getInt("age"));
	            donor.setBloodGrp(donorSet.getString("blood_group"));
	            donor.setMobileNumber(donorSet.getString("mobile"));
	            donor.setLocation(donorSet.getString("location"));
	            
	            donorRegister.add(donor); 
	        }
	    } finally {
	        
	        if (donorSet != null) {
	            donorSet.close();
	        }
	        if (prepareStatement != null) {
	            prepareStatement.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }
	    return donorRegister;
	}

	public void deleteDonor(int id) throws ClassNotFoundException, SQLException {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection connection = ConnectionUtil.getConnection();
		 String delete = "delete from donor_list where id= "+id;
		 PreparedStatement prepareStatement = connection.prepareStatement(delete);
		 int row = prepareStatement.executeUpdate();
		 System.out.println("Affected row :"+row);
	        
		
	}
	public void updateDonor(Donor donor) throws ClassNotFoundException, SQLException {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection connection = ConnectionUtil.getConnection();
		 String update = "update donor_list set donor_name=?,location=?,mobile=? where id=?" ;
		 PreparedStatement prepareStatement = connection.prepareStatement(update);
         prepareStatement.setString(1, donor.getDonorName());
         prepareStatement.setString(2, donor.getLocation());
         prepareStatement.setString(3, donor.getMobileNumber());
         prepareStatement.setInt(4, donor.getId());
         int row = prepareStatement.executeUpdate();
         System.out.println("updated :"+row);
	
}
	public ArrayList<Donor> searchByBloodGrp(String bloodGroup) throws ClassNotFoundException, SQLException {
		 ArrayList<Donor> donorRegister = new ArrayList<>(); 
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection connection = ConnectionUtil.getConnection();
		 String update = "select id,donor_name,age,blood_group,location,mobile from donor_list where blood_group like ?";
		 PreparedStatement prepareStatement = connection.prepareStatement(update);
		 prepareStatement.setString(1, "%" + bloodGroup + "%");
		ResultSet resultSet= prepareStatement.executeQuery();
		 while (resultSet.next()) {
			 
	            Donor donor = new Donor(); 
	            donor.setId(resultSet.getInt("id"));
	            donor.setDonorName(resultSet.getString("donor_name"));
	            donor.setAge(resultSet.getInt("age"));
	            donor.setBloodGrp(resultSet.getString("blood_group"));
	            donor.setMobileNumber(resultSet.getString("mobile"));
	            donor.setLocation(resultSet.getString("location"));
	            
	            donorRegister.add(donor); 
	        }
		 return donorRegister;
	}
}
