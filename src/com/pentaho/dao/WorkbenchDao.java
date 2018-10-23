package com.pentaho.dao;

import java.io.FileNotFoundException; 
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.pentaho.bean.BiopsLoadStatus;
import com.pentaho.bean.MasterEtlRuntimeStats;

public class WorkbenchDao {

	private static boolean value = false;
	// this variable is used to set a condition so that we can migrate to the
	// dashboard without validation

	final static Logger logger = Logger.getLogger(WorkbenchDao.class);
	public static String name;
	public static Connection conn = null;

	public static boolean getValue() {
		return value;
	}

	public static void setValue(boolean value) {
		WorkbenchDao.value = value;
	}

	// To validate user
	public boolean validation(String uName, String uPassword) {

		try {
			conn = (Connection) CreateConnection.createConnection();
			logger.info("connection Object:" + conn);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		ResultSet rs = null;
		PreparedStatement ps = null;
		name = uName;

		try {
			ps = conn.prepareStatement(ResourceBundle.getBundle("dioperations").getString("USERSELECT"));
			ps.setString(1, uName);

			ps.setString(2, uPassword);

			rs = ps.executeQuery();
			rs.next();
			if (rs.getString(2) == null && uPassword == null) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	// to get the running jobs
	public static List<MasterEtlRuntimeStats> getRunningJobs() throws FileNotFoundException, IOException {
 
		Connection conn = (Connection) CreateConnection.createConnection(); 
		List<MasterEtlRuntimeStats> workbenchList = new ArrayList<MasterEtlRuntimeStats>(); 
		try {

			PreparedStatement ps = conn.prepareStatement(ResourceBundle.getBundle("dioperations").getString("RUNNINGJOBS"));

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MasterEtlRuntimeStats workbench = new MasterEtlRuntimeStats();
				workbench.setRunDate(rs.getString(1));
				workbench.setLoadName(rs.getString(2));
				workbench.setSubjectAreaName(rs.getString(3));
				workbench.setJobName(rs.getString(4));
				workbench.setStartStatus(rs.getString(5));
				workbench.setCompletionStatus(rs.getString(6));
				workbench.setFailedStatus(rs.getString(7));
				workbench.setMessage(rs.getString(8));
				workbench.setStartTime(rs.getString(9));
				workbench.setFailedTime(rs.getString(10));
				workbench.setEndTime(rs.getString(11));
				workbench.setRunId(rs.getInt(12));
				workbench.setRunDay(rs.getString(13));
				workbench.setCreationDate(rs.getString(14));
				workbench.setLoadSchedule(rs.getString(15));
				workbenchList.add(workbench);

			}

			logger.info("fetched data for running jobs:");
			return workbenchList;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return workbenchList;
	}

	// to get failed jobs
	public static List<MasterEtlRuntimeStats> getLast20FailedJobs() throws FileNotFoundException, IOException {
		
		List<MasterEtlRuntimeStats> workbenchList = new ArrayList<MasterEtlRuntimeStats>();
		try {
			PreparedStatement ps = conn.prepareStatement(ResourceBundle.getBundle("dioperations").getString("LASTFAILEDJOBS"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MasterEtlRuntimeStats workbench = new MasterEtlRuntimeStats();
				workbench.setRunDate(rs.getString(1));
				workbench.setLoadName(rs.getString(2));
				workbench.setSubjectAreaName(rs.getString(3));
				workbench.setJobName(rs.getString(4));
				workbench.setStartStatus(rs.getString(5));
				workbench.setCompletionStatus(rs.getString(6));
				workbench.setFailedStatus(rs.getString(7));
				workbench.setMessage(rs.getString(8));
				workbench.setStartTime(rs.getString(9));
				workbench.setFailedTime(rs.getString(10));
				workbench.setEndTime(rs.getString(11));
				workbench.setRunId(rs.getInt(12));
				workbench.setRunDay(rs.getString(13));
				workbench.setCreationDate(rs.getString(14));
				workbench.setLoadSchedule(rs.getString(15));
				workbenchList .add(workbench);

			}

			logger.info("fetched data for failed jobs:");
			return workbenchList;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return workbenchList;
	}

	// to get loadInProgress
	public static List<BiopsLoadStatus> getLoadInProgress() throws FileNotFoundException, IOException {

 
		Connection conn =  CreateConnection.createConnection(); 
		List<BiopsLoadStatus> workbenchList = new ArrayList<BiopsLoadStatus>();
		String getLoadInProgress = ResourceBundle.getBundle("dioperations").getString("LOADINPROGRESS"); 
		try {
			PreparedStatement ps = conn.prepareStatement(getLoadInProgress);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BiopsLoadStatus workbench = new BiopsLoadStatus();
				workbench.setRunDate(rs.getString(1));
				workbench.setLoadName(rs.getString(2));
				workbench.setIntLoadName(rs.getString(3));
				workbench.setStartStatus(rs.getString(4));
				workbench.setCompletionStatus(rs.getString(5));
				workbench.setFailedStatus(rs.getString(6));
				workbench.setMessage(rs.getString(7));
				workbenchList.add(workbench);

			}

			logger.info("fetched data for load in progress:");
			return workbenchList;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return workbenchList;
	}

	// to get LastAndCurrentDayLoadStatus
	public static List<BiopsLoadStatus> getLastAndCurrentDayLoadStatus() throws FileNotFoundException, IOException {

		 
		List<BiopsLoadStatus> workbenchList = new ArrayList<BiopsLoadStatus>();
		try {
			PreparedStatement ps = conn.prepareStatement(ResourceBundle.getBundle("dioperations").getString("LOADSTATUS"));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BiopsLoadStatus workbench = new BiopsLoadStatus();
				workbench.setRunDate(rs.getString(1));
				workbench.setLoadName(rs.getString(2));
				workbench.setIntLoadName(rs.getString(3));
				workbench.setStartStatus(rs.getString(4));
				workbench.setCompletionStatus(rs.getString(5));
				workbench.setFailedStatus(rs.getString(6));
				workbench.setMessage(rs.getString(7));
				workbenchList.add(workbench);

			}

			logger.info("fetched data for load status:");
			return workbenchList;
		} catch (SQLException e) {

			logger.error(e.getMessage());
		}
		return workbenchList;

	}

}
