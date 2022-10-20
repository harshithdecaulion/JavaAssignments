package com.example.demo.account.entity;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="accounts")



public class Account {
	
	public static final String SAVINGS= "SB";
	public static final String CURRENT= "CA";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String accountType;
	private double balance;
	private LocalDateTime dateOfCreation;
	private LocalDateTime lastUpdatedDate;
	private boolean active;
	@ManyToMany(targetEntity = Customer.class, cascade = { CascadeType.MERGE,
            CascadeType.PERSIST })
    @JoinTable(name="customer_account",joinColumns = @JoinColumn(name="account_id",referencedColumnName="id"),
    inverseJoinColumns = @JoinColumn(name="customer_id",referencedColumnName="id"))
    
    private Set<Customer> customers;
	public Account(){}

	public Account(long id, String accountType, double balance, LocalDateTime dateOfCreation, LocalDateTime lastUpdatedDate,
			boolean active) {
		this.id = id;
		this.accountType = accountType;
		this.balance = balance;
		this.dateOfCreation = dateOfCreation;
		this.lastUpdatedDate = lastUpdatedDate;
		this.active = active;
	}

	public Account( String accountType, double balance) {
		this.accountType = accountType;
		this.balance = balance;
		this.dateOfCreation = LocalDateTime.now();
		this.lastUpdatedDate = LocalDateTime.now();
		this.active = false;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDateTime dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
