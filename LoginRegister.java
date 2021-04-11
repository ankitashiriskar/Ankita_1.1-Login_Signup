package com.login.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("INSIDE");
		UserDAOImpl dao = new UserDAOImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password1");
		String submit = request.getParameter("submit");
		User us = dao.getUser(username, password);

		if (submit.equalsIgnoreCase("login") && us != null && us.getName() != null) {
			request.setAttribute("message", us.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else if (submit.equalsIgnoreCase("sign up")) {
			us.setName(request.getParameter("name"));
			us.setUsername(username);
			us.setPassword(password);
			System.out.println("sign up");
			dao.insertUser(us);
			request.setAttribute("successMessage", "Registration done, Please login !!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Data not found, click on Sign up");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
