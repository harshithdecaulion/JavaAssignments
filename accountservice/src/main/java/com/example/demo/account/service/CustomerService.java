package com.example.demo.account.service;

import java.util.List;

import com.example.demo.account.entity.Customer;

public interface CustomerService {

	Customer createAccount(Customer cus);

	Customer updateAccount(Customer cus);

	Customer getCustomer(long id);

	List<Customer> getAllCustomers();

}