package com.logitech.operationmart.beans.v2;

import java.sql.Date;

public class FailedJobsPerDateBubbleBean {

	private int nrEtlErrors;
	private int nrKtlErrors;
	private String loadName;
	private String subLoadName;
	private String runEndDate;
	private String runStatus;
	
	public FailedJobsPerDateBubbleBean() {
		super();
	}

	public FailedJobsPerDateBubbleBean(int nrEtlErrors, int nrKtlErrors, String loadName, String subLoadName, String runEndDate,
			String runStatus) {
		super();
		this.nrEtlErrors = nrEtlErrors;
		this.nrKtlErrors = nrKtlErrors;
		this.loadName = loadName;
		this.subLoadName = subLoadName;
		this.runEndDate = runEndDate;
		this.runStatus = runStatus;
	}

	public int getNrEtlErrors() {
		return nrEtlErrors;
	}
	
	public void setNrEtlErrors(int nrEtlErrors) {
		this.nrEtlErrors = nrEtlErrors;
	}

	public int getNrKtlErrors() {
		return nrKtlErrors;
	}
	
	public void setNrKtlErrors(int nrKtlErrors) {
		this.nrKtlErrors = nrKtlErrors;
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
		return "FailedJobsPerDateBubbleBean [nrEtlErrors=" + nrEtlErrors + ", nrKtlErrors=" + nrKtlErrors
				+ ", loadName=" + loadName + ", subLoadName=" + subLoadName + ", runEndDate=" + runEndDate
				+ ", runStatus=" + runStatus + "]";
	}

	 
}
