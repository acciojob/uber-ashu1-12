package com.driver.services.impl;

import com.driver.model.Cab;
import com.driver.repository.CabRepository;
import com.driver.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Driver;
import com.driver.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepository3;

	@Autowired
	CabRepository cabRepository3;
	
	int count=1;

	@Override
	public void register(String mobile, String password){
		//Save a driver in the database having given details and a cab with ratePerKm as 10 and availability as True by default.
		Driver driver=new Driver(mobile, password);
		driver.setDriverId(count);
		Cab cab = new Cab(10, true);
		cab.setId(count);
		count++;
		driver.setCab(cab);
		cab.setDriver(driver);
		
		driverRepository3.save(driver);
//		cabRepository3.save(cab);

	}

	@Override
	public void removeDriver(int driverId){
		// Delete driver without using deleteById function
		Driver driver = driverRepository3.getOne(driverId);
		driverRepository3.delete(driver);

	}

	@Override
	public void updateStatus(int driverId){
		//Set the status of respective car to unavailable
		Driver driver = driverRepository3.getOne(driverId);
		Cab cab = cabRepository3.findByDriver(driver);
		cab.setAvailable(false);
		cabRepository3.save(cab);
	}
}
