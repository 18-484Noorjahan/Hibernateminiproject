package com.noorjahan.servlet;

import java.io.IOException;
import com.noorjahan.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.noorjahan.dao.*;

@WebServlet("/register")
public class RegisterServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		String department = req.getParameter("department");
		String salary= req.getParameter("salary");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		EmpDao dao = new EmpDao(HibernateUtil.getSessionFactory());
		Emp e = new Emp(name,department,salary,email,password);
		boolean f=dao.saveEmp(e);
		HttpSession session = req.getSession();
		if(f)
		{
			session.setAttribute("msg", "registration successfull");
			System.out.println("registration successfull");
		}
		else
		{
			session.setAttribute("msg", "something went wrong");
			System.out.println("something went wrong on server");
		}
		//System.out.println(e);
		resp.sendRedirect("index.jsp");
	}

	
	

}
