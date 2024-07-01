package com.driver.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TripBooking{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tripbookingId;
	
	private String fromLocation;
	
	private String toLocation;
	
	@Enumerated(EnumType.STRING)
	private TripStatus status;
	
	private int distanceInKm;
	
	private double bill;
	
	@CreationTimestamp
	private Date bookedDate;
	
	@OneToOne
	@JoinColumn
	@JsonIgnore
	Driver driver;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	Customer customer;
	
	@OneToOne
	@JoinColumn
	@JsonIgnore
	Cab cab;
	
	

	
	public TripBooking() {
		
	}


	

	public TripBooking(String fromLocation, String toLocation, int distanceInKm) {
		super();
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.distanceInKm = distanceInKm;
	}


	public int getTripBookingId() {
		return tripbookingId;
	}
	public void setTripBookingId(int bookingId) {
		this.tripbookingId= bookingId;
	}

	public String getFromLocation() {
		return fromLocation;
	}


	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}


	public String getToLocation() {
		return toLocation;
	}


	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}


	public int getDistanceInKm() {
		return distanceInKm;
	}


	public void setDistanceInKm(int distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public TripStatus getStatus() {
		return status;
	}


	public void setStatus(TripStatus tripStatus) {
		this.status = tripStatus;
	}


	public double getBill() {
		return bill;
	}




	public void setBill(double bill) {
		this.bill = bill;
	}




	public Date getBookedDate() {
		return bookedDate;
	}


	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	
	public Driver getDriver() {
		return driver;
	}




	public void setDriver(Driver driver) {
		this.driver = driver;
	}




	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Cab getCab() {
		return cab;
	}


	public void setCab(Cab cab) {
		this.cab = cab;
	}




	@Override
	public String toString() {
		return "TripBooking [tripbookingId=" + tripbookingId + ", fromLocation=" + fromLocation + ", toLocation="
				+ toLocation + ", tripStatus=" + status + ", distanceInKm=" + distanceInKm + ", bill=" + bill
				+ ", bookedDate=" + bookedDate + ", customer=" + customer + ", cab=" + cab + "]";
	}
	
	
}