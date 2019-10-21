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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.google.gson.Gson;
import com.logitech.operationmart.utils.DateConverterUtil;
import com.logitech.operationmart.utils.HibernateUtil;
import com.logitech.operationmart.beans.LoadStats;
import com.logitech.operationmart.beans.RunningLoadsPerDate;
import com.logitech.operationmart.beans.v2.FailedJobsPerDateBubbleBean;
import com.logitech.operationmart.beans.v2.JobRunDetailsSimplified;
import com.logitech.operationmart.beans.v2.JobRuns;

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

			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_FAILED_ANNOTATION_DATA");
			
			Query<Object[]> qury = session.createQuery(queryString);
			List<Object[]> rows = qury.getResultList(); 

			ArrayList<FailedJobsPerDateBubbleBean> resultList = new java.util.ArrayList<FailedJobsPerDateBubbleBean>();
			
			for (Object[] loads : rows) {
				int nr_etl_errors = ((Long) loads[0]).intValue();
				int nr_ktl_errors = ((Long) loads[1]).intValue();
				String loadName = (String) loads[2];
				String subLoadName = (String) loads[3];
				java.sql.Date runEndDate = (java.sql.Date) loads[4];
				String runStatus = (String) loads[5];
				resultList.add(new FailedJobsPerDateBubbleBean(nr_etl_errors, nr_ktl_errors, loadName, subLoadName, runEndDate.toString(), runStatus.substring(0, runStatus.length() > 30 ? 30 : runStatus.length())));
			}

			session.getTransaction().commit();
			out.println(gson.toJson(resultList));
			
			try {
				session.close();
			} catch (Exception e) {
			}

		}else {
			String strRunDate = request.getParameter("P_RUNDATE");
			String strLoad = request.getParameter("P_LOADNAME");
			String strSubLoad = request.getParameter("P_SUBLOADNAME");
			String strRunStatus = request.getParameter("P_RUNSTATUS");
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			String strConvertedDate = "";
			
			try {
				strConvertedDate = sdf2.format(sdf1.parse(strRunDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_FAILED_JOBS_DEEP_FILTER");
			queryString = queryString.replace("XXXXXXXXXX", strConvertedDate);
			
			Gson gson = new Gson();
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			session.enableFilter("runStatusFltr").setParameter("yourRunStatusParam", strRunStatus);
//
			Query<JobRuns> hquery = session.createQuery(queryString);
			hquery.setMaxResults(8);
			
			hquery.setParameter("pLoadName", strLoad);
			hquery.setParameter("pSubLoadName", strSubLoad);
			
			List<JobRuns> rows = hquery.getResultList();
			
			List<JobRunDetailsSimplified> newLi = new ArrayList<JobRunDetailsSimplified>();
			for (JobRuns jobRuns : rows) {
				newLi.add(new JobRunDetailsSimplified(jobRuns.getJobName(), jobRuns.getJobs().getJobOrder(), jobRuns.getJobs().getJobType(), jobRuns.getLoads().getLoadName(), jobRuns.getSubLoads().getSubLoadName(),
				jobRuns.getPentahoJobId(), jobRuns.getRunStartDate(), jobRuns.getRunEndDate(), jobRuns.getRunStatus(), jobRuns.getRunId()));
			}
			
			
			
			session.getTransaction().commit();
			session.disableFilter("runStatusFltr");
			out.println(gson.toJson(newLi));
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
