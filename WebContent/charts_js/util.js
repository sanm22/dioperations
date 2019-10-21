/*
 * 
 * 
 * 
 */


function getAbsoluteJobNameFromJobPath(jobname){
	return jobname.substring(jobname.lastIndexOf("/")+1 , jobname.length);
}
