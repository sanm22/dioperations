package com.logitech.operationmart.beans.v2;

import java.util.Date;

public class JobRunDetailsSimplified {

	String jobName; 
	int jjobOrder;
	String jobType;
	String loadName;
	String subLoadName;
	String pentahoJobId;
	Date runStartDate;
	String runEndDate;
	String runStatus;
	Integer runId;
	
	public JobRunDetailsSimplified() {
		super();
	}

	public JobRunDetailsSimplified(String jobName, int jjobOrder, String jobType, String loadName, String subLoadName,
			String pentahoJobId, Date runStartDate, String runEndDate, String runStatus, Integer runId) {
		this.jobName = jobName; 
		this.jjobOrder = jjobOrder;
		this.jobType = jobType;
		this.loadName = loadName;
		this.subLoadName = subLoadName;
		this.pentahoJobId = pentahoJobId;
		this.runStartDate = runStartDate;
		this.runEndDate = runEndDate;
		this.runStatus = runStatus;
		this.runId = runId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getJjobOrder() {
		return jjobOrder;
	}

	public void setJjobOrder(int jjobOrder) {
		this.jjobOrder = jjobOrder;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getLoadName() {
		return loadName;
	}

	public void setLoadName(String loadName) {
		this.loadName = loadName;
	}

	public String getSubLoadName() {
		return subLoadName;
	}

	public void setSubLoadName(String subLoadName) {
		this.subLoadName = subLoadName;
	}

	public String getPentahoJobId() {
		return pentahoJobId;
	}

	public void setPentahoJobId(String pentahoJobId) {
		this.pentahoJobId = pentahoJobId;
	}

	public Date getRunStartDate() {
		return runStartDate;
	}

	public void setRunStartDate(Date runStartDate) {
		this.runStartDate = runStartDate;
	}

	public String getRunEndDate() {
		return runEndDate;
	}

	public void setRunEndDate(String runEndDate) {
		this.runEndDate = runEndDate;
	}

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	@Override
	public String toString() {
		return "JobRunDetailsSimplified [jobName=" + jobName + ", jjobOrder=" + jjobOrder + ", jobType=" + jobType
				+ ", loadName=" + loadName + ", subLoadName=" + subLoadName + ", pentahoJobId=" + pentahoJobId
				+ ", runStartDate=" + runStartDate + ", runEndDate=" + runEndDate + ", runStatus=" + runStatus
				+ ", runId=" + runId + "]";
	}

	
	
	
}
