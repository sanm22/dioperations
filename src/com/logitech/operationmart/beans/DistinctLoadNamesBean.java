package com.logitech.operationmart.beans;

public class DistinctLoadNamesBean {

	
	private String loadName;
	private String subjectAreaName;
	private String jobName;
	
	public DistinctLoadNamesBean() {
		super();
	}

	public DistinctLoadNamesBean(String loadName, String subjectAreaName, String jobName) {
		super();
		this.loadName = loadName;
		this.subjectAreaName = subjectAreaName;
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

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "DistinctLoadNamesBean [loadName=" + loadName + ", subjectAreaName=" + subjectAreaName + ", jobName=" + jobName + "]";
	}
	
}
