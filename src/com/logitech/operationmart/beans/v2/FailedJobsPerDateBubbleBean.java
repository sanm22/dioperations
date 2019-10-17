package com.logitech.operationmart.beans.v2;

import java.sql.Date;

public class FailedJobsPerDateBubbleBean {

	private int nr;
	private String loadName;
	private String subLoadName;
	private String runEndDate;
	private String runStatus;
	
	public FailedJobsPerDateBubbleBean() {
		super();
	}

	public FailedJobsPerDateBubbleBean(int nr, String loadName, String subLoadName, String runEndDate,
			String runStatus) {
		super();
		this.nr = nr;
		this.loadName = loadName;
		this.subLoadName = subLoadName;
		this.runEndDate = runEndDate;
		this.runStatus = runStatus;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
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

	@Override
	public String toString() {
		return "FailedJobsPerDateBubbleBean [nr=" + nr + ", loadName=" + loadName + ", subLoadName=" + subLoadName
				+ ", runEndDate=" + runEndDate + ", runStatus=" + runStatus + "]";
	}
	
 

}
