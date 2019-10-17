package com.logitech.operationmart.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.google.gson.Gson;
import com.logitech.operationmart.utils.DateConverterUtil;
import com.logitech.operationmart.utils.HibernateUtil;
import com.logitech.operationmart.beans.LoadStats;
import com.logitech.operationmart.beans.RunningLoadsPerDate;
import com.logitech.operationmart.beans.RunningLoadsPerLoadName;
import com.logitech.operationmart.beans.v2.JobRuns;

/*
 * @Author: Mateen SA 
 * @Company: Zensar Technologies
 * @Date: 29-Aug-2018
 */

public class GetRunningJobsServlet_V2 extends HttpServlet {

	private static final long serialVersionUID = 100L;

	public GetRunningJobsServlet_V2() {
		super();

	}

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (! (request.getParameter("P_RUNDATE") != null)) {
			Gson gson = new Gson();
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_RUNNING_JOBS_V2");

			@SuppressWarnings({ "rawtypes" })
			SQLQuery qury = session.createSQLQuery(queryString);
			List<Object[]> rows = qury.list(); 
			List<RunningLoadsPerLoadName> resultList = new ArrayList<RunningLoadsPerLoadName>(); 
			for (Object[] loads : rows) {
				Date d = (java.sql.Date) loads[1];
				String strDate = new SimpleDateFormat("yyyy-MM-dd").format(d);
				java.math.BigInteger lv = (java.math.BigInteger) loads[0];
				resultList.add(new RunningLoadsPerLoadName(strDate, lv.intValue()));
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

//			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_ALLJOBS_VIA_DATE");
//
//			Query<JobRuns> query = session.createQuery(queryString);
//			try {
//				query.setParameter("runStartDate", DateConverterUtil.getDateFromString(request.getParameter("P_RUNDATE")));
//			} catch (ParseException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			List<JobRuns> rows = query.getResultList();
//			List<RunningLoadsPerDate> resultList = new ArrayList<RunningLoadsPerDate>();
//			for (JobRuns stat : rows) {
//				
//				resultList.add(new RunningLoadsPerDate(stat.getJobName(), stat.getRunId()));
//			}

			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_ALLJOBSCOUNT_VIA_DATE");
			queryString = queryString.replace("?", "'"+request.getParameter("P_RUNDATE")+"'") ;
			@SuppressWarnings({ "rawtypes" })
			SQLQuery qury = session.createSQLQuery(queryString);
			List<Object[]> rows = qury.list(); 
			List<RunningLoadsPerLoadName> resultList = new ArrayList<RunningLoadsPerLoadName>(); 
			for (Object[] loads : rows) {
				String ldName = (String) loads[1];
				java.math.BigInteger lv = (java.math.BigInteger) loads[0];
				resultList.add(new RunningLoadsPerLoadName(ldName, lv.intValue()));
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
