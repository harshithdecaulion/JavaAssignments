package com.valtech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
	
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Loading oracle driver");
		//Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	
	public static final String TABLE_NAME="employees";
	
	public int getNextIntValid()throws Exception{
		Connection con= getConnection();
		PreparedStatement ps=con.prepareStatement("select max(id) from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		int id=-1;
		if(rs.next()) {
			id=rs.getInt(1);
		}
		con.close();
		return id+1;
		}
	
	
	public int getNextId(int currId)throws Exception{
		int id=-1;
		Connection cin=getConnection();
		PreparedStatement ps=cin.prepareStatement("select id from "+TABLE_NAME+" where id > ? fetch next 1 row only");
		ps.setInt(1, currId);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) id=rs.getInt(1);
		cin.close();
		return id;
	}
	
	public int getPreviousId(int currId)throws Exception {
		int id=-1;
		Connection cin=getConnection();
		PreparedStatement ps=cin.prepareStatement("select max(id) from "+TABLE_NAME+" where id < ?  fetch next 1 row only");
		ps.setInt(1, currId);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) id=rs.getInt(1);
		cin.close();
		return id;

	}
	public int getFirstId()throws Exception {
		Connection con= getConnection();
		PreparedStatement ps=con.prepareStatement("select min(id) from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		int id=-1;
		if(rs.next()) {
			id=rs.getInt(1);
		}
		con.close();
		return id;
		}
	
	public int getLastId()throws Exception {
		Connection con= getConnection();
		PreparedStatement ps=con.prepareStatement("select max(id) from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		int id=-1;
		if(rs.next()) {
			id=rs.getInt(1);
		}
		con.close();
		return id;
		}
	
	
	
	public int  count() throws Exception {
		Connection con=getConnection();
		Statement st=con.createStatement();
		ResultSet rs =st.executeQuery("Select count(id) from "+ TABLE_NAME);
		if(rs.next())	{
			int count=rs.getInt(1);
			con.close();
			return count;
		}
		else {
			con.close();
			return -1;
		}
	}
	
	public void saveEmployee(Employees e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps= con.prepareStatement("INSERT into "+TABLE_NAME+ " (id,name,age,gender,salary) values (?,?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setInt(3, e.getAge());
		ps.setInt(4, e.getGender());
		ps.setDouble(5, e.getSalary());
		
		int rowsAffected=ps.executeUpdate();
		con.close();
		
		
	}
	
	
	public Employees getEmployee(int id)throws Exception {
		Connection conn=getConnection();
		PreparedStatement ps=conn.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
		Employees e = employeeFromResultSet(rs);//refactor and made new private methord
		conn.close();
		return e;
		}
		else {
			return null;
		}
		
		
	}

	private Employees employeeFromResultSet(ResultSet rs) throws SQLException {
		Employees e = new Employees();
		e.setId(rs.getInt(1));
		//e.setId(id);
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setGender(rs.getInt(4));
		e.setSalary(rs.getFloat(5));
		return e;
	}
	
	
	public List<Employees> getEmployees()throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+ " order by id");
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	
	public void deleteEmployee(int id)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from "+TABLE_NAME+ " where id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		con.close();
	}
	
	
	
	public void updateEmployee(Employees emp)throws Exception{
		Connection con=getConnection();
	 PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME+ " Set name = ? ,age = ? ,gender = ? ,salary = ?  Where id = ? ");
		// PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME+ " age = ?  Where id = ?");
	       ps.setInt(5, emp.getId());
	       ps.setString(1, emp.getName());
	       ps.setInt(2, emp.getAge());
	       ps.setInt(3, emp.getGender());
	       ps.setFloat(4, emp.getSalary());
		 //  ps.setObject(3, emp);
		
//		
//		 PreparedStatement ps=con.prepareStatement("Update "+ TABLE_NAME+ " Set age = ?  Where id = ?");
//		 ps.setInt(1, emp.getId());
//	       ps.setInt(3, emp.getAge());
		
	        int affected=ps.executeUpdate();
	        con.close();
	}
	
	public List<Employees> getEmployeesByAge(int age)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where age = "+age);
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	public List<Employees> getEmployeesBtwAge(int minage,int maxage)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where age between "+minage+" and "+maxage);
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	public List<Employees> getEmployeesSalGT(float sal)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where salary > "+sal);
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	public List<Employees> getEmployeesSalGTEQ(float sal)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where salary >=  "+sal);
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	
	public List<Employees> getEmployeesSalLT(float sal)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where salary < "+sal);
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	public List<Employees> getEmployeesSalLTEQ(float sal)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where salary <=  "+sal);
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	
	public List<Employees> getEmployeesGenM()throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where gender = 1 ");
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	public List<Employees> getEmployeesGenF()throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where gender = -1 ");
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	
	public List<Employees> getEmployeesGenO()throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("Select id,name,age,gender,salary from "+TABLE_NAME+" where gender = 0 ");
		ResultSet rs=ps.executeQuery();
		List<Employees> employees=new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
			
		}
		con.close();
		return employees;
	}
	
	
	
	public Connection getConnection()throws Exception {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.102.38:1521/xe","valtrg19","valtrg19");
	//	return DriverManager.getConnection("jdbc:mysql:@localhost:3306/xe","username","password");
	}

}
