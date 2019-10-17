/*
 * Author: Mateen SA
 * Date:   29-Oct-2018 
 * Desc: Created for displaying bubble chart for failed jobs ../failed_jobs.jsp
 */

//Draws bubble chart with result from GetFailedJobsServlet servlet json
function drawChart(result) {
	
	var urlParam = new URLSearchParams(window.location.search).get("P_RUNDATE");
	if (!urlParam) {
		drawBubbles(result);
	} else { 
		drawTaableChart(result);
	}

}

function drawBubbles(result) {
	
	let rowNum = 0;
	var dataArray =   [['ID','Run Date'				,'#Failures'	,'Load Name', 'Is Daily Load'	]]; //	,'Subject Area'		,'Load Schedule'	,'Job Name' 	,'Start Time'	,'Failed Time']];
	$.each(result, function(rowNum, obj) {
		var isDaily = -1;
		if(obj.loadSchedule == "DAILY"){
			isDaily=1;
		}else{
			isDaily=0;
		}
		dataArray.push([''	, new Date(obj.runDate)	,obj.nr			,obj.loadName	,isDaily		]); //,obj.loadSchedule	,obj.jobName	,obj.startTime	,obj.failedTime]);
	});

    var data = google.visualization.arrayToDataTable(dataArray);

    var options = {
            title: "Failed jobs per Date",
            hAxis: {title: 'Run Date', ticks: [	
            ]}, 
            vAxis: {title: 'No of Failures', ticks: [-4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]},
            bubble: {textStyle: {fontSize: 11, auraColor: 'none'}},
            colorAxis: {minValue: 0, colors: ['white', 'yellow', 'red', 'grey', 'brown', 'black']} 
            ,explorer: { axis: 'horizontal' }
            
          };

          var chart = new google.visualization.BubbleChart(document.getElementById('bubbles_div'));
          chart.draw(data, options);
}

function hideLoader(){
	
	console.log("hiding loader");
	document.getElementById("hideRollingLoader").style.display = "none";
	
}
