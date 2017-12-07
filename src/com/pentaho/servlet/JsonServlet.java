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

public class JsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(JsonServlet.class);
	public static String load_name=null;
	public static String subload_name=null;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		ShellScripting scripting = new ShellScripting();
		logger.info("Script Selection values---");
		System.out.println("Script Selection values---");
		
		String loadName = request.getParameter("loadName");
		scripting.getLoad(loadName);
		System.out.println("loadName-script:" + loadName);
		logger.debug("loadName:" + loadName);
		
		if(load_name==null)
		{
			load_name=loadName;
		}

		String subLoadName = request.getParameter("lloadName");
		scripting.getSubLoad(subLoadName);
		System.out.println("subload-script:" + subLoadName);
		logger.debug("subload:" + subLoadName);
		
		if(subload_name==null)
		{
			subload_name=subLoadName;
		}
		
		String jobName = request.getParameter("jobName");
		scripting.getJobName(jobName);
		System.out.println("jobname-script:" + jobName);
		logger.debug("jobname:" + jobName);

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
				list.add("Select Job Name");
				while (itr.hasNext()) {
					MasterEtlLoadControl workbench1 = itr.next();
					load = workbench1.getJobName();
					list.add(load);

				}

			}

		} else if (jobName != null) {
			scripting.getSubLoad(jobName);
		}

		json = new Gson().toJson(list);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

}