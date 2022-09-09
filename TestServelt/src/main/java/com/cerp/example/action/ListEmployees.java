package com.cerp.example.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class ListEmployees extends GenericServlet{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String dbDriver=null,dbURL=null,dbUser=null,dbPassword=null;
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");

		try {
			ArrayList<EmployeesVo> list=new ArrayList<EmployeesVo>();
			ServletContext context=getServletContext();
			
			dbDriver=context.getInitParameter("dbDriver");
			dbURL=context.getInitParameter("dbURL");
			dbUser=context.getInitParameter("dbUser");
			dbPassword=context.getInitParameter("dbPassword");
					
			Class.forName(dbDriver);
			
			conn=DriverManager.getConnection(dbURL, dbUser, dbPassword);
			pstmt=conn.prepareStatement("SELECT `id`,`empid`,`empname`,`empsalary` FROM `addemployee`");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EmployeesVo obj=new EmployeesVo();
				
				obj.setPrimaryId(rs.getString("id"));
				obj.setEmpId(rs.getString("empid"));
				obj.setEmpname(rs.getString("empname"));
				obj.setEmpsalary(rs.getString("empsalary"));

				list.add(obj);
			}
			
			res.setContentType("text/html");  
	        PrintWriter out=res.getWriter();  
	        out.println("<h1>Employee Registration</h1>");  
	        out.println("<button onclick=window.location.href='addemployee.html'>Add</button>");  
	        out.println("<h2>List of Employee's</h2>");  
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>SL No.</th><th>Employee Id</th><th>Employee Name</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>");  
	        int i=0;
	        for(EmployeesVo e:list){  
	         out.print("<tr>"
	         		+ "<td>"+(++i)+"</td>"
	         		+ "<td>"+e.getEmpId()+"</td>"
	         		+ "<td>"+e.getEmpname()+"</td>"
	         		+ "<td>"+e.getEmpsalary()+"</td>"
	         		+ "<td><a href='editemployee?id="+e.getPrimaryId()+"'>Edit</a></td>"
	         		+ "<td><a href='deleteemployee?id="+e.getPrimaryId()+"'>Delete</a></td>"
	         	+ "</tr>");  
	        }  
	        out.print("</table>");  
	          
	        out.close();  
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public void destroy() {
		System.out.println("destroy");
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
