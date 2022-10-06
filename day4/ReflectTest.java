package com.valtech.training.corejava.day4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.valtech.training.corejava.day1.Point;

import oracle.net.aso.m;

public class ReflectTest {

	@Test
	public void test() {
		Point p= Point.class.newInstance();
		System.out.println(p);
		Point.class.getMethod("setX", Integer.class);
		m.invoke(p,10);
		System.out.println(p);
	}

}
