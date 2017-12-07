package com.pentaho.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pentaho.dao.WorkbenchDao;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String username=request.getParameter("uname");
        
        String password=request.getParameter("psw");
        WorkbenchDao workbench =new WorkbenchDao();
        boolean result=workbench.validation(username,password);
        if(result==false)
        {
        		   out.println("<script type=\"text/javascript\">");
        		   out.println("alert('User or password incorrect');");
        		   out.println("location='index.jsp';");
        		   out.println("</script>");
        		
        }
        else
        {
        	HttpSession session=request.getSession();  
            session.setAttribute("name",username);
            response.sendRedirect("dashboard.jsp");
           
        }
        
        out.close();  
       	}

}
