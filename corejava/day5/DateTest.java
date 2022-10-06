package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DateTest {
	DateFormat df=new SimpleDateFormat("dd-MMM-YYYY HH:mm:ss");

//	@Test
//	public void testDate() {
//		Date date=new Date(0);
//		System.out.println(date);
//		System.out.println(df.format(date));
//	}
//
//	
//    @Test
//     public void testDatewithCal() {
//    	Calendar cal= Calendar.getInstance();
//    	cal.set(Calendar.YEAR,1947);
//    	cal.set(Calendar.MONTH,7);
//    	cal.set(Calendar.DATE,15);
//    	java.util.Date date= cal.getTime();
//    	System.out.println(date);
//    	System.out.println(df.format(date));
//    }
    @Test
    public void testDateString() throws ParseException {
    	DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
    	java.util.Date date = df.parse("15-08-1947");
    	System.out.println(date);
    }
}
