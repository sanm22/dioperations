package com.pentaho.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.pentaho.bean.MasterEtlLoadControl;

public class NewEntry {

	final static Logger logger = Logger.getLogger(NewEntry.class);

	private static String _loadName;
	private static String _subjectAreaName;
	private static String _enabledFlag;
	private static String _jobOrder;
	private static String _jobType;
	private static String _jobPath;
	private static String _jobName;
	private static String _loadId;
	private static String _subLoadId;
	private static String _loadSchedule;

	public void setLoadName(String loadName) {
		_loadName = loadName;
		System.out.println("loadName:" + _loadName);
	}

	public void setSubjectAreaName(String subjectAreaName) {
		_subjectAreaName = subjectAreaName;
		System.out.println("subjectAreaName:" + _subjectAreaName);

	}

	public void setEnabledFlag(String enabledFlag) {
		_enabledFlag = enabledFlag;
		System.out.println("enabledFlag:" + _enabledFlag);

	}

	public void setJobOrder(String jobOrder) {
		_jobOrder = jobOrder;
		System.out.println("jobOrder:" + _jobOrder);

	}

	public void setJobType(String jobType) {
		_jobType = jobType;
		System.out.println("jobType:" + _jobType);

	}

	public void setJobPath(String jobPath) {
		_jobPath = jobPath;
		System.out.println("JobPath:" + _jobPath);

	}

	public void setJobName(String jobName) {
		_jobName = jobName;
		System.out.println("jobName:" + _jobName);

	}

	public void setLoadId(String loadId) {
		_loadId = loadId;
		System.out.println("loadId:" + _loadId);

	}

	public void setSubLoadId(String subLoadId) {
		_subLoadId = subLoadId;
		System.out.println("subLoadId:" + _subLoadId);

	}

	public void setLoadSchedule(String loadSchedule) {
		_loadSchedule = loadSchedule;
		System.out.println("loadSchedule:" + _loadSchedule);
	}

	public static List<MasterEtlLoadControl> getLoadName() throws FileNotFoundException, IOException {

		Connection conn = (Connection) CreateConnection.createConnection();
		ResultSet rs = null;
		MasterEtlLoadControl workbench = null;
		List<MasterEtlLoadControl> workbenchList = new ArrayList<MasterEtlLoadControl>();
		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement("select distinct LOAD_NAME from MASTER_ETL_LOAD_CONTROL");

			rs = ps.executeQuery();
			while (rs.next()) {
				workbench = new MasterEtlLoadControl();
				workbench.setLoadName(rs.getString(1));

				workbenchList.add(workbench);

			}

			return workbenchList;
		} catch (SQLException e) {

		}
		return workbenchList;
	}

	public static List<MasterEtlLoadControl> getSubjectAreaName() throws FileNotFoundException, IOException {
		Connection conn = (Connection) CreateConnection.createConnection();

		ResultSet rs = null;

		MasterEtlLoadControl workbench = null;
		List<MasterEtlLoadControl> workbenchList = new ArrayList<MasterEtlLoadControl>();
		PreparedStatement ps = null;
		try {

			ps = conn.prepareStatement(
					"select distinct SUBJECT_AREA_NAME from MASTER_ETL_LOAD_CONTROL where LOAD_NAME=?");
			ps.setString(1, _loadName);

			rs = ps.executeQuery();
			while (rs.next()) {
				workbench = new MasterEtlLoadControl();
				workbench.setSubjectAreaName(rs.getString(1));

				workbenchList.add(workbench);
			}

			return workbenchList;
		} catch (SQLException e) {

		}
		return workbenchList;
	}

	public static List<MasterEtlLoadControl> getEnabledFlg() throws FileNotFoundException, IOException {

		Connection conn = (Connection) CreateConnection.createConnection();

		ResultSet rs = null;
		MasterEtlLoadControl workbench = null;
		List<MasterEtlLoadControl> workbenchList = new ArrayList<MasterEtlLoadControl>();
		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement("select distinct ENABLED_FLG from MASTER_ETL_LOAD_CONTROL");

			rs = ps.executeQuery();
			while (rs.next()) {
				workbench = new MasterEtlLoadControl();
				workbench.setEnabledFlag(rs.getString(1));

				workbenchList.add(workbench);

			}

			return workbenchList;
		} catch (SQLException e) {

		}
		return workbenchList;
	}

	public static List<MasterEtlLoadControl> getJobType() throws FileNotFoundException, IOException {

		Connection conn = (Connection) CreateConnection.createConnection();

		ResultSet rs = null;
		MasterEtlLoadControl workbench = null;
		List<MasterEtlLoadControl> workbenchList = new ArrayList<MasterEtlLoadControl>();
		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement("select distinct Job_type from MASTER_ETL_LOAD_CONTROL");

			rs = ps.executeQuery();
			while (rs.next()) {
				workbench = new MasterEtlLoadControl();
				workbench.setJobType(rs.getString(1));

				workbenchList.add(workbench);

			}

			return workbenchList;
		} catch (SQLException e) {

		}
		return workbenchList;
	}

	public static List<MasterEtlLoadControl> getLoadSchedule() throws FileNotFoundException, IOException {

		Connection conn = (Connection) CreateConnection.createConnection();

		ResultSet rs = null;
		MasterEtlLoadControl workbench = null;
		List<MasterEtlLoadControl> workbenchList = new ArrayList<MasterEtlLoadControl>();
		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement("select distinct Load_schedule from MASTER_ETL_LOAD_CONTROL");

			rs = ps.executeQuery();
			while (rs.next()) {
				workbench = new MasterEtlLoadControl();
				workbench.setLoadSchedule((rs.getString(1)));

				workbenchList.add(workbench);

			}

			return workbenchList;
		} catch (SQLException e) {

		}
		return workbenchList;
	}

}
