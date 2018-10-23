package com.logitech.operationmart.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.logitech.operationmart.beans.BiopsLoadStats;
import com.logitech.operationmart.utils.HibernateUtil;


/*
 * @Author: Mateen SA 
 * @Company: Zensar Technologies
 * @Date: 18-Oct-2018
 */

public class TDEOperations extends HttpServlet {
	private static final long serialVersionUID = 11L;
       

    public TDEOperations() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
 		
		long startMillis = System.currentTimeMillis();
		List<BiopsLoadStats> li = getLastTwoDaysTDERanList(session);
		long endMillis = System.currentTimeMillis();
		System.out.println(endMillis - startMillis+ " is time taken " + endMillis + " " + startMillis);
		out.println(gson.toJson(li));
		
		session.getTransaction().commit();
		
		try {
			session.close();
		} catch (Exception e) {
		}
		

	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private List<BiopsLoadStats> getLastTwoDaysTDERanList(Session session) {
		
		List<BiopsLoadStats> li = new ArrayList<BiopsLoadStats>();
		
		String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_STATUS");
		int nrResults = Integer.parseInt(ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_STATUS_MAX_NR"));
				
		for(String lName : ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_STATUS_LIST").split(",")) {
			Query query = session.createQuery(queryString).setCacheable(true);
			query.setParameter("loadName", lName);
			query.setMaxResults(nrResults);
			li.addAll(query.getResultList());
		}
		
		return li;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
