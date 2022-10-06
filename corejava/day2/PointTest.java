package com.valtech.training.corejava.day2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.valtech.training.corejava.day1.Point;

/**
 * @author Harshith.V
 *
 */
public class PointTest {

	@Test
	
	    public void testEquals() {
		Point p=new Point(2,3);
		Point p1=new Point(2,3);
		Point p2=p;
		assertTrue(p==p2);
		assertFalse(p==p1);
		assertTrue(p.equals(p1));
		assertEquals(p.hashcode(),p1.hashcode());
	}
	public void testDistance() {
		Point p=new Point(0, 0);
		assertEquals(0.0,p.distance(),0.0000001);
		p=new Point(10,20);
		assertEquals(Math.sqrt(10*10+20*20),p.distance(),0.0000001);
	}	
	public void testSetGet() {
		Point p=new Point (0, 0);
		p.setX(10);
		assertEquals(10, p.getX());
		p.setY(20);
		assertEquals(20, p.getY());
			
		}
	
	public void testPointCtor() {
		Point p=new Point(0, 0);
			assertEquals(0,p.getX());
			assertEquals(0,p.getY());
			
			Point p1 = new Point(2,3);
			assertEquals(2, p1.getX());
			assertEquals(3, p1.getX());
	}

}
