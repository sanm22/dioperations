package com.pentaho.scripting;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pentaho.dao.CreateConnection;

public class EntryIntoTableForJobStatus {

	public void entryIntoTable(String jobPath,String jobName,String loadName,String subLoadName)	 {		
		 
			
		 try {
			Connection conn = (Connection) CreateConnection.createConnection();
			ResultSet rs = null;
			PreparedStatement ps = null;
			ps = conn.prepareStatement(
					"SELECT IFNULL(MAX(RUN_ID),0)+1 FROM MASTER_ETL_RUNTIME_STATS");
			rs = ps.executeQuery();
			rs.next();
			int maxRunId=rs.getInt(1);
			
			System.out.println("Max Run ID:"+maxRunId);
			
			 ps=conn.prepareStatement("select DATE_FORMAT(sysdate(),'%Y-%m-%d')");
			 rs = ps.executeQuery();
			 rs.next();
			String runDate=rs.getString(1);
			
			
			ps= conn.prepareStatement("select current_timestamp()");
			rs = ps.executeQuery();
			rs.next();
			String startTime=rs.getString(1);
			
			
			
			ps=conn.prepareStatement("SELECT DAYNAME(CURDATE())");
			rs = ps.executeQuery();
			rs.next();
			String runDay=rs.getString(1);
			runDay=runDay.substring(0, 3);		
			
			
			
			ps=conn.prepareStatement("insert into MASTER_ETL_RUNTIME_STATS(RUN_DATE,LOAD_NAME,SUBJECT_AREA_NAME,JOB_NAME,START_STATUS,COMPLETION_STATUS,FAILED_STATUS,MESSAGE,START_TIME,FAILED_TIME,END_TIME,RUN_ID,RUN_DAY,CREATION_DATE,LOAD_SCHEDULE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,runDate);
			ps.setString(2, loadName);
			ps.setString(3, subLoadName);
			ps.setString(4, jobName);
			ps.setString(5, "STARTED");
			ps.setNull(6, java.sql.Types.VARCHAR);
			ps.setNull(7, java.sql.Types.VARCHAR);
			ps.setString(8, jobName+" JOB IS SUCCESSFULLY COMPLETED");
			ps.setString(9, startTime);
			ps.setNull(10, java.sql.Types.VARCHAR);
			ps.setNull(11, java.sql.Types.VARCHAR);
			ps.setInt(12, maxRunId);
			ps.setString(13, runDay);
			ps.setString(14, startTime);
			ps.setString(15,"");
			ps.executeUpdate();
			System.out.println("Row inserted");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }

}
