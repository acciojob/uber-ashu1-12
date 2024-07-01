package com.driver.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Driver{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	
	
	
	@Column(nullable = false, unique = true)
	private String mobile;
	
	@Column(nullable = false)
	private String password;
	
	
	@OneToOne(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
	Cab cab;

	
	public Driver() {
		
	}


	public Driver(String mobileNo, String password) {
		super();
		this.mobile = mobileNo;
		this.password = password;
	}


	public int getDriverId() {
		return driverId;
	}


	public void setDriverId(int id) {
		this.driverId = id;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobileNo) {
		this.mobile = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Cab getCab() {
		return cab;
	}


	public void setCab(Cab cab) {
		this.cab = cab;
	}


	@Override
	public String toString() {
		return "Driver [id=" + driverId + ", mobile=" + mobile + ", password=" + password + "]";
	}


	
	
	
}