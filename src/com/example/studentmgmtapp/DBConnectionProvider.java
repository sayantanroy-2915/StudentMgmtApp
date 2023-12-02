package com.example.studentmgmtapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionProvider {
	
	public static Connection createConnection() {
		
		Connection conn = null;
		
		try {
			
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			String user = "root";
			String pswd = "root";
			String url = "jdbc:mysql://localhost:3306/student_mgmt";
			
			// Create the connection
			conn = DriverManager.getConnection(url, user, pswd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
