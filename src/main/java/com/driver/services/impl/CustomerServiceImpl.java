package com.driver.services.impl;

import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.driver.model.Cab;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.CabRepository;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;
import com.driver.model.TripStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;
	
	@Autowired
	CabRepository cabRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		Customer customer = customerRepository2.getOne(customerId);
		customerRepository2.delete(customer);

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		
		List<Driver> driverList=driverRepository2.findAll();
		driverList.sort(Comparator.comparing(Driver::getDriverId));
		Customer customer = customerRepository2.getOne(customerId);
		
		for(Driver driver:driverList) {
			Cab cab = cabRepository2.findByDriver(driver);
			if(cab.getAvailable()) {
				cab.setAvailable(false);
				cabRepository2.save(cab);
				TripBooking trip = new TripBooking(fromLocation, toLocation,distanceInKm);
				trip.setStatus(TripStatus.CONFIRMED);
				trip.setCustomer(customer);
				trip.setCab(cab);
				trip.setBill(cab.getPerKmRate()*trip.getDistanceInKm());
				

				List<TripBooking> bookings=customer.getBookings();
				bookings.add(trip);
				customer.setBookings(bookings);
				trip = tripBookingRepository2.save(trip);
				return trip;
				
			}
		}
		
		throw new Exception("No cab available!");
	}
	

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking bookedTrip = tripBookingRepository2.getOne(tripId);
		Cab cab =bookedTrip.getCab();
		cab.setAvailable(true);
		bookedTrip.setStatus(TripStatus.CANCELED);
		cabRepository2.save(cab);
		tripBookingRepository2.save(bookedTrip);

	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking bookedTrip = tripBookingRepository2.getOne(tripId);
		Cab cab =bookedTrip.getCab();
		cab.setAvailable(true);
		bookedTrip.setStatus(TripStatus.COMPLETED);
		cabRepository2.save(cab);
		tripBookingRepository2.save(bookedTrip);

	}
}
