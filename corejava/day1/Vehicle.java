package com.valtech.training.corejava.day1;

public abstract class Vehicle {
	
	public  void start() {
	System.out.println("Start button is pressed.....");
	}
	
	public  void stop() {
		System.out.println("Stop button is pressed....");
	}
	 
	public abstract void accelerate();
	
	public abstract void applybrakes();
	
	public void driveSomeDistance () {
		start();
		stop();
		accelerate();
		applybrakes();
	}
	

	public static void main(String[] args) {
		Vehicle es = new ElectricScooter();
		es.driveSomeDistance();
	}
}
