package com.valtech.training.corejava.day2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.valtech.training.corejava.day1.Point;

public class PointSetTest {
	@Test
	public void testTreeSet() {
		Set<Point> points = new TreeSet<>();
		points.add(new Point(2,3));
		assertEquals(1, points.size());
		points.add(new Point(2,3));
		assertEquals(1, points.size());
		points.add(new Point(3,3));
		assertEquals(2, points.size());
	}
	@Test
	public void testSetOfPoints() {
		Set<Point> points = new HashSet<>();
		points.add(new Point(2,3));
		assertEquals(1, points.size());
		points.add(new Point(2,3));
		assertEquals(1, points.size());
		}
	
	
	@Test
	public void testSetOfStringsWithGenerics() {
		Set<String> myWords= new HashSet<>();
		myWords.add("Hello");
		myWords.add("How");
		myWords.add("Are");
		myWords.add("You");
//		myWords.add(23);
		
	}

	@Test
	public void testSetOfStrings() {
		Set setOfStrings = new HashSet();
		setOfStrings.add("Hello");
		assertEquals(1, setOfStrings.size());
		setOfStrings.add("Hello");
		assertEquals(1, setOfStrings.size());
		setOfStrings.add("HEllo");
		assertEquals(2, setOfStrings.size());
//		System.out.println(setOfStrings);
		for (Iterator iterator = setOfStrings.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
					String s= (String)object;
					System.out.println(s);
		}
	}

}
