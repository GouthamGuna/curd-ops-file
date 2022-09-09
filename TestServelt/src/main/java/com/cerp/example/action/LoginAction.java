package com.cerp.example.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class LoginAction extends GenericServlet{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String dbDriver=null,dbURL=null,dbUser=null,dbPassword=null;
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service");
		
		try {
			int count=0;
			RequestDispatcher rd=null;
			
			ServletContext context=getServletContext();
			
			dbDriver=context.getInitParameter("dbDriver");
			dbURL=context.getInitParameter("dbURL");
			dbUser=context.getInitParameter("dbUser");
			dbPassword=context.getInitParameter("dbPassword");
			
			String username=req.getParameter("username");
			System.out.println(username);
			
			String password=req.getParameter("password");
			System.out.println(password);
			
			Class.forName(dbDriver);
			
			conn=DriverManager.getConnection(dbURL, dbUser, dbPassword);
			pstmt=conn.prepareStatement("SELECT COUNT(*) FROM `user` WHERE `username`=? AND `password`=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				count=rs.getInt(1);
			}
			
			if(count > 0) {
				rd=req.getRequestDispatcher("/viewemployee");
			}else {
				rd=req.getRequestDispatcher("index.html");
			}
			
			rd.forward(req, res);
			
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
