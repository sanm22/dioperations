<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="./images/64px-Logitech.svg.png" />
<title>D&I Operations</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/color.css">
<link rel="stylesheet" href="css/table.css">
<link rel="stylesheet" href="css/tde_table.css">

<script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="./js/moment.js" type="text/javascript"></script>
<script>
	$(function() {
		$("#leftMenu").load("leftMenu.html");
		$("#headerMenu").load("headerMenu.html");
	});
</script>

 
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<style type='text/css'>
  .bold-green-font {
    font-weight: bold;
    color: green;
  }

  .bold-font {
    font-weight: bold;
  }

  .right-text {
    text-align: right;
  }

  .large-font {
    font-size: 15px;
  }

  .italic-darkblue-font {
    font-style: italic;
    color: darkblue;
  }

  .italic-purple-font {
    font-style: italic;
    color: purple;
  }

  .underline-blue-font {
    text-decoration: underline;
    color: blue;
  }

  .gold-border {
    border: 3px solid gold;
  }

  .deeppink-border {
    border: 3px solid deeppink;
    font-family: "Times New Roman", Times, serif;
    font-size: small;
  }

  .orange-background {
    background-color: orange;
  }

  .orchid-background {
    background-color: orchid;
  }

  .beige-background {
    background-color: beige;
  }

</style>

<script type="text/javascript">
	google.charts.load('current', {'packages':['table']});
	
	$(document).ready(function () {
		$.ajax({
        url: "TDEOperations",
        dataType: "JSON",
        success: function (result) { 
          google.charts.setOnLoadCallback(function () {
        	  drawTable(result);
          });
        }
      })
	});
 	
	function drawTable(result) {
		
		var cssClassNames = {
			'headerRow' : 'italic-darkblue-font bold-font', 
			'oddTableRow' : 'beige-background',
			'selectedTableRow' : 'orange-background large-font',
			'hoverTableRow' : '',
			'headerCell' : 'gold-border',
			'tableCell' : '',
			'rowNumberCell' : 'underline-blue-font'
		};


		var options = {
			'showRowNumber' : true,
			'allowHtml' : true,
			'cssClassNames' : cssClassNames,
			 width: '80%', 
			 height: '50%'
		};

		
		var data = new google.visualization.DataTable();

		data.addColumn('string', 'Load Name');
	    data.addColumn('string', 'C Status');
	    data.addColumn('string', 'F Status');
	    data.addColumn('string', 'Run Day');
 	    data.addColumn('string', 'Run Date');
	    data.addColumn('string', 'S Time');
	    data.addColumn('string', 'E Time');
	    data.addColumn('string', 'F Time');
	    data.addColumn('string', 'Nr# in Table');
	    data.addColumn('string', 'Table Audit Timestamp');
	    data.addColumn('string', 'Restart Load'); 
	    
	    data.addRows(8);
		var dbDateFormat = 'MMM DD, YYYY hh:mm:ss A';
	    var i=0;
	    $.each(result, function (i, obj) { 
	    	var j=0;
	    	data.setCell(i, j, obj.loadName, obj.loadName, {'className': 'deeppink-border'});
	    	j = j+1;
	    	data.setCell(i, j, obj.completionStatus, obj.completionStatus, {'className': 'deeppink-border'}); 
	    	j = j+1;
	    	data.setCell(i, j, obj.failedStatus, obj.failedStatus, {'className': 'deeppink-border'}); 
	    	j = j+1;
	    	data.setCell(i, j, obj.runDay, obj.runDay, {'className': 'deeppink-border'}); 
	    	j = j+1;
	    	data.setCell(i, j, '', moment(obj.runDate, dbDateFormat).format('ll'), {'className': 'deeppink-border'}); 
	    	j = j+1;
	    	data.setCell(i, j, '', moment(obj.startTime, dbDateFormat).format('LTS'), {'className': 'deeppink-border'}); 
	    	j = j+1;
	    	data.setCell(i, j, '', moment(obj.endTime, dbDateFormat).format('LTS'), {'className': 'deeppink-border'}); 
	    	j = j+1;
	    	data.setCell(i, j, '', obj.failedTime ? moment(obj.failedTime, dbDateFormat).format('LTS') : '', {'className': 'deeppink-border'});
	    	j = j+1;
	    	data.setCell(i, j, '', "0", {'className': 'deeppink-border'});
	    	j = j+1;
	    	data.setCell(i, j, '', moment(obj.startTime, dbDateFormat).format('lll'), {'className': 'deeppink-border'});
	    	j = j+1;
	    	data.setCell(i, j, '', '<a href=./StartTDELoad?loadName='+obj.loadName+' target=_blank >Restart Load</a>', {'className': 'deeppink-border'});
	    	i = i+1;
	    });
		 
		var container = document.getElementById('table');
		var table = new google.visualization.Table(container);
		table.draw(data, options);
		table.setSelection([ {
			'row' : 4
		} ]);
	}
</script>


</head>
<body>

	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">

		<div id="headerMenu"></div>

		<div style="height: 85%;">
			<div id="leftMenu"></div>

			<!-- Mateen Logic goes here -->
			<h5>Last 2 runs of Tde</h5>
			<div id="table" style="border: 1px solid #ccc"></div>
		</div>
	</div>

</body>
</html>
