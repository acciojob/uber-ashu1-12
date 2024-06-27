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
	private int id;
	
	
	
	@Column(nullable = false, unique = true)
	private String mobileNo;
	
	@Column(nullable = false)
	private String password;
	
	@OneToOne(mappedBy = "driver", cascade = CascadeType.ALL, orphanRemoval = true)
	Cab cab;

	
	public Driver() {
		
	}


	public Driver(String mobileNo, String password) {
		super();
		this.mobileNo = mobileNo;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
		return "Driver [id=" + id + ", mobileNo=" + mobileNo + ", password=" + password + ", cab=" + cab + "]";
	}
	
	
}