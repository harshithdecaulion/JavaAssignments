package com.valtech.training.corejava.day5;

import java.util.Comparator;

public class StringSort implements Comparator<String> {

	
	@Override
	public int compare(String i1, String i2) {
		int m = i1.length();
		int n = i2.length();// we are fetching lengths to compare
		if (m < n) {
			return -1;
		}
		if (m > n) {
			return +1;
		} else {
			int a = vowelCount(i1);
			int b = vowelCount(i2); //we are fetching the vowel count to compare
			if (a < b) {
				return -1;
			}
			if (a > b) {
				return +1;
			}
			else {
				return i1.compareTo(i2);
			}

		}
	}

	public int vowelCount(String i) {
		String vowels = "AaEeIiOoUu";
		int count = 0;
		for (int j = 0; j < i.length(); j++) {
			char c = i.charAt(j);
			if (vowels.contains(""+c)) {//char to string
				count++;
			}

		}
		return count;

	}

}
