package com.logitech.operationmart.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

@Entity
@Table(name = "MASTER_ETL_LOAD_CONTROL")
public class LoadControl {

	@SuppressWarnings("unused")
	
	private final long serialVersionId = 1L;

	// private Integer id;
	private String loadName;
	private String subjectAreaName;
	private String enabledFlg;
	private Integer jobOrder;
	private String jobType;
	private String jobPath;
	private String jobName;
	private String jobLogPath;
	private Integer loadId;
	private Integer subLoadId;
	private String loadSchedule;
	private String loadType;

	@Column(nullable = true, name = "LOAD_NAME")
	public String getLoadName() {
		return loadName;
	}

	public void setLoadName(String loadName) {
		this.loadName = loadName;
	}

	@Column(nullable = true, name = "SUBJECT_AREA_NAME")
	public String getSubjectAreaName() {
		return subjectAreaName;
	}

	public void setSubjectAreaName(String subjectAreaName) {
		this.subjectAreaName = subjectAreaName;
	}

	@Column(nullable = true, name = "ENABLED_FLG")
	public String getEnabledFlg() {
		return enabledFlg;
	}

	public void setEnabledFlg(String enabledFlg) {
		this.enabledFlg = enabledFlg;
	}

	@Column(nullable = true, name = "JOB_ORDER")
	public Integer getJobOrder() {
		return jobOrder;
	}

	public void setJobOrder(Integer jobOrder) {
		this.jobOrder = jobOrder;
	}

	@Column(nullable = true, name = "JOB_TYPE")
	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	@Column(nullable = true, name = "JOB_PATH")
	public String getJobPath() {
		return jobPath;
	}

	public void setJobPath(String jobPath) {
		this.jobPath = jobPath;
	}

	@Column(nullable = true, name = "JOB_NAME")
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(nullable = true, name = "JOB_LOG_PATH")
	public String getJobLogPath() {
		return jobLogPath;
	}

	public void setJobLogPath(String jobLogPath) {
		this.jobLogPath = jobLogPath;
	}

	@Id
	@Column(nullable = true, name = "LOAD_ID")
	public Integer getLoadId() {
		return loadId;
	}

	public void setLoadId(Integer loadId) {
		this.loadId = loadId;
	}

	@Column(nullable = true, name = "SUB_LOAD_ID")
	public Integer getSubLoadId() {
		return subLoadId;
	}

	public void setSubLoadId(Integer subLoadId) {
		this.subLoadId = subLoadId;
	}

	@Column(nullable = true, name = "LOAD_SCHEDULE")
	public String getLoadSchedule() {
		return loadSchedule;
	}

	public void setLoadSchedule(String loadSchedule) {
		this.loadSchedule = loadSchedule;
	}

	@Column(nullable = true, name = "LOAD_TYPE")
	public String getLoadType() {
		return loadType;
	}

	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}

	public LoadControl(String loadName, String subjectAreaName, String enabledFlg, Integer jobOrder, String jobType,
			String jobPath, String jobName, String jobLogPath, Integer loadId, Integer subLoadId, String loadSchedule,
			String loadType) {
		super();
		this.loadName = loadName;
		this.subjectAreaName = subjectAreaName;
		this.enabledFlg = enabledFlg;
		this.jobOrder = jobOrder;
		this.jobType = jobType;
		this.jobPath = jobPath;
		this.jobName = jobName;
		this.jobLogPath = jobLogPath;
		this.loadId = loadId;
		this.subLoadId = subLoadId;
		this.loadSchedule = loadSchedule;
		this.loadType = loadType;
	}

	public LoadControl() {
		super();
	}

	@Override
	public String toString() {
		return "LoadControl [loadName=" + loadName + ", subjectAreaName=" + subjectAreaName + ", enabledFlg="
				+ enabledFlg + ", jobOrder=" + jobOrder + ", jobType=" + jobType + ", jobPath=" + jobPath + ", jobName="
				+ jobName + ", jobLogPath=" + jobLogPath + ", loadId=" + loadId + ", subLoadId=" + subLoadId
				+ ", loadSchedule=" + loadSchedule + ", loadType=" + loadType + "]";
	}

}
