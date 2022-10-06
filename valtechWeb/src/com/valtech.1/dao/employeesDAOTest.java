package com.valtech.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class employeesDAOTest {

	@Test
	public void test()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		Connection conn=dao.getConnection();
		conn.close();
	}
	
	
//	@Test
//	public void testCount()throws Exception {
//		EmployeeDAO DAO=new EmployeeDAO();
//		assertEquals(7, dao.count());
//	}
	
//	@Test
//	public void testSaveEmployee()throws Exception {
//		EmployeeDAO DAO=new EmployeeDAO();
//		int count=dao.count();
//		dao.saveEmployee(new Employee(108,"raju",25,1,10000));
//		assertEquals(count+1, dao.count());
//		dao.deleteEmployee(108);
//		assertEquals(count, dao.count());
//		
//	}
	
	
	@Test
	public void testGetEmployee()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		Employees e=dao.getEmployee(101);
		assertEquals(101, e.getId());
		assertEquals(21, e.getAge());
	}
	
	@Test 
	public void testGetEmployees()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(dao.count(), dao.getEmployees().size());
	}
	
	
//	@Test 
//	public void testDeleteEmployee()throws Exception {
//		EmployeeDAO DAO=new EmployeeDAO();
//  	     dao.deleteEmployee(id);
//  	     int count=dao.count();
//	    assertEquals(count, dao.count());
//	}
//	
	
	
//	@Test
//    public void testupdate() throws Exception {
//        EmployeeDAO DAO = new EmployeeDAO();
//        Employee e=dao.getEmployee(105);
//        dao.updateEmployee(e);
//        assertEquals(21, e.getAge());
//        
//	
//	}
	
	
	
	@Test
  public void testupdateEmployee() throws Exception {
      EmployeesDAO dao = new EmployeesDAO();
      dao.updateEmployee(new Employees(001,"Harsh",12,1,12121));
      Employees e=dao.getEmployee(001);
      assertEquals(e.getId(),001);
      assertEquals( e.getName(),"rajuu");
      assertEquals(12, e.getAge());
       assertEquals(1, e.getGender());
      assertEquals(12121, e.getSalary(),0.000001);
      
	
	}

	@Test 
	public void testGetEmployeesByAge()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(3, dao.getEmployeesByAge(21).size());
	}
	
	@Test 
	public void testGetEmployeesBtwAge()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(5, dao.getEmployeesBtwAge(21,22).size());
	}
	
	
	@Test 
	public void testGetEmployeesSalGT()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(1, dao.getEmployeesSalGT(50000).size());
	}
	
	
	@Test 
	public void testGetEmployeesSalGTEQ()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(3, dao.getEmployeesSalGTEQ(50000).size());
	}
	
	
	@Test 
	public void testGetEmployeesSalLT()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(1, dao.getEmployeesSalLT(50000).size());
	}
	
	
	@Test 
	public void testGetEmployeesSalLTEQ()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(4, dao.getEmployeesSalLTEQ(50000).size());
	}
	
	@Test 
	public void testGetEmployeesGenM()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(5, dao.getEmployeesGenM().size());
	}
	
	@Test 
	public void testGetEmployeesGenF()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(0, dao.getEmployeesGenF().size());
	}
	
	@Test 
	public void testGetEmployeesGenO()throws Exception {
		EmployeesDAO dao=new EmployeesDAO();
		assertEquals(0, dao.getEmployeesGenO().size());
	}
	
	

}
