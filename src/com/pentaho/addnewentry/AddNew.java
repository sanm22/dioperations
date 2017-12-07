package com.pentaho.addnewentry;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.pentaho.dao.CreateConnection;

public class AddNew {
	final static Logger logger = Logger.getLogger(AddNew.class);

	public static void addNewEntry(String loadName, String subLoadName, String jobName, String enabledFlg,
			String jobOrder, String jobType, String jobPath, String loadId, String subLoadId, String loadSchedule) {
		String jobLogPath = "/u02/pntdi/BSD_BI/kitchenscripts/logs";
		String loadType = "TEST";
		if ((enabledFlg != null && !(enabledFlg.equals("Select Enabled Flg")))
				&& (jobType != null && !(jobType.equals("Select Job Type")))
				&& (loadSchedule != null && !(loadSchedule.equals("Select Load Schedule")))) {
			try {
				Connection conn = CreateConnection.createConnection();
				PreparedStatement psmt = conn.prepareStatement(
						"insert into MASTER_ETL_LOAD_CONTROL (LOAD_NAME,SUBJECT_AREA_NAME,ENABLED_FLG,Job_Order,Job_type,Job_path,Job_name,Job_log_path,LOAD_ID,SUB_LOAD_ID,Load_schedule,Load_type) values(?,?,?,?,?,?,?,?,?,?,?,?)");
				psmt.setString(1, loadName);
				psmt.setString(2, subLoadName);
				psmt.setString(3, enabledFlg); 
				psmt.setString(4, jobOrder);
				psmt.setString(5, jobType);
				psmt.setString(6, jobPath);
				psmt.setString(7, jobName);
				psmt.setString(8, jobLogPath);
				psmt.setString(9, loadId);
				psmt.setString(10, subLoadId);
				psmt.setString(11, loadSchedule);
				psmt.setString(12, loadType);
				psmt.executeUpdate();
				System.out.println("Job Added Succesfully !!!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Enter proper values");
			logger.info("Enter proper values");

		}
	}

}
