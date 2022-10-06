package com.valtech.training.corejava.day4;

import javax.swing.plaf.synth.SynthStyle;

public enum Gender {

	
	MALE(2),FEMALE(1),OTHER(0);
	
	private int value;
	
	private Gender (int value) {
		this.value=value;
	}
	public static void main(String[] args) {
		for (Gender g : Gender.values()) {
			System.out.println(g+" "+g.getValue());
			
		}
		 System.out.println(Gender.MALE);
	}
	private Gender getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}
