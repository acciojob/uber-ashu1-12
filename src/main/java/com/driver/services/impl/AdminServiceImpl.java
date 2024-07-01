package com.driver.services.impl;

import java.util.List;
import java.util.Optional;

import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Admin;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.AdminRepository;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository1;

	@Autowired
	DriverRepository driverRepository1;

	@Autowired
	CustomerRepository customerRepository1;

	@Override
	public void adminRegister(Admin admin) {
		//Save the admin in the database
		adminRepository1.save(admin);
	}

	@Override
	public Admin updatePassword(Integer adminId, String password) {
		//Update the password of admin with given id
		Optional<Admin> optionAdmin = adminRepository1.findById(adminId);
		if(optionAdmin.isEmpty()) {
			return optionAdmin.get();
		}
//		System.out.println("___________________________________________");	
//		System.out.println(optionAdmin.get());	
//		System.out.println("___________________________________________");	
		Admin admin = optionAdmin.get();
		admin.setPassword(password);
		return adminRepository1.save(admin);

	}

	@Override
	public void deleteAdmin(int adminId){
		// Delete admin without using deleteById function
		Admin admin=adminRepository1.getOne(adminId);
		adminRepository1.delete(admin);
	}

	@Override
	public List<Driver> getListOfDrivers() {
		List<Driver> driverList = driverRepository1.findAll();
		return driverList;
	}

	@Override
	public List<Customer> getListOfCustomers() {
		//Find the list of all customers
		List<Customer> customerList = customerRepository1.findAll();
		return customerList;
	}

}
