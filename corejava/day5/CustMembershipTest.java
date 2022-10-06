package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class CustMembershipTest {
	
	
    
    //Customer cu= new Customer();
	
	int Diamond=4;
	int Platinum =3;
	int gold=2;
	int silver=1;
	@Test
	public void test() throws Exception {
		// SimpleDateFormat df =new SimpleDateFormat("dd-MM-yyyy");
		Set<CustMembership> cust= new TreeSet<CustMembership>();
		
		CustMembership cus1= new CustMembership("Harshith",gold,"2001-05-28",23000);
		CustMembership cus2= new CustMembership("Archith",gold,"2001-02-02",23000);
  	    CustMembership cus3= new CustMembership("Pradeek",Diamond,"2000-02-02",5400);
        CustMembership cus4= new CustMembership("Chris Gayle",Platinum,"1980-09-10",54000);
    
		
		cust.add(cus1);
		cust.add(cus2);
  	    cust.add(cus3);
  	    cust.add(cus4);

  	    
  	    
		
		 System.out.println(cust.size()+" Customer Data");
		for(CustMembership c : cust) {
			System.out.println(c.name+" "+convert_to_string(c.type)+" "+c.date+" "+c.moneyspent);
		}
		
//		 LocalDate currdate1= LocalDate.parse("2001-09-25");
//		   int month1= currdate1.getMonthValue();
//		   int year1=currdate1.getYear();
//		   System.out.println(month1);
//		   System.out.println(year1);
			
		
		
	}
	
	public String convert_to_string (int t1) {
		switch (t1) {
		case 1:
			  return "Silver";
		
		case 2:
			  return "Gold";
		
		case 3:
			  return "Paltinum";
			
		case 4:
			  return "Diamond";
			

		default:
			return "0";
		
		}
	}

}
