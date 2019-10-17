/*
 * Author: Mateen SA
 * Date:   29-Oct-2018 
 * Desc: Created for displaying bubble chart for failed jobs ../failed_jobs.jsp
 */

//Draws bubble chart with result from GetFailedJobsServlet servlet json
	       
      function drawChart(json) {
    	  
        var data = new google.visualization.DataTable();
        data.addColumn('date', 'Run Date');
        data.addColumn('number', 'Number of Failures');
        data.addColumn('string', 'Load Name');
        data.addColumn('string', 'Sub Load Name');
        data.addColumn('number', 'Number of Failures');
        data.addColumn('string', 'Error Description');
        
        $.each(JSON.parse(json), function (i1, obj1) {
	    	   var nArr=[new Date(obj1.runEndDate), obj1.nr, obj1.loadName, obj1.subLoadName,  obj1.nr, obj1.runStatus]
	    	   data.addRows([nArr]);
	        });

        var chart = new google.visualization.AnnotationChart(document.getElementById('chart_div'));

        var options = {
          displayAnnotations: true
        };

        chart.draw(data, options);
      }