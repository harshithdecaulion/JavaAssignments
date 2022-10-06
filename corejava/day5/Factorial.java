package com.valtech.training.corejava.day5;

public class Factorial {

	
			public long fact(long n) {
				//if n is 1 then return 1,if not

		 if(n==1) {
			 return n;
		 }
		 return n*fact(n-1);
		 
		 }

			
			public static void main(String[] args) {
				
				
			}
}




