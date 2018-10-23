package com.logitech.operationmart.controllers;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.logitech.operationmart.beans.ManualRuns;
import com.logitech.operationmart.beans.Webresult;
import com.logitech.operationmart.utils.HibernateUtil;

/*
 * @Author: Mateen SA 
 * @Company: Zensar Technologies
 * @Date: 02-Oct-2018
 */

@WebServlet("/ManualJBRunner")
public class ManualJBRunner extends HttpServlet {

	@SuppressWarnings({})
	private static final long serialVersionUID = 3L;

	public ManualJBRunner() {
		super();
	}

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String runType = request.getParameter("adhocrun");

		boolean runAsWebService = runType == "ws" ? true : false;

		String loadName = request.getParameter("load");
		String subject = request.getParameter("subject");
		String path = request.getParameter("path");
		String job = request.getParameter("job");

		String strJobName = path.replaceAll("/", "%2F") + job;

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(getBaseURI(strJobName));

		Response wsresponse = target.request(MediaType.APPLICATION_FORM_URLENCODED).get();
		String responseStr = wsresponse.readEntity(String.class);
		Webresult result = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Webresult.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(responseStr);
			result = (Webresult) jaxbUnmarshaller.unmarshal(reader);

			request.setAttribute("MANUAL_JOB_RUNNER_STATUS", result);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		saveManualRun(runType, loadName, subject, path, job, result, responseStr);

		RequestDispatcher rd = request.getRequestDispatcher("/manual_run.jsp");
		rd.include(request, response);
	}

	@SuppressWarnings("unchecked")
	private void saveManualRun(String runType, String loadName, String subject, String path, String job,
			Webresult result, String responseStr)   {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		String maxRunIdQuery = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_MAX_MANUAL_RUN_ID");
		List<Object> objectList = session.createQuery(maxRunIdQuery).getResultList();
		
		int idValue = objectList.size() > 0 ? new Integer( objectList.get(0) == null ? "0" :  objectList.get(0).toString()) : 0;
		
		
		ManualRuns run = new ManualRuns(idValue, 0, "", runType, result.getId(), path.replaceAll("%2F", "/"), job,
				ResourceBundle.getBundle("dioperations").getString("KITCHENURL").substring(0, 41), result.getResult(),
				result.getMessage(), responseStr, new java.sql.Date(System.currentTimeMillis()));

		session.save(run);
		session.getTransaction().commit();

		try {
			session.close();
		} catch (Exception e) {
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private URI getBaseURI(String job) {
		return UriBuilder.fromUri(ResourceBundle.getBundle("dioperations").getString("KITCHENURL") + job).build();
	}

}
