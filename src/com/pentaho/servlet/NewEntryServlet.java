package com.pentaho.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.pentaho.bean.MasterEtlLoadControl;
import com.pentaho.dao.ShellScripting;

public class NewEntryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(NewEntryServlet.class);
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		ShellScripting scripting = new ShellScripting();
		
		logger.info("New Job entry--");
		
		
		String loadName = request.getParameter("loadName");	
		
		
		
		scripting.getLoad(loadName);
		
		System.out.println("loadName:" + loadName);
		logger.debug("loadName:" + loadName);

		String subLoadName = request.getParameter("subLoad");
		scripting.getSubLoad(subLoadName);
		System.out.println("subload:" + subLoadName);
		logger.debug("subload:" + subLoadName);

		List<String> list = new ArrayList<String>();
		String json = null;
		if (loadName != null) {

			if (loadName != null && loadName.equals("Select Load Name")) {
				list.add("Select Sub Load");
			} else if (loadName != null && loadName.equals("Select Sub Load")) {
				list.add("Select Job Name");
			} else if (loadName != null && loadName.equals(loadName)) {

				List<MasterEtlLoadControl> workbenchList = ShellScripting.getSubjectAreaName();

				Iterator<MasterEtlLoadControl> itr = workbenchList.iterator();
				String load = null;
				list.add("Select Sub Load Name");

				while (itr.hasNext()) {
					MasterEtlLoadControl workbench = itr.next();
					load = workbench.getSubjectAreaName();
					list.add(load);

				}

			}

		} else if (subLoadName != null) {

			if (subLoadName != null && subLoadName.equals("Select Load Name")) {
				list.add("Select Sub Load");
			} else if (subLoadName != null && subLoadName.equals("Select Sub Load")) {
				list.add("Select Job Name");
			} else if (subLoadName != null && subLoadName.equals(subLoadName)) {

				List<MasterEtlLoadControl> workbenchList = ShellScripting.getJobNAme();

				Iterator<MasterEtlLoadControl> itr = workbenchList.iterator();
				String load = null;
				list.add("Select Sub Load");
				while (itr.hasNext()) {
					MasterEtlLoadControl workbench1 = itr.next();
					load = workbench1.getJobName();
					list.add(load);

				}

			}

		}

		json = new Gson().toJson(list);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

}