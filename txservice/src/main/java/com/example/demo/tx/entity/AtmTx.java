package com.example.demo.tx.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("txa")
public class AtmTx extends Tx {

	private int atmno;
	private String location;
	
	public AtmTx (){}
	

	public AtmTx(int atmno, String location) {
		this.atmno = atmno;
		this.location = location;
	}


	public int getAtmno() {
		return atmno;
	}

	public void setAtmno(int atmno) {
		this.atmno = atmno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
