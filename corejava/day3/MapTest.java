package com.valtech.training.corejava.day3;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import com.valtech.training.corejava.day1.Point;

public class MapTest {

	@Test
	public void testHashMap() {
		Map<String,Point> points=new HashMap<>();
		points.put("1,1", new Point(1,1));
		points.put("1,2", new Point(1,1));
		points.put("2,2", new Point(2,2));
		points.put("1,2", new Point(1,1));
		assertEquals(3,points.size());
		for(Map.Entry<String,Point> point : points.entrySet()) {
			String key = point.getKey();
			Point val = point.getValue();
			System.out.println("Key "+key+" Value"+points.get(key));
		}
	}

}
