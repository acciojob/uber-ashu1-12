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
	
	private String pickUp;
	
	private String destination;
	
	@Enumerated(EnumType.STRING)
	private TripStatus tripStatus;
	
	private int toatDistance;
	
	private double totalFare;
	
	@CreationTimestamp
	private Date bookedDate;
	
	//Driver driver;
	
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


	public TripBooking(String pickUp, String destination,
			int toatDistance) {
		
		
		this.pickUp = pickUp;
		this.destination = destination;
		this.toatDistance = toatDistance;
	}


//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}


	public int getTripBookingId() {
		return tripbookingId;
	}


	public void setTripBookingId(int tripbookingId) {
		this.tripbookingId = tripbookingId;
	}


	public String getPickUp() {
		return pickUp;
	}


	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public TripStatus getTripStatus() {
		return tripStatus;
	}


	public void setTripStatus(TripStatus tripStatus) {
		this.tripStatus = tripStatus;
	}


	public double getToatDistance() {
		return toatDistance;
	}


	public void setToatDistance(int toatDistance) {
		this.toatDistance = toatDistance;
	}


	public double getTotalFare() {
		return totalFare;
	}


	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}


	public Date getBookedDate() {
		return bookedDate;
	}


	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
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
	
	
}