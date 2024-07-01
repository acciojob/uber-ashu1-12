package com.driver.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@Column(nullable = false, unique = true)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private LocalDate createdAt;
	
	
	
	public Admin() {
		this.createdAt = LocalDate.now();
	}


	public Admin(String userName, String password, String email, LocalDate createdAt) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.createdAt = LocalDate.now();
	}
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
	
}