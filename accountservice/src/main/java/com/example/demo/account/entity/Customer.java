package com.example.demo.account.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="customers")


public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String mobile;
	private LocalDateTime birthDate;
	private String address;
	private String customerType;
	private int pincode;
	 @ManyToMany(targetEntity = Account.class,cascade={CascadeType.MERGE,CascadeType.PERSIST},mappedBy ="customers")
	    private Set<Account> account;
	    public Set<Account> getAccount() {
	        return account;
	    }
	    public void setAccount(Set<Account> account) {
	        this.account = account;
	    }
	
	public Customer (){}

	public Customer(int id, String name, String email, String mobile, LocalDateTime birthDate, String address,
			String customerType, int pincode) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}

	public Customer(String name, String email, String mobile, LocalDateTime birthDate, String address, String customerType,
			int pincode) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
}
