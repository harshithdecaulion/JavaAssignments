package com.valtech.training.corejava.day5;

import java.util.ArrayList;
import java.util.List;

public class CachedFactorial {
	
	List<Long> cache=new ArrayList<>();
	
	 public void dump() {
		 System.out.println();
	 }
		public long factorial(int n) {
			if(cache.size() >=n) {
				System.out.println("Returning from Cache....");
				return cache.get(n-1);
			}
			if(n==1) {
				cache.add(1L);
				return 1;
			}
			
			long fact=factorial(n-1);
			long factn=n*fact;
			cache.add(factn);
			return n* factorial(n-1);
				
			}
}