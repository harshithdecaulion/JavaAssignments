package com.example.demo.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.account.entity.Account;
import com.example.demo.account.service.AccountService;

@RestController
public class AccountRestControllers {

	@Autowired
	private AccountService accountservice;

	@GetMapping("api/accounts/SB/")
	public Account createSavingsAccount(@RequestParam("balance") double balance) {
		return accountservice.createSavingsAccount(balance);
	}
	@GetMapping("api/accounts/CA/")
	public Account createCurrentAccount(@RequestParam("balance") double balance) {
		return accountservice.createCurrentAccount(balance);
	}

}
