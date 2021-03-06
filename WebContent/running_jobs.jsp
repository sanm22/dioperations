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

  <script type="text/javascript" src="./charts_js/jquery.min.js"></script>
  <script type="text/javascript" src="./charts_js/loader.js"></script>

  <script type="text/javascript">

    $(document).ready(function () {
 		$.ajax({
	        url: "GetRunningJobsServlet",
	        dataType: "JSON",
	        success: function (result) { 
	          google.charts.setOnLoadCallback(function () {
	        	  hideBackButton();
	        	  drawChart(result);
	          });
	        }
	      })
    });


    function drawChart(result) {
      
      var urlParam = new URLSearchParams(window.location.search).get("P_RUNDATE");
      if(!urlParam){ 
    	  drawBaarChart(result);
      }else{
    	  drawPieChart(result);
      }

    }
    
    function drawBaarChart(result){
    	var data = new google.visualization.DataTable();
        data.addColumn('string', 'Run Date');
        data.addColumn('number', 'No Of Runs');
        var dataArray = [];
        $.each(result, function (i, obj) {
          dataArray.push([obj.loadName, obj.nr])
        });

        data.addRows(dataArray);

        var barchart_options = {
          title: '# Job runs per date',
          width: 470,
          height: 200,
          legend: {
            position: 'bottom',
            maxLines: 3
          },
          animation: {
            duration: 1000,
            easing: 'out',
          }

        };

        var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
        
        google.visualization.events.addListener(barchart, 'select', selectHandler);
        
        function selectHandler() {

          var selection = barchart.getSelection();
		  var item="";
          for (var i = 0; i < selection.length; i++) {
            item = selection[i];
          }
          var value = data.getValue(item.row, item.column);
          var key = dataArray[item.row][0];
          reloadPage(key, value);
          
        }

        barchart.draw(data, barchart_options); 
    }

    function reloadPage(key, value) {
		
      $.ajax({
	        url: "GetRunningJobsServlet?P_RUNDATE=" + key,
	        dataType: "JSON",
	        success: function (result) { 
	    
	          google.charts.setOnLoadCallback(function () {
	        	  drawPieChart(result);
	          });
	        }
	      });
    };

	
function hideTableChart(){
	var x = document.getElementById("table_div");
	x.style.display = "none";
}	


function hideBarChart(){
	var x = document.getElementById("barchart_div");
	x.style.display = "none"; 
	var x = document.getElementById("refresh_button_div");
	x.style.display = "none";
	var x = document.getElementById("piechart");
	x.style.display = "block";
	var x = document.getElementById("back_button_div");
	x.style.display = "block";
}
	
function hideBackButton(){

	var x = document.getElementById("back_button_div");
	x.style.display = "none";
}	


function enableBackButton(){

	var x = document.getElementById("back_button_div");
	x.style.display = "block";
}


function enableRefreshButton(){

	var x = document.getElementById("refresh_button_div");
	x.style.display = "block";
}
	
function enableBarChart(){
	var x = document.getElementById("barchart_div");
	x.style.display = "block";
}	
	
function goBackFunc(){ 
	
	enableBarChart();
	hidePieChart();
	hideBackButton();
	enableRefreshButton();
}

function drawPieChart(result) {
    
	var data = [];
	data.push(['LoadName', '#Runs']);
    $.each(result, function (i1, obj1) {
    	data.push([obj1.loadName, obj1.nr]);
    });
    
    var data_table = google.visualization.arrayToDataTable(data);
    var options = {
      title: '#Job Runs by Load vise on Selected date'
    };

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    //google.visualization.events.addListener(chart, 'select', selectChartHandler);
    
    function selectChartHandler(){

        var item="";
        var selectedItem = chart.getSelection()[0];
        
        /*
        if (selectedItem) {
        	alert(data[selectedItem.row+1]);
        	$.ajax({
    	        url: "GetRunningJobsServlet?P_RUNDATE=" + key,
    	        dataType: "JSON",
    	        success: function (result) { 
    	    
    	          google.charts.setOnLoadCallback(function () {
    	        	  
    	        	  drawPieChart(result);
    	          });
    	        }
    	      });
        	
        }
        
        */
    }
    
    chart.draw(data_table, options);

    hideBarChart();
    enableBackButton();
  }
  
  
  
function hidePieChart(){
	var x = document.getElementById("piechart");
	x.style.display = "none";
}
  </script>


      
    

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



</head>

<% 
 
if( request.getAttribute("P_RUNDATE") == null ) {
		
		out.println("<script type='text/javascript'>");
		out.println("google.charts.load('current', {packages: ['corechart']}); ");
		out.println("</script>"); 
		
		out.println("<div id='barchart_div' style='border: 1px solid #ccc'></div>");
		
		out.println("<script type='text/javascript'>");
		out.println("google.charts.load('current', {packages: ['table']}); ");
		out.println("</script>");
		
		out.println("<div id='piechart' style='border: 1px solid #ccc'></div>"); 
		
		out.println("<input type='button' value='Refresh' onclick='window.location.reload()' id='refresh_button_div'> ");
		out.println("<input type='button' value='Back' onclick='goBackFunc()' id='back_button_div'> ");

}else{
		
}
 
	%>

  </body>

</html>