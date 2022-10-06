package com.valtech.dao;

public class Employees {
	private int Id;
	private String Name;
	private int Age;
	private int Gender;
	private float Salary;
	public int getId() {
		return Id;
	}
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employees(int id, String name, int age, int gender, float salary) {
		super();
		this.Id = id;
		this.Name = name;
		this.Age = age;
		this.Gender = gender;
		this.Salary = salary;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		this.Age = age;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		this.Gender = gender;
	}
	public float getSalary() {
		return Salary;
	}
	public void setSalary(float salary) {
		this.Salary = salary;
	}

}
