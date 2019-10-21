package com.logitech.operationmart.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.logitech.operationmart.beans.DistinctLoadNamesBean;
import com.logitech.operationmart.beans.v2.Jobs;
import com.logitech.operationmart.utils.HibernateUtil;


/*
 * @Author: Mateen SA 
 * @Company: Zensar Technologies
 * @Date: 01-Oct-2018
 */


@WebServlet("/GetFormattedLoads")
public class GetFormattedLoads extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetFormattedLoads() {
        super(); 
    }

 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 


		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

//		String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_FORMATTED_LOADS");
//		System.out.println(queryString + " " + this.getClass().getName() );
//		Query query = session.createQuery(queryString);
//		List<Object[]> rows = query.getResultList();
//		List<DistinctLoadNamesBean> result = new ArrayList<DistinctLoadNamesBean>();
//		for (Object[] obj : rows) {		
//			result.add(new DistinctLoadNamesBean(obj[0].toString(), obj[1].toString(), obj[2].toString(), obj[3].toString()));
//		}
//		System.out.println(gson.toJson(result));
		
		
		String queryString = "SELECT e FROM Jobs e "+" where e.loads.loadId=52";
		Query<Jobs> query = session.createQuery(queryString);
		query.setCacheable(true);
		List<Jobs> result = query.getResultList();

		List<DistinctLoadNamesBean> formattedResult = new ArrayList<DistinctLoadNamesBean>();
		for (Jobs job : result) {		
			formattedResult.add(new DistinctLoadNamesBean(job.getLoads().getLoadName(), job.getSubLoads().getSubLoadName(), job.getJobName() ));
		}
		out.println(gson.toJson(formattedResult));

		session.getTransaction().commit();
		
		try {
			session.close();
		} catch (Exception e) {
		}
		
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}

}
