<!DOCTYPE html>
<html>

<head>
<link rel="shortcut icon" href="./images/64px-Logitech.svg.png" />
<title>D&I Operations</title>
	<meta charset="ISO-8859-1">
<!-- 	<meta http-equiv="refresh" content="300" /> --> <!-- Disbled auto refresh for development by Mateen -->
	<link rel="stylesheet" href="css/color.css">
	<link rel="stylesheet" href="css/table.css">
	<link rel="stylesheet" href="css/mui.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/iframe.css">

	<script src="js/jquery-1.11.1.js" type="text/javascript"></script>

	<style type="text/css">
		#main {
			width: 18%;
			float: left;
		}
	</style>

 

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
 
				 
 					
					<iframe src="./running_loads.jsp"></iframe>
 
					<iframe src="./running_jobs.jsp"></iframe>
	 
					<iframe src="./load_status.jsp"></iframe>
		 
					<iframe src="./failed_jobs.jsp"></iframe>
		 
				 
	</div>

</div>


</body>

</html>