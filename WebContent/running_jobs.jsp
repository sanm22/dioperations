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
    	  
    	  drawTaableChart(result);
      }

    }
    
    function drawBaarChart(result){
    	var data = new google.visualization.DataTable();
        data.addColumn('string', 'Run Date');
        data.addColumn('number', 'No Of Runs');
        var dataArray = [];
        $.each(result, function (i, obj) {
          dataArray.push([obj.runDate, obj.nr])

        });

        data.addRows(dataArray);

        var barchart_options = {
          title: 'Running Jobs',
          width: 470,
          height: 200,
          legend: {
            position: 'top',
            maxLines: 3
          },
          animation: {
            duration: 1000,
            easing: 'out',
          }

        };

        var barchart = new google.visualization.BarChart(document
          .getElementById('barchart_div'));
        
        google.visualization.events.addListener(barchart, 'select',
                selectHandler);
        
        function selectHandler() {

          var selection = barchart.getSelection();

          for (var i = 0; i < selection.length; i++) {
            var item = selection[i];

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
	        	  
	        	  drawTaableChart(result);
	          });
	        }
	      });
    };

	function drawTaableChart(result1) {
		
		hideBarChart();
        
          var cssClassNames = {
            'headerRow': 'italic-darkblue-font large-font bold-font',
            'tableRow': '',
            'oddTableRow': 'beige-background',
            'selectedTableRow': 'orange-background large-font',
            'hoverTableRow': '',
            'headerCell': 'gold-border',
            'tableCell': '',
            'rowNumberCell': 'underline-blue-font'};
          
          
			
          var options = {'showRowNumber': true, 'allowHtml': true, 'cssClassNames': cssClassNames};
          
          var data1 = new google.visualization.DataTable();
          data1.addColumn('string', 'Name');
          data1.addColumn('number', 'Run Date');
          data1.addColumn('boolean', 'Start Time');
          data1.addRows(5);

		
		var dataArray1 = [];
		var i=0;
		
        $.each(result1, function (i1, obj1) {
        	var j=0;
        	data1.setCell(i, j, obj1.runDate);
        	j = j+1;
        	data1.setCell(i, j, obj1.nr);
        	j = j+1;
        	data1.setCell(i, j, true); 
        	i = i+1;
        });
 
        var container1 = document.getElementById('table_div');

		var table1 = new google.visualization.Table(container1);
        table1.draw(data1, options);
        table1.setSelection([{'row': 1}]);   
      }
	

	
function hideTableChart(){
	var x = document.getElementById("table_div");
	x.style.display = "none";
}	


function hideBarChart(){
	var x = document.getElementById("barchart_div");
	x.style.display = "none"; 
	var x = document.getElementById("table_div");
	x.style.display = "block";
	var x = document.getElementById("button_div");
	x.style.display = "block";
}
	
function hideBackButton(){

	var x = document.getElementById("button_div");
	x.style.display = "none";
}	


function enableBackButton(){

	var x = document.getElementById("button_div");
	x.style.display = "block";
}
	
function enableBarChart(){
	var x = document.getElementById("barchart_div");
	x.style.display = "block";
	hideBackButton();
}	
	
function goBackFunc(){ 
	
	enableBarChart();
	hideTableChart();
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
		
		
		out.println("<div id='table_div' style='border: 1px solid #ccc'></div>");
		out.println("<input type='button' value='Back' onclick='goBackFunc()' id='button_div'> ");

}else{
		
}
 
	%>

  </body>

</html>