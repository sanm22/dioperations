<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
<link rel="shortcut icon" href="./images/64px-Logitech.svg.png" />
<title>D&I Operations</title>
		<meta charset="ISO-8859-1">
		<!-- 	<meta http-equiv="refresh" content="300" /> -->
		<!-- Disbled auto refresh for development by Mateen -->
		<link rel="stylesheet" href="css/color.css">
		<link rel="stylesheet" href="css/table.css">
		<link rel="stylesheet" href="css/mui.min.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/iframe.css">

<!-- 		<script src="js/jquery-1.11.1.js" type="text/javascript"></script> -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

		<script> 
			$(function () {
				$("#leftMenu").load("leftMenu.html");
			});
		</script>

		<style type="text/css">
			#main {
				width: 18%;
				float: left;
			}
		</style>
		<script type="text/javascript">
		$(document).ready(function() {

			$.ajax({
				url : "LoadControlTreeServlet",
				dataType : "JSON",
				
				success : function(result) {
					google.charts.load('current', {
						'packages' : [ 'wordtree' ]
					});
					google.charts.setOnLoadCallback(function() {
						drawChart(result);
					});
				}
			})
		});

		function drawChart(result) {

			var size = 1;
			var data = new google.visualization.DataTable();
			data.addColumn('number', 'id');
			data.addColumn('string', 'dbname');
			data.addColumn('number', 'parent');
			data.addColumn('number', 'size');

			var dataArray = [];
			$.each(result, function(i, obj) {
				dataArray.push([ obj.id, obj.dbname, obj.parent, obj.size,
						obj.style ])
				data.addRow([ obj.id, obj.dbname, obj.parent, obj.size ]);
			});

			var options = {
				maxFontSize : 14,
				wordtree : {
					format : 'explicit',
					type : 'suffix',
					word : 'pentaho_audit'
				}
			};

			var chart = new google.visualization.WordTree(document
					.getElementById('wordtree_basic'));
			chart.draw(data, options);

		}
		</script>
		
		<style type="text/css">
		
		.centered{
		    position:absolute;
		    left:28%;
		    top:20%; 
		    width: 600px;
		    height: 400px;
		}

		</style>
	</head>

	<body>




		<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
			<header class="mdl-layout__header">
				<div class="mdl-layout__header-row">
					<!-- Title -->
					<img src="images/logitech_new.jpg">
					<h5 style="font-family: sans-serif; text-align: center; padding-left: 32%">D&I Operations</h5>

					<!-- <img style="margin-left: 20.5%; padding-left: 32%" src="images/dI_operation.png" height="30" width="30"> -->




					<a style="margin-left: 35.5%; padding-right: 5px">
						<img id="id01" src="images/refresh1.jpg" height="30" width="30">
					</a> <!-- onclick="refresh()" disabled by Mateen -->
					<img src="images/user.png" align="right" onclick="document.getElementById('id01').style.display='block'" style="width: auto; margin-top: 5mm; margin-bottom: 3mm; margin-right: 4mm">

					<form action="LogoutServlet" method="post">
						<input type="image" src="images/logout_button.png" alt="Submit" width="30" height="30">
					</form>
				</div>
			</header>

			<div style="height: 85%;">
				<div id="leftMenu"> </div>
				<!-- Mateen logic goes here -->
				<h5>Tree view for Master Etl Load Control Table</h5>
				<div id="wordtree_basic" class="centered">
				



			</div>

		</div>
	</div>

	</body>

	</html>