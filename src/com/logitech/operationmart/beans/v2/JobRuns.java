package com.logitech.operationmart.beans.v2;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

@Entity
@Table(name = "BI_JOBS_RUNS")
@FilterDef(
		name = "runStatusFltr", 
	    parameters = @ParamDef(name = "yourRunStatusParam", type = "string")
	)
@Filter(
	    name = "loadnameinFltr", 
	    condition = "runStatus like :yourRunStatusParam"
	)
@FilterDef(
		name = "loadNameInFltr", 
	    parameters = @ParamDef(name = "yourListLoadNamesParam", type = "string")
	)
@Filter(
	    name = "loadNameInFltr", 
	    condition = " LOAD_ID in (:yourListLoadNamesParam)" 
	)
public class JobRuns {

	private final long serialVersionId = 276L;

	private Integer runId;
	private String jobName;
	private String pentahoJobId;
	private String xmlResult;
	private String runStatus;
	private java.util.Date runStartDate;
	private String runEndDate;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SUBLOAD_ID")
	private SubLoads subLoads;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LOAD_ID")
	private Loads loads;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LOAD_ID")
	private Jobs jobs;
	
	public JobRuns() {
		super();
	}
	 
	public JobRuns(Integer runId, Loads loads, SubLoads subLoads, Jobs jobs, String jobName, String pentahoJobId,
			String xmlResult, String runStatus, Date runStartDate, String runEndDate) {
		super();
		this.runId = runId;
		this.jobName = jobName;
		this.pentahoJobId = pentahoJobId;
		this.xmlResult = xmlResult;
		this.runStatus = runStatus;
		this.runStartDate = runStartDate;
		this.runEndDate = runEndDate;
		this.jobs = jobs;
		this.subLoads = subLoads;
		this.loads = loads;
	}

	@Id
	@Column(nullable = true, name = "RUN_ID")
	public Integer getRunId() {
		return runId;
	}

	public void setRunId(Integer runId) {
		this.runId = runId;
	}

	@Column(nullable = true, name = "JOB_NAME")
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(nullable = true, name = "PENTAHO_JOB_ID")
	public String getPentahoJobId() {
		return pentahoJobId;
	}

	public void setPentahoJobId(String pentahoJobId) {
		this.pentahoJobId = pentahoJobId;
	}

	@Column(nullable = true, name = "WEBRESULT")
	public String getXmlResult() {
		return xmlResult;
	}

	public void setXmlResult(String xmlResult) {
		this.xmlResult = xmlResult;
	}

	@Column(nullable = true, name = "RUNSTATUS")
	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	@Column(nullable = true, name = "START_DATE")
	public Date getRunStartDate() {
		return runStartDate;
	}

	public void setRunStartDate(Date runStartDate) {
		this.runStartDate = runStartDate;
	}

	@Column(nullable = true, name = "RUNSTATUS_UPDATE_DATE")
	public String getRunEndDate() {
		return runEndDate;
	}

	public void setRunEndDate(String runEndDate) {
		this.runEndDate = runEndDate;
	}

	
	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="SUBLOAD_ID", referencedColumnName = "SUBLOAD_ID")
	public SubLoads getSubLoads() {
		return subLoads;
	}

	public void setSubLoads(SubLoads subLoads) {
		this.subLoads = subLoads;
	}

	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="LOAD_ID", referencedColumnName = "LOAD_ID")
	public Loads getLoads() {
		return loads;
	}

	public void setLoads(Loads loads) {
		this.loads = loads;
	}

	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="JOBS_ID", referencedColumnName = "JOB_ID")
	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "JobRuns [serialVersionId=" + serialVersionId + ", runId=" + runId + ", jobName=" + jobName
				+ ", pentahoJobId=" + pentahoJobId + ", xmlResult=" + xmlResult + ", runStatus=" + runStatus
				+ ", runStartDate=" + runStartDate + ", runEndDate=" + runEndDate + ", subLoads=" + subLoads
				+ ", loads=" + loads + ", jobs=" + jobs + "]";
	}

		 
	
}