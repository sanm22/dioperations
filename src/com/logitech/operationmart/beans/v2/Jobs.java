package com.logitech.operationmart.beans.v2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

@Entity
@Table(name = "BI_JOBS")
public class Jobs {

	@SuppressWarnings("unused")
	private final long serialVersionId = 2676L;

	private Integer jobId;
	private String jobName;
	private String jobType;
	private int jobOrder;
	private String enabled;
	private String notes;
	private Integer timeout;
	

	private SubLoads subLoads;
	
	private Loads loads;
	
	public Jobs() {
		super();
	}

	public Jobs(Integer jobId, Loads loads, SubLoads subLoads, String jobName, String jobType, int jobOrder,
			String enabled, String notes, Integer timeout) {
		super();
		this.jobId = jobId;
		this.loads = loads;
		this.subLoads = subLoads;
		this.jobName = jobName;
		this.jobType = jobType;
		this.jobOrder = jobOrder;
		this.enabled = enabled;
		this.notes = notes;
		this.timeout = timeout;
	}

	@Id
	@Column(nullable = true, name = "JOB_ID")	
	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="LOAD_ID", referencedColumnName = "LOAD_ID")
	public Loads getLoads() {
		return loads;
	}
	
	public void setLoads(Loads loads) {
		this.loads = loads;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="SUBLOAD_ID", referencedColumnName = "SUBLOAD_ID")
	public SubLoads getSubLoads() {
		return subLoads;
	}
	
	public void setSubLoads(SubLoads subLoads) {
		this.subLoads = subLoads;
	}
	
	@Column(nullable = true, name = "JOB_NAME")
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(nullable = true, name = "JOB_TYPE")
	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	@Column(nullable = true, name = "JOB_ORDER")
	public int getJobOrder() {
		return jobOrder;
	}

	public void setJobOrder(int jobOrder) {
		this.jobOrder = jobOrder;
	}

	@Column(nullable = true, name = "ENABLED")
	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Column(nullable = true, name = "NOTES")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(nullable = true, name = "TIMEOUT")
	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", jobName=" + jobName + ", jobType=" + jobType + ", jobOrder=" + jobOrder
				+ ", enabled=" + enabled + ", notes=" + notes + ", timeout=" + timeout + ", subLoads=" + subLoads
				+ ", loads=" + loads + "]";
	}


	
}