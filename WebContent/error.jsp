<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="css/color.css">
<script defer src="js/material_js.js"></script>
<head>
<link rel="shortcut icon" href="./images/64px-Logitech.svg.png" />
<title>D&I Operations</title>
</head>
<body>

	<%@ page import="javax.servlet.http.*"%>
	<%
		if (session.getAttribute("name") != null)
			response.sendRedirect("dashboard.jsp");
		else {
	%>

	<div class="mdl-layout mdl-js-layout">
		<header class="mdl-layout__header">
			<div align="center" style="height: 10mm">
				<img align="middle" src="images/logitech_new.jpg"
					style="width: auto; margin-top: 3mm; margin-bottom: 4mm;"> <img
					src="images/user.png" align="right"
					onclick="document.getElementById('id01').style.display='block'"
					style="width: auto; margin-top: 5mm; margin-bottom: 3mm; margin-right: 4mm">
			</div>
		</header>
	</div>

	<div id="id01" class="modal">
		 <br> you have hit an error </br>
	</div> 
	<%
		}
	%>
</body>
</html>
