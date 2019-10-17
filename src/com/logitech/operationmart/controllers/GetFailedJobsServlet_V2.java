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
import com.logitech.operationmart.utils.DateConverterUtil;
import com.logitech.operationmart.utils.HibernateUtil;
import com.logitech.operationmart.beans.LoadStats;
import com.logitech.operationmart.beans.RunningLoadsPerDate;
import com.logitech.operationmart.beans.v2.FailedJobsPerDateBubbleBean;

/*
 * @Author: Mateen SA 
 * @Company: Zensar Technologies
 * @Date: 29-Aug-2018
 */

public class GetFailedJobsServlet_V2 extends HttpServlet {

	private static final long serialVersionUID = 100L;

	public GetFailedJobsServlet_V2() {
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

			String queryString = " "
					+ " SELECT COUNT(1) as nr, e.loads.loadName, e.subLoads.subLoadName, date(e.runEndDate) as runEndDate, e.runStatus "
					+ " FROM JobRuns e "
					+ " WHERE 1=1 AND e.runStatus NOT IN ('Finished') "
					+ " GROUP BY e.loads.loadName, e.subLoads.subLoadName, date(e.runEndDate), e.runStatus "
					+ " ORDER BY date(e.runEndDate) DESC";


			Query<Object[]> qury = session.createQuery(queryString);
			List<Object[]> rows = qury.getResultList(); 

			ArrayList<FailedJobsPerDateBubbleBean> resultList = new java.util.ArrayList<FailedJobsPerDateBubbleBean>();
			
			for (Object[] loads : rows) {
				int nr = ((Long) loads[0]).intValue();
				String loadName = (String) loads[1];
				String subLoadName = (String) loads[2];
				java.sql.Date runEndDate = (java.sql.Date) loads[3];
				String runStatus = (String) loads[4];
				resultList.add(new FailedJobsPerDateBubbleBean(nr, loadName, subLoadName, runEndDate.toString(), runStatus.substring(0, runStatus.length() > 30 ? 30 : runStatus.length())));
			}

			session.getTransaction().commit();
			out.println(gson.toJson(resultList));
			
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
