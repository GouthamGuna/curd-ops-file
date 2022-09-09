package com.cerp.example.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class DeleteEmployeeAction extends GenericServlet{
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	String dbDriver=null,dbURL=null,dbUser=null,dbPassword=null;
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("delete");
		
		try {
			String status="failure";
			RequestDispatcher rd=null;
			ServletContext context=getServletContext();
			
			dbDriver=context.getInitParameter("dbDriver");
			dbURL=context.getInitParameter("dbURL");
			dbUser=context.getInitParameter("dbUser");
			dbPassword=context.getInitParameter("dbPassword");
			
			String primaryId=req.getParameter("id"); 
			
			Class.forName(dbDriver);
			
			conn=DriverManager.getConnection(dbURL, dbUser, dbPassword);
			pstmt=conn.prepareStatement("delete from `addemployee` where id=?");
			pstmt.setString(1, primaryId);
			System.err.println(pstmt);
			int flag=pstmt.executeUpdate();
			
			if(flag>0) {
				status="success";
			}
			
			if(status == "success") {
				rd=req.getRequestDispatcher("/viewemployee");
				
				rd.forward(req, res);
			}else {
				rd=req.getRequestDispatcher("addemployee.html");
				
				rd.forward(req, res);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			out.print("<div>Duplicate Entry Employee ID</div>");
			out.print("<hr>");
			out.print("<button onclick=\"history.back()\">Go Back</button>");
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
