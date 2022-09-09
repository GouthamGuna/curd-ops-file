package com.cerp.example.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class EditEmployeeAction extends GenericServlet{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String dbDriver=null,dbURL=null,dbUser=null,dbPassword=null;
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");
		
		try {
			EmployeesVo obj=new EmployeesVo();
			
			ServletContext context=getServletContext();
			
			dbDriver=context.getInitParameter("dbDriver");
			dbURL=context.getInitParameter("dbURL");
			dbUser=context.getInitParameter("dbUser");
			dbPassword=context.getInitParameter("dbPassword");
			
			String primaryId=req.getParameter("id");
			
			Class.forName(dbDriver);
			
			conn=DriverManager.getConnection(dbURL, dbUser, dbPassword);
			pstmt=conn.prepareStatement("select * from `addemployee` where id=?");
			pstmt.setString(1, primaryId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				obj.setPrimaryId(rs.getString("id"));
				obj.setEmpId(rs.getString("empid"));
				obj.setEmpname(rs.getString("empname"));
				obj.setEmpsalary(rs.getString("empsalary"));
			}
			
			res.setContentType("text/html");  
	        PrintWriter out=res.getWriter();  
	        out.println("<h1>Update Employee</h1>");  
	        out.println("<form action='updateemployee'>");  
	        out.println("<input type='hidden' name='primaryId' value='"+obj.getPrimaryId()+"'/>");
	        out.println("<input type='text' name='empid' value='"+obj.getEmpId()+"' placeholder='empId' required='required'/>");
	        out.println("<input type='text' name='empname' value='"+obj.getEmpname()+"' placeholder='empName' required='required'/>");
	        out.println("<input type='text' name='empsalary' value='"+obj.getEmpsalary()+"' placeholder='empSalary' required='required'/>");
	        out.println("<button>Update</button> <input type='reset' value='Reset'/> <button onclick='history.back()'>Go Back</button>");
	        out.close(); 
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.print("<div>Duplicate Entry Employee ID</div>");
			out.print("<hr>");
			out.print("<button onclick='history.back()'>Go Back</button>");
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
