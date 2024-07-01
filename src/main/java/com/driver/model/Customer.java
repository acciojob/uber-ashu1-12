package com.driver.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String mobile;
	
	@Column(nullable = false)
	private String password;
	
	private int age;
	
	@Column(nullable = false, unique = true)
	private String emailId;
	
	private String gender;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TripBooking> bookings = new ArrayList<>();

	public Customer() {
		
	}

	

	public Customer(String name, String mobile, String password, int age, String emailId, String gender) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.password = password;
		this.age = age;
		this.emailId = emailId;
		this.gender = gender;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	

	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<TripBooking> getBookings() {
		return bookings;
	}

	public void setBookings(List<TripBooking> bookings) {
		this.bookings = bookings;
	}



	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobile=" + mobile + ", password=" + password + ", age=" + age
				+ ", emailId=" + emailId + ", gender=" + gender + "]";
	}

	
	
	
	
}