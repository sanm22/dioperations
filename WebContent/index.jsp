<!DOCTYPE html>
<html>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="css/color.css">
<script defer src="js/material_js.js"></script>
<head><title>D&I Operations</title></head>
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
		<form class="modal-content animate" action="LoginServlet"
			method="post">
			<div class="imgcontainer">
				<img src="images/images.png">
			</div>
			<div class="container">
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="text" id="sample1"
						name="uname" required> <label class="mdl-textfield__label"
						for="sample1">Username</label>
				</div>
				<div class="mdl-textfield mdl-js-textfield">
					<input class="mdl-textfield__input" type="password" id="sample1"
						name="psw" required> <label class="mdl-textfield__label"
						for="sample1">Password</label>
				</div>
				<button
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
					type="submit" onsubmit="ShowLoading()">Login</button>

				<input type="checkbox" checked="checked"
					style="font-family: verdana; margin-top: 2mm;">Remember me
			</div>
			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					style="background-color: red; height: auto; width: auto;"
					class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
					onclick="document.getElementById('id01').style.display='none'">Cancel</button>
			</div>
		</form>
	</div>
	<script>
		var modal = document.getElementById('id01');
	</script>
	<%
		}
	%>
</body>
</html>
