package com.logitech.operationmart.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

@Entity
@Table(name = "BIOPS_LOAD_STATUS_VW")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class BiopsLoadStats {

	@SuppressWarnings("unused")
	private final long serialVersionId = 2L;
 
	private Date runDate;
	private String loadName;
	private String subjectAreaName;
	private String startStatus;
	private String completionStatus;
	private String failedStatus;
	private Date startTime;
	private Date endTime;
	private Date failedTime;
	private Integer runId;
	private String runDay;
	private Date createdDate; 
	private Date updatedDate; 
	private String loadSchedule; 

	
	public BiopsLoadStats() {
		super();
	}
	
	public BiopsLoadStats(Date runDate, String loadName, String subjectAreaName, String startStatus,
			String completionStatus, String failedStatus, Date startTime, Date endTime, Date failedTime,
			Integer runId, String runDay, Date createdDate, Date updatedDate, String loadSchedule) {
		super();
		this.runDate = runDate;
		this.loadName = loadName;
		this.subjectAreaName = subjectAreaName; 
		this.startStatus = startStatus;
		this.completionStatus = completionStatus;
		this.failedStatus = failedStatus;
		this.startTime = startTime;
		this.endTime = endTime;
		this.failedTime = failedTime;
		this.runId = runId;
		this.runDay = runDay;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.loadSchedule = loadSchedule;
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

	@Column(nullable = true, name = "INT_LOAD_NAME")
	public String getSubjectAreaName() {
		return subjectAreaName;
	}

	public void setSubjectAreaName(String subjectAreaName) {
		this.subjectAreaName = subjectAreaName;
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
		return createdDate;
	}

	public void setCreationDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(nullable = true, name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(nullable = true, name = "LOAD_SCHEDULE")
	public String getLoadSchedule() {
		return loadSchedule;
	}
	
	public void setLoadSchedule(String loadSchedule) {
		this.loadSchedule = loadSchedule;
	}

	@Override
	public String toString() {
		return "BiopsLoadStats [runDate=" + runDate + ", loadName=" + loadName + ", subjectAreaName=" + subjectAreaName
				+ ", startStatus=" + startStatus + ", completionStatus=" + completionStatus + ", failedStatus="
				+ failedStatus + ", startTime=" + startTime + ", endTime=" + endTime + ", failedTime=" + failedTime
				+ ", runId=" + runId + ", runDay=" + runDay + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", loadSchedule=" + loadSchedule + "]";
	}

 
	
}