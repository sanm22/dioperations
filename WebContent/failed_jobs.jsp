<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="shortcut icon" href="./images/64px-Logitech.svg.png" />
<title>D&I Operations</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" type="text/css" href="./css/charts_table_format.css">
  <script type="text/javascript" src="./charts_js/jquery.min.js"></script>
  <script type="text/javascript" src="./charts_js/loader.js"></script>
  <script type="text/javascript" src="./charts_js/failed_jobs_annotation_chart.js"></script>
  <script type="text/javascript" src="./charts_js/util.js"></script>
  <script type="text/javascript">

    $(document).ready(function () {
     	google.charts.load('current', {'packages':['annotationchart']});
    	
  		$.ajax({
	        url: "GetFailedJobsServlet_V2",
	        dataType: "JSON",
	        success: function (result) { 
	          google.charts.setOnLoadCallback(function () { 
	        	  drawChart(result);
	          });
	        }
	      })  
    });

  </script> 

</head>

<% 
if( request.getAttribute("P_RUNDATE") == null ) {
		
		out.println("<script type='text/javascript'>");
		out.println("google.charts.load('current', {packages: ['annotationchart']}); ");
		out.println("</script>"); 
		
		out.println("<div id='chart_div' style='width: 600px; border: 1px solid #ccc'></div>");
		
		out.println("<script type='text/javascript'>");
		out.println("google.charts.load('current', {packages: ['table']}); ");
		out.println("</script>");
		

		out.println("<div id='table_div' style='border: 1px solid #ccc'></div>");
		out.println("<input type='button' value='Refresh' onclick='window.location.reload()' id='refresh_button_div'> ");
		
		out.println("<input type='button' value='Back' onclick='goBackFunc()' id='back_button_div'> ");

}	
%>
  </body>
</html>