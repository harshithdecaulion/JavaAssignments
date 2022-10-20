package com.example.demo.account.service;

import java.util.List;

import com.example.demo.account.entity.Account;

public interface AccountService {

	Account createAccount(Account acc);

	Account updateAccount(Account acc);

	Account getAccount(Long id);

	List<Account> getAllAccounts();

	Account createSavingsAccount(double balance);

	Account createCurrentAccount(double balance);


}