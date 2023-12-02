package com.example.studentmgmtapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDBService {
	
	private Connection conn;
	private final String table;
	
	public StudentDBService() {
		super();
		// Get connection
		conn = DBConnectionProvider.createConnection();
		table = "STUDENTS";
	}

	public boolean insertStudentToDB(Student stu) {
		
		boolean f = false;
		try {
			// Create query to insert
			String q = "INSERT INTO "+table+"(NAME,CITY,STREAM,YEAR,PHONE,EMAIL) VALUES (?,?,?,?,?,?)";
			// Create PreparedStatement
			PreparedStatement ps = conn.prepareStatement(q);
			// Set the value of parameters
			ps.setString(1, stu.getName());
			ps.setString(2, stu.getCity());
			ps.setString(3, stu.getStream());			
			ps.setString(4, stu.getYear());
			ps.setString(5, stu.getPhone());
			ps.setString(6, stu.getEmail());
			// Execute the query
			ps.executeUpdate();
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Student> fetchStudentsFromDB(String field, String value) {
		
		List<Student> studentList = new ArrayList<>();
		try {
			ResultSet rs;
			if (field.equals("") && value.equals("")) {
				String q = "SELECT * FROM "+table;
				Statement s = conn.createStatement();
				rs = s.executeQuery(q);
			}
			else if (field.equalsIgnoreCase("id")) {
				String q = "SELECT * FROM "+table+" WHERE ID = ?";
				PreparedStatement ps = conn.prepareStatement(q);
				ps.setInt(1,Integer.parseInt(value));
				rs = ps.executeQuery();
			}
			else if (field.equalsIgnoreCase("name") || field.equalsIgnoreCase("city") ||
					field.equalsIgnoreCase("stream") || field.equalsIgnoreCase("year") ||
					field.equalsIgnoreCase("phone") || field.equalsIgnoreCase("email")) {
				String q = "SELECT * FROM "+table+" WHERE "+field.toUpperCase()+" LIKE ?";
				PreparedStatement ps = conn.prepareStatement(q);
				ps.setString(1, "%"+value+"%");
				rs = ps.executeQuery();
			}
			else {
				throw new Exception("Unknown column name: "+field);
			}
			while(rs.next()) {
				studentList.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getString("city"),
						rs.getString("stream"),rs.getString("year"),rs.getString("phone"),rs.getString("email")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}
	
	public boolean updateStudentInDB(int id, String field, String value) {
		
		boolean f = false;
		try {
			if (field.equalsIgnoreCase("name") || field.equalsIgnoreCase("city") ||
				field.equalsIgnoreCase("stream") || field.equalsIgnoreCase("year") ||
				field.equalsIgnoreCase("phone") || field.equalsIgnoreCase("email")) {
				String q = "UPDATE "+table+" SET "+field.toUpperCase()+" = ? WHERE ID = ?";
				PreparedStatement ps = conn.prepareStatement(q);
				ps.setString(1, value);
				ps.setInt(2, id);
				ps.executeUpdate();
				f = true;
			}
			else {
				throw new Exception("Unknown column name: "+field);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteStudentFromDB(int id) {
		
		boolean f = false;
		try {
			String q = "DELETE FROM "+table+" WHERE ID = ?";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, id);
			ps.executeUpdate();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean close() {
		boolean f = false;
		try {
			conn.close();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
}
