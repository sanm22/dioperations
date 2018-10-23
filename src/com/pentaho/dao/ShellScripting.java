package com.pentaho.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.pentaho.bean.MasterEtlLoadControl;

public class ShellScripting {
	final static Logger logger = Logger.getLogger(ShellScripting.class);

	public static String loadName;
	public static String subLoadName;
	public static String job;
	public static String path;

	public void getLoad(String load) {
		loadName = load;
	}

	public void getSubLoad(String subLoad) {
		subLoadName = subLoad;
	}

	public void getJobName(String jobName) throws FileNotFoundException, IOException {
		job = jobName;
		List<MasterEtlLoadControl> workbenchList = getJobPath();
		Iterator<MasterEtlLoadControl> itr = workbenchList.iterator();

		while (itr.hasNext()) {
			MasterEtlLoadControl workbench = itr.next();
			path = workbench.getJobPath();
			logger.debug("JobPath is:" + path);
		}

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
			logger.error(e.getMessage());

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
			ps.setString(1, loadName);

			rs = ps.executeQuery();
			while (rs.next()) {
				workbench = new MasterEtlLoadControl();
				workbench.setSubjectAreaName(rs.getString(1));

				workbenchList.add(workbench);
			}

			return workbenchList;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return workbenchList;
	}

	public static List<MasterEtlLoadControl> getJobNAme() throws FileNotFoundException, IOException {
		Connection conn = (Connection) CreateConnection.createConnection();

		ResultSet rs = null;

		MasterEtlLoadControl workbench = null;
		List<MasterEtlLoadControl> workbenchList = new ArrayList<MasterEtlLoadControl>();
		PreparedStatement ps = null;
		try {

			ps = conn.prepareStatement(
					"select distinct Job_Name from MASTER_ETL_LOAD_CONTROL where SUBJECT_AREA_NAME=? and Job_Name not like '/u02%'");
			ps.setString(1, subLoadName);

			rs = ps.executeQuery();
			while (rs.next()) {
				workbench = new MasterEtlLoadControl();
				workbench.setJobName(rs.getString(1));

				workbenchList.add(workbench);
			}
			return workbenchList;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return workbenchList;
	}

	public static List<MasterEtlLoadControl> getJobPath() throws FileNotFoundException, IOException {
		Connection conn = (Connection) CreateConnection.createConnection();

		ResultSet rs = null;

		MasterEtlLoadControl workbench = null;
		List<MasterEtlLoadControl> workbenchList = new ArrayList<MasterEtlLoadControl>();
		PreparedStatement ps = null;
		try {

			ps = conn.prepareStatement("select distinct Job_path from MASTER_ETL_LOAD_CONTROL where Job_Name = ?");
			ps.setString(1, job);

			rs = ps.executeQuery();
			while (rs.next()) {
				workbench = new MasterEtlLoadControl();
				workbench.setJobPath(rs.getString(1));
				workbenchList.add(workbench);
			}
			return workbenchList;
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return workbenchList;
	}
}
