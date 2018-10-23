package com.pentaho.scripting;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import com.pentaho.dao.ShellScripting;
import com.pentaho.servlet.JsonServlet;

public class ExecuteScript  {
	final static Logger logger = Logger.getLogger(ExecuteScript.class);
	

	/* Added for directly executing kitchen.sh */
	
	public static boolean executeScript() throws ClientProtocolException, IOException {
		
		String jobPath = ShellScripting.path;
		String jobName = ShellScripting.job;
		
		
		String loadName=JsonServlet.load_name;
		String subLoadName=JsonServlet.subload_name;
		JsonServlet.load_name=null;
		JsonServlet.subload_name=null;
		
		
		WebServiceCallForKitchenScript ws= new WebServiceCallForKitchenScript();
		boolean value=ws.callWebService(jobPath, jobName);	
				
		EntryIntoTableForJobStatus entryIntoTableForJobStatus= new EntryIntoTableForJobStatus();
		if(value==true)
			entryIntoTableForJobStatus.entryIntoTable(jobPath, jobName,loadName,subLoadName);
		else
			System.out.println("Row Not Inserted as URL is invalid");
		return value;
			
		
		
		
		
		//Kitchen_Script
		
		/*System.out.println("Get Env:" + System.getenv());
		logger.debug("Get env:" + System.getenv());
		String dir = "/tmp";
		String actualCommnad = "sh -x /u02/pntdi/BSD_BI/Scripts/ADhoc_Master_job_start_script_j.sh ";// + para1 + " " + para2;
*///		StringBuffer sb = new StringBuffer();
//		sb.append("sh /u01/app/pentaho/client/data-integration");
//		sb.append("/kitchen.sh -rep='Pentaho Dev DI Repo' -dir= '").append(para1).append("'");
//		sb.append(" -job='").append(para2).append("'");
//		sb.append(" -user='").append("masyed").append("'");
//		sb.append(" -pass='").append("Zensar@2010").append("'");
	
		/*System.out.println("running command \n" + actualCommnad);
		logger.debug("running command \n" + actualCommnad);
		
		String[] command = { "/bin/bash", "-c", actualCommnad };
		
		ProcessBuilder probuilder = new ProcessBuilder(command);
		probuilder.directory(new File(dir));
		Process process = null;

		try {
			process = probuilder.start();
			
//			InputStream is = process.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
//			String line;
//			System.out.printf("Output of running %s is:\n", Arrays.toString(command));
//			logger.debug("Output of running %s is:\n" + Arrays.toString(command));
//			while ((line = br.readLine()) != null) {
//				System.out.println("Line:" + line);
//				int exitValue;
//				exitValue = process.waitFor();
//				System.out.println("\nExit Value is " + exitValue);
//			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} */

	}
	
}
