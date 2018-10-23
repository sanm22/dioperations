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
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.logitech.operationmart.beans.LoadControl;
import com.logitech.operationmart.beans.ObjectHierarchy;
import com.logitech.operationmart.utils.HibernateUtil;

 
/*
 * @Author: Mateen SA 
 * @Company: Zensar Technologies
 * @Date: 05-Sept-2018
 */


public class LoadControlTreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoadControlTreeServlet() {
        super(); 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(findAll()));
		System.out.println(gson.toJson(findAll()).toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	@SuppressWarnings({"unchecked","deprecation","rawtypes"})
	private List<ObjectHierarchy> findAll() {
		
		 List<ObjectHierarchy> list = new ArrayList<ObjectHierarchy>();
		

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		String strQuery = " SELECT LOAD_NAME, GROUP_CONCAT(DISTINCT SUBJECT_AREA_NAME) AS SUBJECTAREALIST FROM MASTER_ETL_LOAD_CONTROL " + 
				" WHERE 1=1 AND ENABLED_FLG = 'Y' AND job_Type = 'PENTAHO_JOB'  " + 
				" GROUP BY LOAD_NAME "; 
		 
		List<Object[]> lcList = session.createSQLQuery(strQuery).getResultList();
		
		int size = 10;
		String style = "'red'";
		
		
		int i = 0;

		list.add(new ObjectHierarchy(i++, "EDW"					,-1		, size, style));
		list.add(new ObjectHierarchy(i++, "Loads"				, 0		, size, style));		
		
		//Adding all loads loop
		int loadPosition = i-1;
		
		for (Object[] lname1 : lcList) {
			 
			String strLN = lname1[0].toString();
			list.add(new ObjectHierarchy(i++, strLN, loadPosition, size, style));
			int subjectPosition = i-1;
			String[] arr = lname1[1].toString().split(",");
			for (int j = 0; j < arr.length; j++) {
				String strSAN = arr[j].toString();
				list.add(new ObjectHierarchy(i++, strSAN, subjectPosition, size, style));
				
				String strQuery2 = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_LOAD_CONTROL");
				
				Query query = session.createQuery(strQuery2).setCacheable(true);
				query.setParameter("loadName", strLN);
				query.setParameter("subjectAreaName", strSAN);
				
				List<LoadControl> jList = query.getResultList();
				int jobPosition = i-1;
				for (LoadControl lControl : jList) { 
					list.add(new ObjectHierarchy(i++, lControl.getJobName(), jobPosition, size, style));
				}
			}
			 
		}
		
		try {
			session.flush();
			session.close();
		}catch(Exception e) {}
		
		return list;
	}
	
	
//	private List<DbKeyValuePair> getResultSetTableListFromDB() {
//		
//		ArrayList<DbKeyValuePair> list = new ArrayList<DbKeyValuePair>();
//		
//		
//		String[] master_etl_load_control = {"loadname", "subjectareaname", "jobname", "jobstatus"};	
//		list.add(new DbKeyValuePair("master_etl_load_control",  Arrays.asList(master_etl_load_control)));
//	
//		String[] master_etl_runtime_stats = {"loadname", "subjectareaname", "loadschedule", "jobname", "status"};
//		list.add(new DbKeyValuePair("master_etl_runtime_stats",  Arrays.asList(master_etl_runtime_stats)));
//		
//		return list;
//	}
//	
//	
//	private List<DbKeyValuePair> getResultSetViewListFromDB() {
//		
//		ArrayList<DbKeyValuePair> list = new ArrayList<DbKeyValuePair>();
//		
//		String[] biops_load_status_vw = {"biops_vwcol1", "biops_vwcol2", "biops_vwcol3", "biops_vwcol4", "biops_vwcol5"};
//		list.add(new DbKeyValuePair("biops_load_status_vw",  Arrays.asList(biops_load_status_vw)));
//		
//		String[] master_etl_runtime_stats_vw = {"vwcol1", "vwcol2", "vwcol3", "vwcol4", "vwcol5"};
//		list.add(new DbKeyValuePair("master_etl_runtime_stats_vw",  Arrays.asList(master_etl_runtime_stats_vw)));
//		
//		return list;
//	}
}
