package com.logitech.operationmart.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/GetAllFailedRows")
public class GetAllFailedRows extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetAllFailedRows() {
        super(); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		 
		Gson gson = new Gson();
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		
		String runDate = request.getParameter("P_RUNDATE"); 
		
		out.println(gson.toJson( runDate ));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doGet(request, response);
	}
	
	
	

}
