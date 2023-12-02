package com.example.studentmgmtapp;

/**
 * Model Class
 */
public class Student {
	private int id;
	private String name;
	private String city;
	private String stream;
	private String year;
	private String phone;
	private String email;
	
	public Student() {
		super();
	}
	
	public Student(String name, String city, String stream, String year, String phone, String email) {
		super();
		this.name = name;
		this.city = city;
		this.stream = stream;
		this.year = year;
		this.phone = phone;
		this.email = email;
	}
	
	public Student(int id, String name, String city, String stream, String year, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.stream = stream;
		this.year = year;
		this.phone = phone;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", stream=" + stream + ", year=" + year
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	
}
