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
import com.logitech.operationmart.beans.v2.EventDetails;
import com.logitech.operationmart.beans.v2.JobRunDetailsSimplified;
import com.logitech.operationmart.beans.v2.JobRuns;
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
 		
		List<EventDetails> li = getLastTwoDaysTDERanList(session);
		out.println(gson.toJson(li));
		
		session.getTransaction().commit();
		
		try {
			session.close();
		} catch (Exception e) {
		}
		

	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private List<EventDetails> getLastTwoDaysTDERanList(Session session) {
		
//		List<JobRuns> li = new ArrayList<JobRuns>();
//		
//		String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_STATUS_V2");
//		int nrResults = Integer.parseInt(ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_STATUS_MAX_NR"));
//				
//		for(String lName : ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_STATUS_LIST_V2").split(",")) {
//			Query<JobRuns> query = session.createQuery(queryString).setCacheable(true);
//			query.setParameter("loadName", lName);
//			query.setMaxResults(nrResults);
//			li.addAll(query.getResultList());
//		}
//		
//		List<JobRunDetailsSimplified> newLi = new ArrayList<JobRunDetailsSimplified>();
//		for (JobRuns jobRuns : li) {
//			newLi.add(new JobRunDetailsSimplified(jobRuns.getJobName(), jobRuns.getJobs().getJobOrder(), jobRuns.getJobs().getJobType(), jobRuns.getLoads().getLoadName(), jobRuns.getSubLoads().getSubLoadName(),
//			jobRuns.getPentahoJobId(), jobRuns.getRunStartDate(), jobRuns.getRunEndDate(), jobRuns.getRunStatus(), jobRuns.getRunId()));
//		}
		String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_STATUS_V2");
		Query<EventDetails> query = session.createQuery(queryString).setCacheable(true);
		query.setMaxResults(Integer.parseInt(ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_STATUS_MAX_NR")));
		return query.getResultList();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
