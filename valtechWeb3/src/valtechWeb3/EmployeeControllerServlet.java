package valtechWeb3;

import java.io.IOException;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.xa.XAException;

import com.valtech.dao.Employees;
import com.valtech.dao.EmployeesDAO;

@WebServlet(urlPatterns= {"/empCtlr"})

public class EmployeeControllerServlet extends HttpServlet {

	 private  EmployeesDAO dao;

	 
	 @Override
	public void init() throws ServletException {
		 dao=new EmployeesDAO();
	 }
	
	 

	 @Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String submit = req.getParameter("submit");
		 try {
			 if("New Employee".equals(submit)) {
				 req.getRequestDispatcher("createEmps.jsp").forward(req, resp);
			 	return;
		 }
		 if("Save".equals(submit)) {
			 Employees e=new Employees();
			 e.setId(dao.getNextIntValid());
			 e.setName(req.getParameter("name"));
			 e.setAge(Integer.parseInt(req.getParameter("age")));
			 e.setGender(Integer.parseInt(req.getParameter("gender")));
			 e.setSalary(Integer.parseInt(req.getParameter("salary")));
			 dao.saveEmployee(e);
			 
			 
		 }	 
		 if("Update Employee".equals(submit)) {
			 req.getRequestDispatcher("update.jsp").forward(req, resp);
		 	return;
		 }
		 if("Update".equals(submit)) {
			 Employees e=new Employees();
			 e.setId(Integer.parseInt(req.getParameter("id")));
			 e.setName(req.getParameter("name"));
			 e.setAge(Integer.parseInt(req.getParameter("age")));
			 e.setGender(Integer.parseInt(req.getParameter("gender")));
			 e.setSalary(Integer.parseInt(req.getParameter("salary")));
			 dao.updateEmployee(e);
			 
			 
		 }	 
		req.setAttribute("emps",dao.getEmployees());
		req.getRequestDispatcher("emps.jsp").forward(req, resp);
		 }catch(Exception ex) {
			 throw new RuntimeException(ex);
		 }
	 }
	 @Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // login here and forward to JSP page
//		 try {
//			 String empId = req.getParameter("empId");
//			 String submit=req.getParameter("submit");
//			 
//			 
//			 if (empId == null) {
//				 List<Employees> emps = dao.getEmployees();
//				 req.setAttribute("emps", emps);
//				 req.getRequestDispatcher("emps.jsp").forward(req, resp);
//				 return;            
//			 }
//			 
//			 int id = Integer.parseInt(req.getParameter("empId"));
//			 if("delete".equals("submit")) {
//				 dao.deleteEmployee(id);
//				 List<Employees> emps = dao.getEmployees();
//				 req.setAttribute("emps", emps);
//				 req.getRequestDispatcher("emps.jsp").forward(req, resp);
//				 return;
//			 }
//				 Employees e = dao.getEmployee(id);
//			 req.setAttribute("e", e);
//			 req.getRequestDispatcher("emp.jsp").forward(req, resp);;
//		 } catch (Exception ex) {
//			 throw new RuntimeException(ex);
//		 }
//	 }
//}

		 try {
             String empId= req.getParameter("empId");
             String submit=req.getParameter("submit");
             
             
             if(empId==null){
                          List<Employees> emps=dao.getEmployees();
                             req.setAttribute("emps", emps);
                             req.getRequestDispatcher("emps.jsp").forward(req, resp);
                             return;
                                             
         }
             int id = Integer.parseInt(req.getParameter("empId"));
             if("delete".equals(submit)) {
                 dao.deleteEmployee(id);
                 List<Employees> emps=dao.getEmployees();
                 req.setAttribute("emps", emps);
                 req.getRequestDispatcher("emps.jsp").forward(req, resp);
                 return;
             }
             Employees e= dao.getEmployee(id);
             req.setAttribute("e", e);
             req.getRequestDispatcher("emp.jsp").forward(req, resp);;
         }catch (Exception ex) {
             throw new RuntimeException(ex);
         }
}
}