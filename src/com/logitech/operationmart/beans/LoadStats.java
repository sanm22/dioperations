package com.logitech.operationmart.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

@Entity
@Table(name = "MASTER_ETL_RUNTIME_STATS_VW")
public class LoadStats {

	@SuppressWarnings("unused")
	private final long serialVersionId = 2L;
 
	private Date runDate;
	private String loadName;
	private String subjectAreaName;
	private String jobName;
	private String startStatus;
	private String completionStatus;
	private String failedStatus;
	private Date startTime;
	private Date endTime;
	private Date failedTime;
	private Integer runId;
	private String runDay;
	private Date creationDate; 
	private String loadSchedule;
	private String message;

	
	public LoadStats() {
		super();
	}
	
	public LoadStats(Date runDate, String loadName, String subjectAreaName, String jobName, String startStatus,
			String completionStatus, String failedStatus, Date startTime, Date endTime, Date failedTime,
			Integer runId, String runDay, Date creationDate, String loadSchedule, String message) {
		super();
		this.runDate = runDate;
		this.loadName = loadName;
		this.subjectAreaName = subjectAreaName;
		this.jobName = jobName;
		this.startStatus = startStatus;
		this.completionStatus = completionStatus;
		this.failedStatus = failedStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.failedTime = failedTime;
		this.runId = runId;
		this.runDay = runDay;
		this.creationDate = creationDate;
		this.loadSchedule = loadSchedule;
		this.message = message;
	}

	@Column(nullable = true, name = "RUN_DATE")
	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

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

	@Column(nullable = true, name = "JOB_NAME")
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(nullable = true, name = "START_STATUS")
	public String getStartStatus() {
		return startStatus;
	}

	public void setStartStatus(String startStatus) {
		this.startStatus = startStatus;
	}

	@Column(nullable = true, name = "COMPLETION_STATUS")
	public String getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(String completionStatus) {
		this.completionStatus = completionStatus;
	}

	@Column(nullable = true, name = "FAILED_STATUS")
	public String getFailedStatus() {
		return failedStatus;
	}

	public void setFailedStatus(String failedStatus) {
		this.failedStatus = failedStatus;
	}
	
	@Column(nullable = true, name = "START_TIME")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(nullable = true, name = "END_TIME")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(nullable = true, name = "FAILED_TIME")
	public Date getFailedTime() {
		return failedTime;
	}

	public void setFailedTime(Date failedTime) {
		this.failedTime = failedTime;
	}

	@Id
	@Column(nullable = true, name = "RUN_ID")
	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	@Column(nullable = true, name = "RUN_DAY")
	public String getRunDay() {
		return runDay;
	}

	public void setRunDay(String runDay) {
		this.runDay = runDay;
	}

	@Column(nullable = true, name = "CREATION_DATE")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(nullable = true, name = "LOAD_SCHEDULE")
	public String getLoadSchedule() {
		return loadSchedule;
	}
	
	public void setLoadSchedule(String loadSchedule) {
		this.loadSchedule = loadSchedule;
	}
	
	@Column(nullable = true, name = "MESSAGE")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoadStats [runDate=" + runDate + ", loadName=" + loadName + ", subjectAreaName=" + subjectAreaName
				+ ", jobName=" + jobName + ", startStatus=" + startStatus + ", completionStatus=" + completionStatus
				+ ", failedStatus=" + failedStatus + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", failedTime=" + failedTime + ", runId=" + runId + ", runDay=" + runDay + ", creationDate="
				+ creationDate + ", loadSchedule=" + loadSchedule + ", message=" + message + ", getRunDate()="
				+ getRunDate() + ", getLoadName()=" + getLoadName() + ", getSubjectAreaName()=" + getSubjectAreaName()
				+ ", getJobName()=" + getJobName() + ", getStartStatus()=" + getStartStatus()
				+ ", getCompletionStatus()=" + getCompletionStatus() + ", getFailedStatus()=" + getFailedStatus()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime() + ", getFailedTime()="
				+ getFailedTime() + ", getRunId()=" + getRunId() + ", getRunDay()=" + getRunDay()
				+ ", getCreationDate()=" + getCreationDate() + ", getLoadSchedule()=" + getLoadSchedule()
				+ ", getMessage()=" + getMessage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}