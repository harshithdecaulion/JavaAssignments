package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import org.junit.Test;

public class CachedFactorialTest {

	@Test
	public void test() {
		CachedFactorial cf=new CachedFactorial();
		assertEquals(120, cf.factorial(5));
		assertEquals(5040, cf.factorial(7));
	}

}
