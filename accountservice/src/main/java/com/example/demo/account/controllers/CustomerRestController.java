package com.example.demo.account.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.account.entity.Customer;
import com.example.demo.account.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	
	@PostMapping("/api/customer/")
	public Customer createAccount( Customer cus) {
		return customerService.createAccount(cus);
	}

	
	@PutMapping("/api/customer/{id}")
	public Customer updateAccount( Customer cus) {
		return customerService.updateAccount(cus);
	}

	@GetMapping("/api/customer/{id}")
	public Customer getCustomer(long id) {
		return customerService.getCustomer(id);
	}

	@GetMapping("/api/customer/")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	
}
