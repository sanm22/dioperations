package com.logitech.operationmart.beans;

public class DistinctLoadNamesBean {

	
	private String loadName;
	private String subjectAreaName;
	private String jobPath;
	private String jobName;
	
	public DistinctLoadNamesBean() {
		super();
	}

	public DistinctLoadNamesBean(String loadName, String subjectAreaName, String jobPath, String jobName) {
		super();
		this.loadName = loadName;
		this.subjectAreaName = subjectAreaName;
		this.jobPath = jobPath;
		this.jobName = jobName;
	}

	public String getLoadName() {
		return loadName;
	}

	public void setLoadName(String loadName) {
		this.loadName = loadName;
	}

	public String getSubjectAreaName() {
		return subjectAreaName;
	}

	public void setSubjectAreaName(String subjectAreaName) {
		this.subjectAreaName = subjectAreaName;
	}

	public String getJobPath() {
		return jobPath;
	}

	public void setJobPath(String jobPath) {
		this.jobPath = jobPath;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "DistinctLoadNamesBean [loadName=" + loadName + ", subjectAreaName=" + subjectAreaName + ", jobPath="
				+ jobPath + ", jobName=" + jobName + "]";
	}
	
	
	
	
}
