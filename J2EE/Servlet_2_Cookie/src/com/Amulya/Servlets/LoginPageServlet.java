package com.Amulya.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.LoginConstants;

/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String userName = "admin";
    private static final String password = "Kony@1234";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName = request.getParameter(LoginConstants.USERNAME);
		String password = request.getParameter(LoginConstants.PASSWORD);
		if(userName.equals(this.userName) && password.equals(this.password))
		{/*
			if(request.getSession(false)!=null)
			{
				System.out.println("Session found - terminating and creating new one");
				request.getSession().invalidate();
				request.getSession(true);
			}*/
			Cookie loginCookie = new Cookie("userLoggedIn","true");
			loginCookie.setMaxAge(2*60);
			response.addCookie(loginCookie);
			response.sendRedirect("LoginSuccessful.jsp");		
			System.out.println("Login successs");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			response.getWriter().print("<h1>Login failed</h1>");
			rd.include(request,response);
		}
			//response.getWriter().print(LoginConstants.LOGIN_FAILURE);
	}

}
