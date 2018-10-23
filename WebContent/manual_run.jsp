<%@page import="com.logitech.operationmart.beans.Webresult"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="./images/64px-Logitech.svg.png" />
<title>D&I Operations</title>


<meta charset="ISO-8859-1">
<!-- <meta http-equiv="refresh" content="300" /> -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/color.css">

<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/mui.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

<link rel="stylesheet" type="text/css" href="css/iframe.css">
<link rel="stylesheet" type="text/css" href="css/sam.css">

<script defer src="js/material_js.js"></script>
<script defer src="js/mui.min.js"></script>
<script defer src="js/table.js"></script>

<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="js/subload-name.js" type="text/javascript"></script>
<script src="js/job-name.js" type="text/javascript"></script>
<script src="./mateen_js/sam.js" type="text/javascript"></script>

<style type="text/css">
#main {
	width: 18%;
	float: left;
}


.dropbtn_job {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropbtn_job:hover, .dropbtn_job:focus {
    background-color: #3e8e41;
}


</style> 
<script src="https://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>



<script type="text/javascript">
 	var globalResult = null;
	$(document).ready(function() {
		
		var valueRunRepoJob = document.getElementById("run_repo_job"); 
		valueRunRepoJob.style.display = "none";
		
// 		var loadNames = new Set();
// 		var subjectAreaNames = new Set();
// 		var jobNames = new Set();
		

		
		$.ajax({
	        url: "GetFormattedLoads",
	        dataType: "JSON",
	        success: function (result) { 
	        	globalResult = result;
	          	doUnParse(result);
	        }
	      });
	      
		function doUnParse(result){
			
			var dataArrayLN = [];
			var dataArraySA = [];
			var dataArrayJP = [];
			var dataArrayAJ = [];
			
			$.each(result, function (i, obj) { 

				if(dataArrayLN.includes(obj.loadName) != true){
					dataArrayLN.push(obj.loadName);
				}
				if(dataArraySA.includes(obj.subjectAreaName) != true){
					dataArraySA.push(obj.subjectAreaName);
				}
				if(dataArrayJP.includes(obj.jobPath) != true){
					dataArrayJP.push(obj.jobPath);
				}
				if(dataArrayAJ.includes(obj.jobName) != true){
					dataArrayAJ.push(obj.jobName);
				}
				 
		     });


			
			$("#load").select2({
			  data: dataArrayLN
			});
			
			$("#subject").select2({
				  data: dataArraySA
				});
			
			$("#path").select2({
				  data: dataArrayJP
				});
			
			$("#job").select2({
				  data: dataArrayAJ
				});
			
			$("#repoJobs").select2({
				  data: dataArrayAJ
				});
			
		}
		 
		
		
	});
 
</script>
<script type="text/javascript">
function hideDropDowns(){ 
	
	 
	var x = document.getElementById("txtbx");
	var y = document.getElementById("run_repo_job");
	
	if(document.getElementById("selectbx").checked){
		x.style.display = "none";
		y.style.display = "block";
	}else{
		x.style.display = "block";
		y.style.display = "none";
	}
	
}

function reloadSubjectAreaOptions(loadNameSelected){
	
	$('#subject').empty();
	var set = new Set();
	set.add(" --- ");
	$.each(globalResult, function(i, obj){

		if(obj.loadName == loadNameSelected){ 
			set.add(obj.subjectAreaName);
		}
	}); 
	set.forEach(appendSubject);   
	$('#subject').val('---');
}

function appendSubject(value){ 
	$('#subject').append("<option value="+value+">"+value+"</option>");
}

function reloadJobPathOptions(subjectAreaSelected){
	
	$('#path').empty();
 	var set = new Set();
 	set.add(" --- ");
	$.each(globalResult, function (i, obj) {		
		if(obj.subjectAreaName == subjectAreaSelected){
			set.add(obj.jobPath);
		}
	});
	
	set.forEach(appendPaths);
	$('#path').val('---');
}

function appendPaths(value){  

	$('#path').append('<option value="'+ value +'">'+ value +'</option>');
}

function reloadJobNameOptions(path){
	
 	$('#job').empty();
 	var set = new Set();
 	set.add(" --- ");
	$.each(globalResult, function (i, obj) {		
		if(obj.jobPath == path){
			set.add(obj.jobName);
		}
	});
	
	set.forEach(appendJobs);
	 
	$('#job').val('---');
}

function appendJobs(value){  
	$('#job').append("<option value="+value+">"+value+"</option>"); 
}

</script>
<script type="text/javascript">


function validateFormJSFunc(){
	
	
	var load = document.forms["runJbFrm"]["load"].value;
	var subject = document.forms["runJbFrm"]["subject"].value; 
	var path = document.forms["runJbFrm"]["path"].value; 
	var job = document.forms["runJbFrm"]["job"].value;
	
	var retValue = true;
	
	if(!load || load == " --- "){
		$("#load").css({"background":"#f2e8f1"});
		alert("Please select Load Name");
		retValue = false;
	} 
	if(!subject || subject == " --- "){
		$("#subject").css({"background":"#f2e8f1"});
		alert("Please select Subject Area");
		retValue = false;
	}
	if(!path || path == " --- "){
		$("#path").css({"background":"#f2e8f1"});
		alert("Please select Job Path");
		retValue = false;
	}
	if(!job || job == " --- "){
		alert("Please select Job Name");
		$("#job").css({"background":"#f2e8f1"});
		retValue = false;
	}
	 
	return retValue;
	
}

	 

</script>
<script> 
    $(function(){
      $("#leftMenu").load("leftMenu.html"); 
    });
</script> 
</head>
<body>
	<!-- onload="preventBack()" -->
	<%@ page
		import="com.pentaho.dao.*,java.util.*,com.pentaho.bean.*,java.sql.*,javax.servlet.http.*"%>

		<% 
		if (session.getAttribute("name") != null) {
			String name = (String) session.getAttribute("name");
		}

	%>



			<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
				<header class="mdl-layout__header">
					<div class="mdl-layout__header-row">
						<!-- Title -->
						<img src="images/logitech_new.jpg">
						<h5 style="font-family: sans-serif; text-align: center; padding-left: 32%">D&I Operations</h5>

						<!-- <img style="margin-left: 20.5%; padding-left: 32%" src="images/dI_operation.png" height="30" width="30"> -->




						<a style="margin-left: 35.5%; padding-right: 5px">
						<img id="id01" src="images/refresh1.jpg" height="30" width="30" >
						</a> <!-- onclick="refresh()" disabled by Mateen -->
      <img src="images/user.png" align="right" onclick="document.getElementById('id01').style.display='block'"
					style="width: auto; margin-top: 5mm; margin-bottom: 3mm; margin-right: 4mm">

						<form action="LogoutServlet" method="post">
							<input type="image" src="images/logout_button.png" alt="Submit" width="30" height="30">
						</form>
					</div>
				</header> 

				<div style="height: 85%;">
				<div id = "leftMenu">  </div>

			<!-- Mateen Logic goes here -->
			<h5>Adhoc Run</h5>
 			<div style="text-align: left" style="">
				<form name="runJbFrm" action="ManualJBRunner" method="post" onsubmit="return validateFormJSFunc()">
		 			 <input type="radio" name="adhocrun" value="ws" checked> Web Service 
		  			 <input type="radio" name="adhocrun" value="kt"> Kitchen Command<br>
		  			 
		  			 <div id="txtbx">
		  			 <br><br>Select Load &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
		  			 <select id="load" name="load" style="width:400px;" onchange="reloadSubjectAreaOptions(this.value)" ></select>
					 <br><br>Select Subject Area &nbsp &nbsp 
					 <select id="subject" name="subject" style="width:400px;" onchange="reloadJobPathOptions(this.value)">  </select>
					 <br><br>Select Job Path &nbsp &nbsp &nbsp &nbsp &nbsp 
					 <select id="path" name="path" style="width:400px;" onchange="reloadJobNameOptions(this.value)"> </select>
					 <br><br>Select Job &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp 
					 <select id="job" name="job" style="width:400px;" > </select>
					 </div>
					 
					 <br><br><input type="checkbox" name="lscmdrun" onchange="hideDropDowns()" id="selectbx">Select jobs from repository<br> 
					
					 
					<div id='run_repo_job'> 
						<br><br>Select Repo Job &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
						<select id="repoJobs" style="width:400px;"></select>
					</div>
					 
 					<br><br><input type="submit" value="Submit" name="subscribe" class="dropbtn_job">
		 		</form>
		 	 
		 		<br>
		 		
		 		<%
		 		if (request.getAttribute("MANUAL_JOB_RUNNER_STATUS") != null){
		 			
		 			Webresult result = (Webresult) request.getAttribute("MANUAL_JOB_RUNNER_STATUS");
		 			
		 			out.println("<p>Run Status from Server</p>");
		 			out.println("<textarea rows='40' cols='20' style='width:700px;'> ");
			 		out.println("Job Name:"+ request.getParameter("path") + request.getParameter("job"));
		 			out.println("Result  : "+result.getResult());
			 		out.println("Message : "+result.getMessage());
			 		out.println("Check BIOPS_MANUAL_RUNS table for more details");
		 			out.println("</textarea>");
		 			
		 			
		 		}
		 		%>
	 		</div> 	 
	 		</div>
	 	
	 
	 		
	</div>
 
 
</body>
</html>