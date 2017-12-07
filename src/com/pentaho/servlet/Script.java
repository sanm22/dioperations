package com.pentaho.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pentaho.bean.BiopsUser;
import com.pentaho.scripting.ExecuteScript;

@WebServlet("/Script")
public class Script extends HttpServlet {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Script.class);

	public Script() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean value = false;
		if (request.getParameter("button1") != null) {
			BiopsUser.setUserId(BiopsUser.getUserId() + 1);
			value = ExecuteScript.executeScript();
			if (value == true) {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('Job Started!');");
				out.println("location='dashboard.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Job not Started!');");
				out.println("location='dashboard.jsp';");
				out.println("</script>");

			}

		} else {
			System.out.println("Script not executed");
			logger.error("Script not executed");
		}
	
		// response.sendRedirect("dashboard.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Iterator<Entry<String, String[]>> it = request.getParameterMap().entrySet().iterator();

		while (it.hasNext()) {
			String key = it.next().toString();
			System.out.println("key " + key + " vallue " + request.getParameter(key));
		}

		doGet(request, response);
	}

}
