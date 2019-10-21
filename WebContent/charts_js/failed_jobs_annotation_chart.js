/*
 * Author: Mateen SA
 * Date:   29-Oct-2018 
 * Desc: Created for displaying bubble chart for failed jobs ../failed_jobs.jsp
 */

//Draws bubble chart with result from GetFailedJobsServlet servlet json
	       
      function drawChart(json) {
    	  
        var data = new google.visualization.DataTable();
        data.addColumn('date', 'Run Date');
        data.addColumn('number', '#Etl Errors');
        data.addColumn('string', 'Load Name');
        data.addColumn('string', 'Sub Load Name');
        data.addColumn('number', '#Failures');
        data.addColumn('string', 'Error Description');
        var nAr=[];
        const handlerArray = [];
        $.each(json, function (i1, obj1) {
        	nArr=[new Date(obj1.runEndDate), obj1.nrEtlErrors, obj1.loadName, obj1.subLoadName,  obj1.nrKtlErrors, obj1.runStatus]
	    	data.addRows([nArr]);
        	handlerArray.push(nArr);
	    });

        var chart = new google.visualization.AnnotationChart(document.getElementById('chart_div'));
        google.visualization.events.addListener(chart, 'select', selectHandler);
        
        
        
        
        function selectHandler( ) {

            var selectedItem = chart.getSelection()[0];
            if (selectedItem) {
              var value = data.getValue(selectedItem.row, selectedItem.column);
              reloadPage('DrawTableChart', handlerArray[selectedItem.row]);
            }
          }
        
        var options = {
          displayAnnotations: true
          , annotationsWidth: 35
          , displayAnnotationsFilter: true
          , displayRangeSelector: true
          , displayZoomButtons: true
          , legendPosition: 'newRow'
          , displayExactValues: true
        };

        chart.draw(data, options);
        
        hideComponent('back_button_div');
        
        function reloadPage(key, value) {

        	hideComponent('chart_div');
        	hideComponent('refresh_button_div');
        	unHideComponent('back_button_div');
        	
        	var strUrl="GetFailedJobsServlet_V2?P_RUNDATE=" + value[0].toDateString()+"&P_LOADNAME="+value[2]+"&P_SUBLOADNAME="+value[3]+"&P_RUNSTATUS="+value[5];
        	if(key == 'DrawTableChart'){
        		$.ajax({
        	    	url: strUrl,
        	    	dataType: "JSON",
        		    success: function (result) {
        		    	google.charts.setOnLoadCallback(function () {
        		    		 
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
        		    			      data1.addColumn('string', 	'Load Name');
        		    			      data1.addColumn('string', 	'SubLoad Name');
        		    			      data1.addColumn('string', 	'Job Name');
        		    			      data1.addColumn('datetime', 	'Start Date');
        		    			      data1.addColumn('datetime', 	'End Date');
        		    			      data1.addColumn('string', 	'Run Status');
        		    			      console.log(Object.keys(data1).length);
        		    			      data1.addRows(Object.keys(data1).length); 
        		    				
        		    				var dataArray1 = [];
        		    				var i=0;
        		    				var dbDateFormat = 'MMM DD, YYYY hh:mm:ss A';
        		    				
        		    			    $.each(result, function (i1, o) {
        		    			    	var j=0;
        		    			    	data1.setCell(i, j, o.loadName);
        		    			    	j = j+1;
        		    			    	data1.setCell(i, j, o.subLoadName);
        		    			    	j = j+1;
        		    			    	var jobname = o.jobName;
        		    			    	data1.setCell(i, j, jobname.substring(jobname.lastIndexOf("/")+1 , jobname.length));
        		    			    	j = j+1;
        		    			    	data1.setCell(i, j, new Date(o.runStartDate));
        		    			    	j = j+1;
        		    			    	data1.setCell(i, j, new Date(o.runEndDate));
        		    			    	j = j+1;
        		    			    	data1.setCell(i, j, o.runStatus);
        		    			    	i = i+1;
        		    			    });

        		    			    var container1 = document.getElementById('table_div');

        		    				var table1 = new google.visualization.Table(container1);
        		    				data1.addRows(dataArray1);
        		    			    table1.draw(data1, options);
        		    			    table1.setSelection([{'row': 1}]);   
        		    		
        		    	}
        		    	
        		    	);
        		    	 
        		    }
        		 });
        	}
        	
        	

        }

        function hideComponent(divElement){
        	document.getElementById(divElement).style.display = "none";
        }
        
        function unHideComponent(divElement){
        	document.getElementById(divElement).style.display = "block";
        }
        
      }
      
  	
function goBackFunc(){

	hideComponent('table_div');
	unHideComponent('chart_div');
	hideComponent('back_button_div');
	unHideComponent('refresh_button_div');

}

function hideComponent(divElement){
	document.getElementById(divElement).style.display = "none";
}

function unHideComponent(divElement){
	document.getElementById(divElement).style.display = "block";
}