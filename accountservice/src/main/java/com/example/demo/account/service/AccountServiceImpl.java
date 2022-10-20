package com.example.demo.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.account.entity.Account;
import com.example.demo.account.repo.AccountRepsitory;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepsitory accountRepository;
	
	@Override
	public Account createAccount(Account acc){
		return accountRepository.save(acc);
		
	}
	@Override
	public Account updateAccount(Account acc){
		return accountRepository.save(acc);
		
	}
	@Override
	public Account getAccount(Long id){
		return accountRepository.findById(id).get();
	}
	@Override
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}
	@Override
	public Account createSavingsAccount(double balance) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account createCurrentAccount(double balance) {
		// TODO Auto-generated method stub
		return null;
	}
}
