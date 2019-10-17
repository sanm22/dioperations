package com.logitech.operationmart.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.logitech.operationmart.beans.LoadStats;
import com.logitech.operationmart.beans.RunningLoadsPerLoadName;
import com.logitech.operationmart.beans.v2.Loads;
import com.logitech.operationmart.utils.HibernateUtil;

/*
 * @Author: Mateen SA 
 * @Company: Zensar Technologies
 * @Date: 29-Aug-2018
 */

@SuppressWarnings("deprecation")
public class GetRunningLoadsServlet extends HttpServlet {

	private static final long serialVersionUID = 100L;

	public GetRunningLoadsServlet() {
		super();

	}

	@SuppressWarnings({ "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (! (request.getParameter("P_LOADNAME") != null)) {
			Gson gson = new Gson();
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();

			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();

			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_COUNT_RUNNING_JOBS_PER_LOAD_NAME_V2");
			@SuppressWarnings({ "rawtypes" })
			SQLQuery qury = session.createSQLQuery(queryString);
			List<Object[]> rows = qury.list(); 
			List<RunningLoadsPerLoadName> resultList = new ArrayList<RunningLoadsPerLoadName>();
			for (Object[] loads : rows) {
				 Object loadName = loads[1];
				 Object nr = loads[0];
				resultList.add(new RunningLoadsPerLoadName(loadName.toString(), Integer.valueOf(nr.toString())));
			}
 
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

			String quryLoadId = " select e1 from Loads e1 where e1.loadName =  '"+request.getParameter("P_LOADNAME")+"'";
			List<Loads> loads = session.createQuery(quryLoadId).getResultList();
			
			String queryString = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_RUNNING_JOBS_PER_LOAD_NAME_V2");

			Query<LoadStats> query = session.createQuery(queryString);
			query.setParameter("loadId", loads.get(0).getLoadId());

			List<LoadStats> rows = query.getResultList();

			out.println(gson.toJson(rows));
			session.getTransaction().commit();
			
			try {
				session.close();
			} catch (Exception e) {
			}

		}
	}

	@SuppressWarnings("unused")
	private Date getYesterdayDate() throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(Calendar.getInstance().get(Calendar.YEAR) +"-" + (Calendar.getInstance().get(Calendar.MONTH) +1) + "-"+ Calendar.getInstance().get(Calendar.DATE-1));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
