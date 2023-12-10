package com.web.resort.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.resort.dao.UserDaoImpl;
import com.web.resort.entity.User;

	@WebServlet("/login")
	public class LoginController extends HttpServlet
	{
		public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			res.setContentType("text.html");
			PrintWriter out=res.getWriter();
			
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			try
			{
				User user=new User();
				UserDaoImpl userDao=new UserDaoImpl();
				user.setEmail(email);
				user.setPassword(password);
				req.getRequestDispatcher(userDao.validateUser(user)).forward(req,res);
			}
			catch(ClassNotFoundException e)
			{
				out.println(e);
			}
			catch(SQLException e) 
			{
				out.println(e);
			}
		}

}
