package com.pentaho.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pentaho.addnewentry.AddNew;

@WebServlet("/AddLoadSubLoadJob")
public class AddLoadSubLoadJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(AddLoadSubLoadJob.class);

	public AddLoadSubLoadJob() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String loadName = request.getParameter("loadName");
		String subLoadName = request.getParameter("subLoadName");
		String jobName = request.getParameter("jobName");
		String enabledFlg = request.getParameter("_enabledFlg");
		String jobOrder = request.getParameter("jobOrder");
		String jobType = request.getParameter("_jobType");
		String jobPath = request.getParameter("jobPath");
		String loadId = request.getParameter("loadId");
		String subLoadId = request.getParameter("subLoadId");
		String loadSchedule = request.getParameter("_loadSchedule");

		logger.debug("values:" + loadName + " ," + subLoadName + ", " + jobName + " ," + jobOrder + " ," + jobType
				+ " ," + jobPath + ", " + enabledFlg + ", " + loadSchedule + ", " + loadId + " ," + subLoadId);
		AddNew.addNewEntry(loadName, subLoadName, jobName, enabledFlg, jobOrder, jobType, jobPath, loadId, subLoadId,
				loadSchedule);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
