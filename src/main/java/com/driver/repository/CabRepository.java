package com.driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driver.model.Cab;
import com.driver.model.Driver;
import com.driver.model.TripBooking;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
	public Cab findByDriver(Driver driver);
	
}
