<!DOCTYPE html>
<html>
<head>
<title>D&I Operations</title>
<meta charset="ISO-8859-1">
<meta http-equiv="refresh" content="300" />
<link rel="stylesheet" href="css/color.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/mui.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

<script defer src="js/material_js.js"></script>
<script defer src="js/mui.min.js"></script>
<script defer src="js/table.js"></script>

<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="js/subload-name.js" type="text/javascript"></script>
<script src="js/job-name.js" type="text/javascript"></script>


<style type="text/css">
#main {
	width: 18%;
	float: left;
}
</style>
</head>
<body>
	<!-- onload="preventBack()" -->
	<%@ page
		import="com.pentaho.dao.*,java.util.*,com.pentaho.bean.*,java.sql.*,javax.servlet.http.*"%>

	<% 
		if (session.getAttribute("name") != null) {
			String name = (String) session.getAttribute("name");
	%>

	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<!-- Title -->
				<img src="images/logitech_new.jpg">
				<h5
					style="font-family: sans-serif; text-align: center; padding-left: 32%">D&I
					Operations</h5>
					
					<!-- <img style="margin-left: 20.5%; padding-left: 32%"
					src="images/dI_operation.png" height="30" width="30"> -->
					
					
					

				<a style="margin-left: 40.5%; padding-right: 5px"><img id="id01"
					src="images/refresh1.jpg" height="30" width="30"
					onclick="refresh()"></a>


				<form action="LogoutServlet" method="post">
					<input type="image" src="images/logout_button.png" alt="Submit"
						width="30" height="30">
				</form>
			</div>
		</header>

		<div class="mdl-layout__drawer">
			<a style="margin-left: 37%; margin-top: 3%"><img
				src="images/user.png" height="40" width="40" align="middle"></a> <span
				class="mdl-layout-title"><b>Welcome,<%
 	out.print(" " + WorkbenchDao.name);
 %>
			</b></span>

			<div class="collection">
				<a target="_blank" class="collection-item"
					href="https://docs.google.com/spreadsheets/d/1PtQyACsn78oP2JHDAcN3cXBjH-YD-8UZQwf1Du48QRE/edit?ts=583c0f3f#gid=799538111">AWS
					System Information</a><a target="_blank" class="collection-item"
					href="https://docs.google.com/spreadsheets/d/1RIvy_6PXqnKTNhA5QppU1nRvu7ZrNUx0QePU1xSOv_w/edit#gid=2041287462">Planned
					Weekend Migrations</a> <a target="_blank" class="collection-item"
					href="https://help.logitech.com">JIRA Ticket</a>
			</div>
		</div>
		<div style="height: 85%;">
			<div class="collection" id="main"
				style="float: left; background-color: #e0e0eb; height: 100%">
				<a href="javascript:void(0)" class="collection-item"
					onclick="status(event, 'loadinprogress')" id="defaultOpen">Load
					in progress</a> <a href="javascript:void(0)" class="collection-item"
					onclick="status(event, 'runningJobs')">Running Jobs</a> <a
					href="javascript:void(0)" class="collection-item"
					onclick="status(event, 'loadstatus')">Load status</a> <a
					href="javascript:void(0)" class="collection-item"
					onclick="status(event, 'recentlyfailed')">Recently failed</a>
				<hr>
				<a href="javascript:void(0)" class="collection-item"
					onclick="status(event, 'script')">Run ETL Manually</a> <a
					href="entry.jsp" class="collection-item">Add New Job</a>

			</div>
			<div
				style="height: 90%; width: 76%; float: right; background-color: #e0e0eb; margin-bottom: 3%; margin-right: 3%; margin-top: 3%; border-radius: 10px; overflow: y">
				<%
					List<BiopsLoadStatus> workbenchList = WorkbenchDao.getLoadInProgress();
						Iterator<BiopsLoadStatus> itr = workbenchList.iterator();
						if (workbenchList.size() > 33) {
				%>
				<div id="loadinprogress" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">
					<table id="alter" border="1">
						<tr
							style="font-variant: small-caps; background: rgb(63, 81, 181);">
						<thead>
							<tr style="font-variant: small-caps;">
								<th>Run date</th>
								<th>Load name</th>
								<th>Int Load name</th>
								<th>Start status</th>
								<th>Completion status</th>
								<th>Failed status</th>
								<th>Message</th>
							</tr>
						</thead>
						<%
							if (itr.hasNext() == false) {
						%><tr>
							<td colspan="7">No data found !!</td>
						</tr>
						<%
							} else {
										while (itr.hasNext()) {
											BiopsLoadStatus workbench = itr.next();
						%>
						<tr>
							<td><%=workbench.getRunDate()%></td>
							<td><%=workbench.getLoadName()%></td>
							<td><%=workbench.getIntLoadName()%>
							<td><%=workbench.getStartStatus()%>
							<td><%=workbench.getCompletionStatus()%></td>
							<td><%=workbench.getFailedStatus()%></td>
							<td><%=workbench.getMessage()%>
						</tr>
						<%
							}
									}
						%>
					</table>
				</div>

				<%
					} else {
				%>
				<div id="loadinprogress" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">

					<table id="alter" border="1">
						<tr style="font-variant: small-caps;">
						<thead>
							<tr style="font-variant: small-caps;">
								<th>Run date</th>
								<th>Load name</th>
								<th>Int Load name</th>
								<th>Start status</th>
								<th>Completion status</th>
								<th>Failed status</th>
								<th>Message</th>
							</tr>
						</thead>
						<%
							if (itr.hasNext() == false) {
						%><tr>
							<td colspan="7">No data found !!</td>
						</tr>
						<%
							} else {
										while (itr.hasNext()) {
											BiopsLoadStatus workbench = itr.next();
						%>
						<tr>
							<td><%=workbench.getRunDate()%></td>
							<td><%=workbench.getLoadName()%></td>
							<td><%=workbench.getIntLoadName()%>
							<td><%=workbench.getStartStatus()%>
							<td><%=workbench.getCompletionStatus()%></td>
							<td><%=workbench.getFailedStatus()%></td>
							<td><%=workbench.getMessage()%>
						</tr>
						<%
							}
									}
						%>
					</table>
				</div>

				<%
					}
						List<MasterEtlRuntimeStats> workbenchList2 = WorkbenchDao.getRunningJobs();
						Iterator<MasterEtlRuntimeStats> itr2 = workbenchList2.iterator();
						if (workbenchList2.size() > 33)

						{
				%>
				<div id="runningJobs" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">

					<table id="alter" border="1">
						<tr style="font-variant: small-caps;">
						<thead>
							<tr style="font-variant: small-caps;">
								<th>Run date</th>
								<th>Load name</th>
								<th>Subject area name</th>
								<th>Job name</th>
								<th>Start status</th>
								<th>Completion status</th>
								<th>Start time</th>
								<th>Load schedule</th>
							</tr>
						</thead>

						<%
							if (itr2.hasNext() == false) {
						%><tr>
							<td colspan="15">No data found !!</td>

						</tr>
						<%
							} else {
										while (itr2.hasNext()) {
											MasterEtlRuntimeStats workbench2 = itr2.next();
						%>
						<tr>
							<td width="50"><%=workbench2.getRunDate()%></td>
							<td><font face="Arial"><%=workbench2.getLoadName()%></font></td>
							<td><%=workbench2.getSubjectAreaName()%></td>
							<td><%=workbench2.getJobName()%></td>
							<td><%=workbench2.getStartStatus()%>
							<td><%=workbench2.getCompletionStatus()%></td>
							<td><%=workbench2.getStartTime()%></td>
							<td><%=workbench2.getLoadSchedule()%></td>
						</tr>
						<%
							}
									}
						%>
					</table>
				</div>
				<%
					} else {
				%>
				<div id="runningJobs" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">

					<table id="alter" border="1">
						<tr style="font-variant: small-caps;">
						<thead>
							<tr style="font-variant: small-caps;">
								<th>Run date</th>
								<th>Load name</th>
								<th>Subject area name</th>
								<th>Job name</th>
								<th>Start status</th>
								<th>Completion status</th>
								<th>Start time</th>
								<th>Load schedule</th>
							</tr>
						</thead>

						<%
							if (itr2.hasNext() == false) {
						%><tr>
							<td colspan="15">No data found !!</td>

						</tr>
						<%
							} else {
										while (itr2.hasNext()) {
											MasterEtlRuntimeStats workbench2 = itr2.next();
						%>
						<tr>
							<td width="50"><%=workbench2.getRunDate()%></td>
							<td><font face="Arial"><%=workbench2.getLoadName()%></font></td>
							<td><%=workbench2.getSubjectAreaName()%></td>
							<td><%=workbench2.getJobName()%></td>
							<td><%=workbench2.getStartStatus()%>
							<td><%=workbench2.getCompletionStatus()%></td>
							<td><%=workbench2.getStartTime()%></td>
							<td><%=workbench2.getLoadSchedule()%></td>
						</tr>
						<%
							}
									}
						%>
					</table>
				</div>

				<%
					}
						List<BiopsLoadStatus> workbenchList3 = WorkbenchDao.getLastAndCurrentDayLoadStatus();
						Iterator<BiopsLoadStatus> itr3 = workbenchList3.iterator();
						if (workbenchList3.size() > 33)

						{
				%>

				<div id="loadstatus" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">


					<table id="alter" border="1">
						<thead>
							<tr style="font-variant: small-caps;">
								<th>Run date</th>
								<th>Load name</th>
								<th>Int Load name</th>
								<th>Start status</th>
								<th>Completion status</th>
								<th>Failed status</th>
								<th>Message</th>
							</tr>
						</thead>
						<%
							if (itr3.hasNext() == false) {
						%><tr>

							<td colspan="7">No data found !!</td>

						</tr>
						<%
							} else {
										while (itr3.hasNext()) {
											BiopsLoadStatus workbench3 = itr3.next();
						%>
						<tbody>
							<tr>
								<td><%=workbench3.getRunDate()%></td>
								<td><font face="Arial"><%=workbench3.getLoadName()%></font></td>
								<td><%=workbench3.getIntLoadName()%>
								<td><%=workbench3.getStartStatus()%>
								<td><%=workbench3.getCompletionStatus()%></td>
								<td><%=workbench3.getFailedStatus()%></td>
								<td><%=workbench3.getMessage()%>
							</tr>
							<%
								}
										}
							%>
						</tbody>
					</table>
				</div>
				<%
					} else {
				%>
				<div id="loadstatus" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">

					<table id="alter" border="1">
						<thead>
							<tr style="font-variant: small-caps;">
								<th>Run date</th>
								<th>Load name</th>
								<th>Int Load name</th>
								<th>Start status</th>
								<th>Completion status</th>
								<th>Failed status</th>
								<th>Message</th>
							</tr>
						</thead>
						<%
							if (itr3.hasNext() == false) {
						%><tr>

							<td colspan="7">No data found !!</td>

						</tr>
						<%
							} else {
										while (itr3.hasNext()) {
											BiopsLoadStatus workbench3 = itr3.next();
						%>
						<tbody>
							<tr>
								<td><%=workbench3.getRunDate()%></td>
								<td><font face="Arial"><%=workbench3.getLoadName()%></font></td>
								<td><%=workbench3.getIntLoadName()%>
								<td><%=workbench3.getStartStatus()%>
								<td><%=workbench3.getCompletionStatus()%></td>
								<td><%=workbench3.getFailedStatus()%></td>
								<td><%=workbench3.getMessage()%>
							</tr>
							<%
								}
										}
							%>
						</tbody>
					</table>
				</div>
				<%
					}
						List<MasterEtlRuntimeStats> workbenchList4 = WorkbenchDao.getLast20FailedJobs();
						Iterator<MasterEtlRuntimeStats> itr4 = workbenchList4.iterator();
						if (workbenchList4.size() > 33) {
				%>
				<div id="recentlyfailed" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">
					<table id="alter" border="1">
						<tr style="font-variant: small-caps;">
							<th>Run date</th>
							<th>Load name</th>
							<th>Subject area name</th>
							<th>Job name</th>
							<th>Start status</th>
							<th>Completion status</th>

							<th>Message</th>
							<th>Start time</th>
							<th>Failed time</th>
							<th>Load schedule</th>
						</tr>
						<%
							if (itr4.hasNext() == false) {
						%><tr>
							<td colspan="15">No data found !!</td>

						</tr>
						<%
							} else {
										while (itr4.hasNext()) {
											MasterEtlRuntimeStats workbench4 = itr4.next();
						%>
						<tr>
							<td width="50"><%=workbench4.getRunDate()%></td>
							<td><font face="Arial"><%=workbench4.getLoadName()%></font></td>
							<td><%=workbench4.getSubjectAreaName()%></td>
							<td><%=workbench4.getJobName()%></td>
							<td><%=workbench4.getStartStatus()%>
							<td><%=workbench4.getCompletionStatus()%></td>

							<td><%=workbench4.getStartTime()%></td>
							<td><%=workbench4.getFailedTime()%></td>
							<td><%=workbench4.getMessage()%></td>
							<td><%=workbench4.getLoadSchedule()%></td>
						</tr>
						<%
							}
									}
						%>
					</table>
				</div>

				<%
					} else {
				%>
				<div id="recentlyfailed" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">
					<table id="alter" border="1">
						<tr style="font-variant: small-caps;">
							<th>Run date</th>
							<th>Load name</th>
							<th>Subject area name</th>
							<th>Job name</th>
							<th>Start status</th>
							<th>Completion status</th>

							<th>Start time</th>
							<th>Failed time</th>
							<th>Message</th>
							<th>Load schedule</th>
						</tr>
						<%
							if (itr4.hasNext() == false) {
						%><tr>
							<td colspan="15">No data found !!</td>

						</tr>
						<%
							} else {
										while (itr4.hasNext()) {
											MasterEtlRuntimeStats workbench4 = itr4.next();
						%>
						<tr>
							<td width="50"><%=workbench4.getRunDate()%></td>
							<td><font face="Arial"><%=workbench4.getLoadName()%></font></td>
							<td><%=workbench4.getSubjectAreaName()%></td>
							<td><%=workbench4.getJobName()%></td>
							<td><%=workbench4.getStartStatus()%>
							<td><%=workbench4.getCompletionStatus()%></td>

							<td><%=workbench4.getStartTime()%></td>
							<td><%=workbench4.getFailedTime()%></td>
							<td><%=workbench4.getMessage()%></td>
							<td><%=workbench4.getLoadSchedule()%></td>
						</tr>
						<%
							}
									}
						%>
					</table>
				</div>

				<%
					}
				%>
				<div id="script" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 100%;">
					<%
						List<MasterEtlLoadControl> workbenchList0 = ShellScripting.getLoadName();
							Iterator<MasterEtlLoadControl> itr0 = workbenchList0.iterator();
					%>
					<br> <br> <br> <br>

					<form class="mui-form" action="Script" method="post">

						<div class="mui-select">
							<select id="load1">
								<option>Select Load Name</option>
								<%
									while (itr0.hasNext()) {
											MasterEtlLoadControl workbench = itr0.next();
											String load = workbench.getLoadName();
								%>
								<option value="<%=load%>"><%=load%></option>
								<%
									}
								%>
							</select> <label> Load Name</label>
						</div>

						<div class="mui-select">
							<select id="subLoad">
								<option>Select Sub Load Name</option>
							</select> <label>Sub Load Name</label>
						</div>

						<div class="mui-select">
							<select id="jobName">
								<option>Select Job Name</option>
							</select> <label>Job Name</label>
						</div>

						<input type="submit" name="button1" id="script" value="Submit"
							onclick="scriptClick()"
							class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="background-color: rgb(63, 81, 181); color: white;" />
					</form>


				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		
		var modal = document.getElementById('id02');
		document.getElementById("defaultOpen").click();
		function status(evt, tabName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(tabName).style.display = "block";
			evt.currentTarget.className += " active";
		}
		function refresh() {
			location.reload();

			var img = document.getElementById("id01");
			img.setAttribute("class", "rotated-image");

			var modal = document.getElementById('id01').style.display = 'block';

		}
		document.onreadystatechange = function() {
			var state = document.readyState
			if (state == 'interactive') {
				document.getElementById('contents').style.visibility = "hidden";
			} else if (state == 'complete') {
				setTimeout(
						function() {
							document.getElementById('interactive');
							document.getElementById('load').style.visibility = "hidden";
							document.getElementById('contents').style.visibility = "visible";
						}, 1000);
			}
		}

		function preventBack() {
			window.history.forward();
		}
		setTimeout("preventBack()", 0);
		window.onunload = function() {
			null
		};
	</script>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#jobName").change(function(event) {
				var value = $(this).val();

				$.ajax({
					url : 'JsonServlet',
					data : {
						jobName : value
					},
					type : 'GET'
				});
			});
		});
	</script>

	<%
		}

		else {
	%>
	<script type="text/javascript">
		alert("Invalid UserName/Password !!");
		window.location = "index.jsp";
	</script>
	<%
		}
	%>

</body>
</html>