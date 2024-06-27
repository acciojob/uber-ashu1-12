package com.driver.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cab{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@Column(nullable = false, unique = true)
//	private String cabNumber;
//	
//	private String cabType;
	
	@Column(nullable = false)
	private double farePerKm;
	
	
	@Column(nullable = false)
	private boolean isAvailable = true;
	
	@OneToOne
	@JoinColumn
	@JsonIgnore 
	Driver driver;
	
	@OneToOne(mappedBy = "cab", cascade = CascadeType.ALL, orphanRemoval = true)
	TripBooking tripBooking;
	
	public Cab() {
		
	}

	public Cab( double farePerKm, boolean isAvailable) {
		
//		this.cabNumber = cabNumber;
//		this.cabType = cabType;
		this.farePerKm = farePerKm;
		this.isAvailable = isAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public double getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	

	public TripBooking getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(TripBooking tripBooking) {
		this.tripBooking = tripBooking;
	}

	@Override
	public String toString() {
		return "Cab [id=" + id + ",farePerKm=" + farePerKm
				+ ", isAvailable=" + isAvailable + "]";
	}

	
	
	
	
	
	
}