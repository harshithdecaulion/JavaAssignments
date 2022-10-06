package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class StringSortTest {
//
//	@Test
//	public void testLength() {
//		String [] str1={"Hi","Hey","How","Hello","Why"};
//		Arrays.sort(str1, new StringSort());
//		assertArrayEquals(new String[] {"Hi","Hey","How","Why","Hello"},str1);
//	}
//
//
//

			@Test
			public void testVowel() {
				
				String[]names= {"Nuthan","Manijj","Sai","Sanjayguptha"};
				Arrays.sort(names,new StringSort());
			
				assertArrayEquals(new String [] {"Sai","Manijj","Nuthan","Sanjayguptha"},names);
			}
}