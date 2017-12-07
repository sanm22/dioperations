package com.pentaho.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		 * response.setContentType("text/html"); PrintWriter
		 * out=response.getWriter(); HttpSession
		 * session=request.getSession(false); session.invalidate();
		 * out.println("<script type=\"text/javascript\">");
		 * out.println("alert('Session Expired!!! Please Login Again');");
		 * out.println("location='index.jsp';"); out.println("</script>");
		 */

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		session.invalidate();

		out.println("<script type=\"text/javascript\">");
		out.println("alert('You have Logged out!!! Click Ok to go to login page');");
		out.println("location='index.jsp';");
		out.println("</script>");

		out.close();
	}

}
