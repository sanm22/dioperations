package com.logitech.operationmart.controllers;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.logitech.operationmart.beans.User;
import com.logitech.operationmart.utils.HibernateUtil;
import com.logitech.operationmart.utils.PasswordHasher;


/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 7L;
       

    public LoginController() {
        super(); 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.getWriter().append(new String("Please do login using from")).append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/xml");
		
		response.getWriter().append("User Authenticated "+request.getParameter("uname") + " Successful");
		if(validateLoginRequest(request, request.getParameter("uname"),request.getParameter("psw"))) {
			response.sendRedirect("dashboard.jsp");
		}else {
			response.sendRedirect("index.jsp?message=AuthFailure");
		}
		
	}


	@SuppressWarnings("unchecked")
	private boolean validateLoginRequest(HttpServletRequest request, String parameter, String parameter2) throws ServletException {
		
		boolean isAuthenticated = false;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_LOGIN");

		Query<User> query = session.createQuery(queryString).setCacheable(true);
		query.setParameter("userName", parameter);
		

		List<User> userList = query.getResultList(); 
		
		if(userList.size() > 1) {
			throw new ServletException("Multiple users found for userid "+ parameter);
		}
		
		for (User user : userList) {
			
			
			if(PasswordHasher.verifyUserPassword(parameter2, user.getUserPassword(), "Logi")) {
				isAuthenticated = true;
				request.setAttribute("BIOPS_USER", user);
			}

		}

		
		session.getTransaction().commit();
		
		try {
			session.close();
		} catch (Exception e) {
		}

		return isAuthenticated;
	}

}
