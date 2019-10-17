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
  <script type="text/javascript">

    $(document).ready(function () {
    	var json ='[{"nr":1,"loadName":"ISTAR_LOAD","subLoadName":"ISTAR_PRODUCER","runEndDate":"2019-06-25","runStatus":"Unexpected error executing the"},{"nr":8,"loadName":"SLCM","subLoadName":"SLCM_PRODUCER","runEndDate":"2019-06-24","runStatus":"Job started"},{"nr":1,"loadName":"SLCM","subLoadName":"SLCM_PRODUCER","runEndDate":"2019-06-24","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"SLCM","subLoadName":"SLCM_PRODUCER","runEndDate":"2019-06-20","runStatus":"Finished (with errors)"},{"nr":11,"loadName":"SLCM","subLoadName":"SLCM_PRODUCER","runEndDate":"2019-06-20","runStatus":"Job started"},{"nr":2,"loadName":"SLCM","subLoadName":"SLCM_PRODUCER","runEndDate":"2019-06-20","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BUPS","subLoadName":"Scp_Iso_F_Refresh","runEndDate":"2019-05-22","runStatus":"Running"},{"nr":1,"loadName":"BUPS","subLoadName":"Scp_Iso_F_Refresh","runEndDate":"2019-05-22","runStatus":"Stopped (with errors)"},{"nr":4,"loadName":"BUPS","subLoadName":"Scp_Iso_F_Refresh","runEndDate":"2019-05-22","runStatus":""},{"nr":48,"loadName":"BUPS","subLoadName":"Scp_Iso_F_Refresh","runEndDate":"2019-05-22","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"EBS_DIMENSIONS_PRODUCER","runEndDate":"2019-05-06","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"EBS_DIMENSIONS_PRODUCER","runEndDate":"2019-05-05","runStatus":"Stopped (with errors)"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_COPY","runEndDate":"2019-05-04","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_COPY","runEndDate":"2019-05-04","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"EBS_DIMENSIONS_PRODUCER","runEndDate":"2019-05-03","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-27","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-27","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-23","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-23","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-22","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-22","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-21","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-21","runStatus":"Stopped (with errors)"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-20","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-20","runStatus":"Stopped (with errors)"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-19","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-19","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"MFG_ON_TIME_DELIVERY","subLoadName":"EBS_FACT_CONSUMER (Brazil)","runEndDate":"2019-04-19","runStatus":"Running"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-10","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-10","runStatus":"Finished (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-10","runStatus":"Stopped (with errors)"},{"nr":8,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-04-10","runStatus":"Job started"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-04-10","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-09","runStatus":"Job started"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-09","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-08","runStatus":"Job started"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-08","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-07","runStatus":"Job started"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-07","runStatus":"Stopped (with errors)"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-06","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-06","runStatus":"Finished (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-06","runStatus":"Stopped (with errors)"},{"nr":3,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-04-06","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-05","runStatus":"Job started"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-05","runStatus":"Stopped (with errors)"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-04","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-04","runStatus":"Finished (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-04-04","runStatus":"Stopped (with errors)"},{"nr":7,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-04-04","runStatus":"Job started"},{"nr":3,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-04-04","runStatus":"Stopped (with errors)"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-03-31","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2019-03-31","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"EBS_DIMENSIONS_PRODUCER","runEndDate":"2019-03-25","runStatus":"Unexpected error executing the"},{"nr":2,"loadName":"BOOKINGS","subLoadName":"EBS_DIMENSIONS_PRODUCER","runEndDate":"2019-03-25","runStatus":"Unexpected error executing the"},{"nr":3,"loadName":"BOOKINGS","subLoadName":"EBS_DIMENSIONS_PRODUCER","runEndDate":"2019-03-25","runStatus":"Unexpected error executing the"},{"nr":10,"loadName":"MFG_ON_TIME_DELIVERY","subLoadName":"EBS_FACT_CONSUMER (Brazil)","runEndDate":"2019-03-25","runStatus":"Running"},{"nr":3,"loadName":"ESS_AM","subLoadName":"ESS_AM","runEndDate":"2019-03-25","runStatus":"Job started"},{"nr":11,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_COPY","runEndDate":"2019-03-03","runStatus":""},{"nr":19,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_COPY_BACKLOG_REFRESH","runEndDate":"2019-03-03","runStatus":""},{"nr":13,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-03-03","runStatus":""},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_BOOKINGS_REFRESH","runEndDate":"2019-03-03","runStatus":""},{"nr":1,"loadName":"BOOKINGS","subLoadName":"MDM_PRODUCER","runEndDate":"2019-03-03","runStatus":""},{"nr":1,"loadName":"BOOKINGS","subLoadName":"EBS_DIMENSIONS_PRODUCER","runEndDate":"2019-03-03","runStatus":""},{"nr":1,"loadName":"BOOKINGS","subLoadName":"EBS_ODS_PRODUCER","runEndDate":"2019-03-03","runStatus":""},{"nr":1,"loadName":"BOOKINGS","subLoadName":"EBS_FACT_PRODUCER","runEndDate":"2019-03-03","runStatus":""},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_BACKLOG_REFRESH","runEndDate":"2019-02-27","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_BACKLOG_REFRESH","runEndDate":"2019-02-26","runStatus":"Stopped (with errors)"},{"nr":7,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-02-26","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-02-26","runStatus":"Stopped"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2019-02-26","runStatus":"Running"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_BOOKINGS_REFRESH","runEndDate":"2019-02-26","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_EM_DATA_BOOKINGS_REFRESH","runEndDate":"2019-02-26","runStatus":"Job started"},{"nr":1,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_COPY","runEndDate":"2019-02-26","runStatus":"Running"},{"nr":11,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_COPY","runEndDate":"2019-02-26","runStatus":"Job started"},{"nr":19,"loadName":"BOOKINGS","subLoadName":"ESS_AM_DATA_COPY_BACKLOG_REFRESH","runEndDate":"2019-02-26","runStatus":"Job started"},{"nr":20,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2019-02-07","runStatus":"Job started"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2019-02-07","runStatus":"Stopped (with errors)"},{"nr":7,"loadName":"ESS_AM","subLoadName":"ESS_AM","runEndDate":"2019-02-07","runStatus":"Job started"},{"nr":1,"loadName":"ESS_AM","subLoadName":"ESS_AM","runEndDate":"2019-02-07","runStatus":"Stopped (with errors)"},{"nr":6,"loadName":"MFG_ON_TIME_DELIVERY","subLoadName":"ESS_EM_DATA_COPY_BACKLOG_REFRESH","runEndDate":"2018-12-03","runStatus":""},{"nr":1,"loadName":"MFG_ON_TIME_DELIVERY","subLoadName":"ESS_EM_DATA_COPY_BACKLOG_REFRESH","runEndDate":"2018-12-03","runStatus":"Job started"},{"nr":1,"loadName":"MFG_ON_TIME_DELIVERY","subLoadName":"ESS_EM_DATA_COPY_PRODUCT_REFRESH","runEndDate":"2018-12-03","runStatus":"Job started"},{"nr":4,"loadName":"ESS_EM","subLoadName":"ESS_AP","runEndDate":"2018-11-16","runStatus":"Stopped (with errors)"},{"nr":2,"loadName":"ESS_EM","subLoadName":"ESS_AP","runEndDate":"2018-11-16","runStatus":"Running"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-16","runStatus":"Stopped (with errors)"},{"nr":1,"loadName":"ESS_AM","subLoadName":"ESS_AM","runEndDate":"2018-11-16","runStatus":"Stopped (with errors)"},{"nr":4,"loadName":"ESS_AM","subLoadName":"ESS_AM","runEndDate":"2018-11-16","runStatus":"Running"},{"nr":5,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-16","runStatus":"Running"},{"nr":1,"loadName":"ESS_AP","subLoadName":"ESS_AP","runEndDate":"2018-11-16","runStatus":"Stopped (with errors)"},{"nr":3,"loadName":"ESS_AP","subLoadName":"ESS_AP","runEndDate":"2018-11-16","runStatus":"Running"},{"nr":4,"loadName":"BOOKINGS","subLoadName":"COMP_PEGG_PRODUCER","runEndDate":"2018-11-16","runStatus":"Unexpected error executing the"},{"nr":5,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-15","runStatus":"Running"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-15","runStatus":"Job started"},{"nr":4,"loadName":"ESS_EM","subLoadName":"ESS_AP","runEndDate":"2018-11-15","runStatus":"Stopped (with errors)"},{"nr":3,"loadName":"ESS_EM","subLoadName":"ESS_AP","runEndDate":"2018-11-15","runStatus":"Running"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_AP","runEndDate":"2018-11-15","runStatus":"Job started"},{"nr":2,"loadName":"ESS_AP","subLoadName":"ESS_EM_DATA_COPY","runEndDate":"2018-11-15","runStatus":"Running"},{"nr":2,"loadName":"ESS_AP","subLoadName":"ESS_EM_DATA_COPY_BACKLOG_REFRESH","runEndDate":"2018-11-15","runStatus":"Running"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_AP","runEndDate":"2018-11-14","runStatus":"Job started"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-13","runStatus":"Job started"},{"nr":29,"loadName":"ESS_EM","subLoadName":"ESS_AP","runEndDate":"2018-11-13","runStatus":"Job started"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-12","runStatus":"Job started"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-11","runStatus":"Job started"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-10","runStatus":"Job started"},{"nr":30,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-09","runStatus":"Job started"},{"nr":1,"loadName":"ESS_EM","subLoadName":"ESS_EM","runEndDate":"2018-11-09","runStatus":"Stopped (with errors)"}]';

    	google.charts.load('current', {'packages':['annotationchart']});
    	
  		$.ajax({
	        url: "GetFailedJobsServlet_V2",
	        dataType: "JSON",
	        success: function (result) { 
	          google.charts.setOnLoadCallback(function () { 
	        	  drawChart(json);
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
		
		out.println("<div id='chart_div' style='border: 1px solid #ccc'></div>");
		
		out.println("<script type='text/javascript'>");
		out.println("google.charts.load('current', {packages: ['table']}); ");
		out.println("</script>");
		
		
		out.println("<div id='table_div' style='border: 1px solid #ccc'></div>");
		out.println("<input type='button' value='Refresh' onclick='window.location.reload()'> ");

}	
%>
  </body>
</html>