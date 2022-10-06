package com.valtech.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.OutputFilter;
import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class FirsttServlet
 */
public class FirsttServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirsttServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Integer count = (Integer)session.getAttribute("count");
		if (count==null) {
		session.setAttribute("count",1);
		count =1;
	}else {
		session.setAttribute("count",count+1);
	}
		ServletContext ctx= session.getServletContext();
		Integer globalCount = (Integer)ctx.getAttribute("count");
		if(globalCount==null) {
			ctx.setAttribute("count",1);
			globalCount=1;
		}else {
			ctx.setAttribute("count",globalCount+1);
		}
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Counter with http session");
		out.println("</title>");
		out.println("<body>");
		out.println("<h2>");
		out.println("First servlet <br/>");
		out.println(request.getAttribute("info"));
		out.println("You Have visited this page "+count+" times </br>");
		out.println("This site was visited "+globalCount+" times");
		out.println("</h2>");
		out.println("</head>");
		out.println("</html>");
	}
}
	

