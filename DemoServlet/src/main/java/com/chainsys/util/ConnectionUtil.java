package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {	
	 public static Connection getConnection() throws ClassNotFoundException, SQLException {
	      
	      // Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db_1", "root", "Mechatronics@1");

	        return connection;
	    }

}
 