<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="./images/64px-Logitech.svg.png" />
<title>D&I Operations</title>
<link rel="stylesheet" href="css/entry.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/entrylist.css">

<script defer src="js/material_js.js"></script>
<script defer src="js/mui.min.js"></script>
<script defer src="js/table.js"></script>

<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="js/new-entry-subload.js" type="text/javascript"></script>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body onload="status(event, 'addJob')">
	<%@ page
		import="com.pentaho.dao.*,java.util.*,com.pentaho.bean.*,java.sql.*,com.pentaho.scripting.*,com.pentaho.servlet.*"%>
	<%
		WorkbenchDao.setValue(true);
		if (session.getAttribute("name") != null) {
			String name = (String) session.getAttribute("name");
	%>
	<div class="mdl1-layout mdl1-js-layout mdl1-layout--fixed-header">
		<header class="mdl1-layout__header">
		<div class="mdl1-layout__header-row">
			<img src="images/logitech_new.jpg">
			<h5
				style="font-family: sans-serif; text-align: center; padding-left: 30%">Add
				New Job</h5>

			<form style="margin-left: 46%" action="LogoutServlet" method="post">
				<input type="image" src="images/logout_button.png" alt="Submit"
					width="30" height="30">
			</form>
		</div>

		</header>
		<br> <br>
		<div
			style="background-color: #e0e0eb; margin-left: 20%; margin-right: 20%; border-radius: 10px;">
			<div id="tabs">
				<ul class="tab">

					<li><a href="javascript:void(0)" style="font-size: 15px;"
						class="tablinks" onclick="status(event, 'addJob')">Add New Job
					</a></li>

					<li><a href="javascript:void(0)" style="font-size: 15px;"
						class="tablinks" onclick="status(event, 'addLoad')"
						id="defaultOpen">Add New Load</a></li>


					<li><a href="javascript:void(0)" style="font-size: 15px;"
						class="tablinks" onclick="status(event, 'addSubLoad')">Add New
							SubLoad</a></li>





				</ul>
			</div>
			<div style="overflow: y;">
				<div id="addJob" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 465px">
					<center>
						<form class="mui-form"
							action="${pageContext.request.contextPath}/AddNewJob"
							method="post">

							<%
								List<MasterEtlLoadControl> workbenchList0 = NewEntry.getLoadName();
									Iterator<MasterEtlLoadControl> itr0 = workbenchList0.iterator();
							%>
							<table width="300px">
								<tr>
									<td width="50%">Load Name</td>
									<td width="50%">

										<div class="mui-select">
											<select id="load11" required>
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
											</select>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Sub Load Name</td>
									<td width="50%">

										<div class="mui-select">
											<select id="subLoad1" name="subLoadName" required>
												<option>Select Sub Load Name</option>
											</select>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Job Name :</td>
									<td width="50%">
										<div class="mui-textfield">
											<input type="text" name="jobName" required>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Job Path:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="jobPath" required>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Load Id:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="loadId" required>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Sub Load Id:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="subLoadId" required>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Job Order:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="jobOrder" required>
										</div>
									</td>
								</tr>

								<%
									List<MasterEtlLoadControl> workbenchList_7 = NewEntry.getEnabledFlg();
										Iterator<MasterEtlLoadControl> itr_7 = workbenchList_7.iterator();
								%>

								<tr>
									<td width="50%">Enabled Flg</td>
									<td width="50%">
										<div class="mui-select">

											<select id="enabledFlg" name="_enabledFlg" required>
												<option>Select Enabled Flg</option>
												<%
													while (itr_7.hasNext()) {
															MasterEtlLoadControl workbench = itr_7.next();
															String flag = workbench.getEnabledFlag();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>

								<%
									List<MasterEtlLoadControl> workbenchList_8 = NewEntry.getJobType();
										Iterator<MasterEtlLoadControl> itr_8 = workbenchList_8.iterator();
								%>

								<tr>
									<td width="50%">Job Type</td>
									<td width="50%">
										<div class="mui-select">

											<select id="jobType" name="_jobType" required>
												<option>Select Job Type</option>
												<%
													while (itr_8.hasNext()) {
															MasterEtlLoadControl workbench = itr_8.next();
															String flag = workbench.getJobType();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>
								<%
									List<MasterEtlLoadControl> workbenchList_9 = NewEntry.getLoadSchedule();
										Iterator<MasterEtlLoadControl> itr_9 = workbenchList_9.iterator();
								%>


								<tr>
									<td width="50%">Load Schedule</td>
									<td width="50%">
										<div class="mui-select">

											<select id="loadSchedule" name="_loadSchedule" required>
												<option>Select Load Schedule</option>
												<%
													while (itr_9.hasNext()) {
															MasterEtlLoadControl workbench = itr_9.next();
															String flag = workbench.getLoadSchedule();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>

							</table>
							<br> <input type="submit"
								class="mdl1-button mdl1-js-button mdl1-button--raised mdl1-js-ripple-effect mdl1-button--accent"
								name="submit" value="Submit">



						</form>
					</center>


				</div>
				<div id="addLoad" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 465px">

					<form action="${pageContext.request.contextPath}/AddLoadSubLoadJob"
						method="post">
						<center>
							<table width="300px">
								<tr>
									<td width="50%">Load Name:</td>
									<td width="50%">
										<div class="mui-textfield">
											<input type="text" name="loadName" required>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Sub-Load Name:</td>
									<td width="50%">
										<div class="mui-textfield">
											<input type="text" name="subLoadName" required>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Job Name:</td>
									<td width="50%">
										<div class="mui-textfield">
											<input type="text" name="jobName" required>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Job Path:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="jobPath" required>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Load Id:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="loadId" required>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Sub Load Id:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="subLoadId" required>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Job Order:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="jobOrder" required>
										</div>
									</td>
								</tr>

								<%
									List<MasterEtlLoadControl> workbenchList_1 = NewEntry.getEnabledFlg();
										Iterator<MasterEtlLoadControl> itr_1 = workbenchList_1.iterator();
								%>

								<tr>
									<td width="50%">Enabled Flg</td>
									<td width="50%">
										<div class="mui-select">

											<select id="enabledFlg" name="_enabledFlg" required>
												<option>Select Enabled Flg</option>
												<%
													while (itr_1.hasNext()) {
															MasterEtlLoadControl workbench = itr_1.next();
															String flag = workbench.getEnabledFlag();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>

								<%
									List<MasterEtlLoadControl> workbenchList_2 = NewEntry.getJobType();
										Iterator<MasterEtlLoadControl> itr_2 = workbenchList_2.iterator();
								%>

								<tr>
									<td width="50%">Job Type</td>
									<td width="50%">
										<div class="mui-select">

											<select id="jobType" name="_jobType" required>
												<option>Select Job Type</option>
												<%
													while (itr_2.hasNext()) {
															MasterEtlLoadControl workbench = itr_2.next();
															String flag = workbench.getJobType();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>
								<%
									List<MasterEtlLoadControl> workbenchList_3 = NewEntry.getLoadSchedule();
										Iterator<MasterEtlLoadControl> itr_3 = workbenchList_3.iterator();
								%>
								<tr>
									<td width="50%">Load Schedule</td>
									<td width="50%">
										<div class="mui-select">

											<select id="loadSchedule" name="_loadSchedule" required>
												<option>Select Load Schedule</option>
												<%
													while (itr_3.hasNext()) {
															MasterEtlLoadControl workbench = itr_3.next();
															String flag = workbench.getLoadSchedule();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>
							</table>
							<br> <input type="submit"
								class="mdl1-button mdl1-js-button mdl1-button--raised mdl1-js-ripple-effect mdl1-button--accent"
								name="submit" value="Submit">
						</center>
					</form>
				</div>
				<div id="addSubLoad" class="tabcontent"
					style="overflow: x; padding: 10px; overflow: y; height: 465px">

					<%
						List<MasterEtlLoadControl> workbenchList1 = ShellScripting.getLoadName();
							Iterator<MasterEtlLoadControl> itr1 = workbenchList1.iterator();
					%>

					<form
						action="${pageContext.request.contextPath}/AddNewSubLoadJobName"
						method="post">
						<center>
							<table width="300px">
								<tr>
									<td width="50%">Load Name</td>
									<td width="50%">
										<div class="mui-select">
											<select id="load11" required>
												<option>Select Load Name</option>
												<%
													while (itr1.hasNext()) {
															MasterEtlLoadControl workbench1 = itr1.next();
															String load = workbench1.getLoadName();
												%>
												<option value="<%=load%>"><%=load%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Sub Load Name:</td>
									<td width="50%">
										<div class="mui-textfield">
											<input type="text" name="subLoadName" required>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Job Name:</td>
									<td width="50%">
										<div class="mui-textfield">
											<input type="text" name="jobName" required>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Job Path:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="jobPath" required>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Load Id:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="loadId" required>
										</div>
									</td>
								</tr>

								<tr>
									<td width="50%">Sub Load Id:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="subLoadId" required>
										</div>
									</td>
								</tr>
								<tr>
									<td width="50%">Job Order:</td>
									<td width="50%">

										<div class="mui-textfield">
											<input type="text" name="jobOrder" required>
										</div>
									</td>
								</tr>

								<%
									List<MasterEtlLoadControl> workbenchList_4 = NewEntry.getEnabledFlg();
										Iterator<MasterEtlLoadControl> itr_4 = workbenchList_4.iterator();
								%>

								<tr>
									<td width="50%">Enabled Flg</td>
									<td width="50%">
										<div class="mui-select">

											<select id="enabledFlg" name="_enabledFlg" required>
												<option>Select Enabled Flg</option>
												<%
													while (itr_4.hasNext()) {
															MasterEtlLoadControl workbench = itr_4.next();
															String flag = workbench.getEnabledFlag();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>

								<%
									List<MasterEtlLoadControl> workbenchList_5 = NewEntry.getJobType();
										Iterator<MasterEtlLoadControl> itr_5 = workbenchList_5.iterator();
								%>

								<tr>
									<td width="50%">Job Type</td>
									<td width="50%">
										<div class="mui-select">

											<select id="jobType" name="_jobType" required>
												<option>Select Job Type</option>
												<%
													while (itr_5.hasNext()) {
															MasterEtlLoadControl workbench = itr_5.next();
															String flag = workbench.getJobType();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>
								<%
									List<MasterEtlLoadControl> workbenchList_6 = NewEntry.getLoadSchedule();
										Iterator<MasterEtlLoadControl> itr_6 = workbenchList_6.iterator();
								%>


								<tr>
									<td width="50%">Load Schedule</td>
									<td width="50%">
										<div class="mui-select">

											<select id="loadSchedule" name="_loadSchedule" required>
												<option>Select Load Schedule</option>
												<%
													while (itr_6.hasNext()) {
															MasterEtlLoadControl workbench = itr_6.next();
															String flag = workbench.getLoadSchedule();
												%>
												<option value="<%=flag%>"><%=flag%></option>
												<%
													}
												%>
											</select>
										</div>
									</td>
								</tr>

							</table>
							<br> <input type="submit"
								class="mdl1-button mdl1-js-button mdl1-button--raised mdl1-js-ripple-effect mdl1-button--accent"
								name="submit" value="Submit">
						</center>
					</form>
				</div>
			</div>

			<center>
				<a href="dashboard.jsp">Click here to go to Dashboard</a>
			</center>


		</div>
	</div>
	<script>
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
	<%
		} else {
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