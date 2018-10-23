package com.logitech.operationmart.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.logitech.operationmart.utils.HibernateUtil;
import com.logitech.operationmart.beans.LoadStats;
import com.logitech.operationmart.beans.RunningLoadsPerDate;

/*
 * @Author: Mateen SA 
 * @Company: Zensar Technologies
 * @Date: 29-Aug-2018
 */

public class GetLoadStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 100L;

	public GetLoadStatusServlet() {
		super();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (! (request.getParameter("P_RUNDATE") != null)) {
			Gson gson = new Gson();
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_RUNNING_JOBS");

			Query query = session.createQuery(queryString);
			query.setMaxResults(5);

			List<Object[]> rows = query.getResultList();
			List<RunningLoadsPerDate> resultList = new ArrayList<RunningLoadsPerDate>();
			for (Object[] line : rows) {
				Timestamp ts = (Timestamp) line[0];
				Date d = new Date(ts.getTime());
				String strDate = new SimpleDateFormat("yyyy-MM-dd").format(d);
				Long lv = (Long) line[1];
				resultList.add(new RunningLoadsPerDate(strDate, lv.intValue()));
			}

			request.setAttribute("P_RUNDATE", request.getParameter("P_RUNDATE"));
			out.println(gson.toJson(resultList));

			session.getTransaction().commit();
			
			try {
				session.close();
			} catch (Exception e) {
			}

			
			
		}else {
			Gson gson = new Gson();
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_RUNNING_JOBS_FAILED");

			Query<LoadStats> query = session.createQuery(queryString);
			query.setMaxResults(5);

			List<LoadStats> rows = query.getResultList();
			List<RunningLoadsPerDate> resultList = new ArrayList<RunningLoadsPerDate>();
			for (LoadStats stat : rows) {
				
				resultList.add(new RunningLoadsPerDate(stat.getJobName(), stat.getRunId()));
			}

			request.setAttribute("P_RUNDATE", request.getParameter("P_RUNDATE"));
			out.println(gson.toJson(resultList));

			session.getTransaction().commit();
			
			try {
				session.close();
			} catch (Exception e) {
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
