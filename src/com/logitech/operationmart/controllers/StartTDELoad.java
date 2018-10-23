package com.logitech.operationmart.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class StartTDELoad extends HttpServlet {
	private static final long serialVersionUID = 10L;
    private Logger logger = Logger.getLogger(this.getClass());   
	
    public StartTDELoad() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		long stTime = System.currentTimeMillis();

		PrintWriter out = response.getWriter();
		
		try {
			String command = ResourceBundle.getBundle("dioperations").getString("LOGI_POM_HIB_TDE_RUN") + " " +request.getParameter("loadName")+ " DAILY";
			out.println(command +" </br>"); 
			out.println(" </br> ============================ </br>");
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command);
			InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				out.println(" </br>"+line);
			}
			out.println(" </br> ============================ </br>");
			int exitVal = proc.waitFor();
			out.println(" </br>"+"Process exitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}


		long etTime = System.currentTimeMillis();

		out.println("time taken in seconds " + (etTime - stTime) / 1000);
	}

}
