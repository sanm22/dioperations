package com.logitech.operationmart.beans.v2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

@Entity
@Table(name = "BI_LOADS")
public class Loads {

	@SuppressWarnings("unused")
	private final long serialVersionId = 2726L;

	private Integer loadId;
	private String loadName;
	private String loadType;
	private int jobOrder;
	private String enabled;
	private String dependentLoadIds;
	private String notes;	
	private String forceRun;
	
	public Loads() {
		super();
	}
	 
	public Loads(Integer loadId, String loadName, String loadType, int jobOrder, String enabled,
			String dependentLoadIds, String notes, String forceRun) {
		super();
		this.loadId = loadId;
		this.loadName = loadName;
		this.loadType = loadType;
		this.jobOrder = jobOrder;
		this.enabled = enabled;
		this.dependentLoadIds = dependentLoadIds;
		this.notes = notes;
		this.forceRun = forceRun;
	}

	@Id
	@Column(nullable = true, name = "LOAD_ID")
	public Integer getLoadId() {
		return loadId;
	}

	public void setLoadId(Integer loadId) {
		this.loadId = loadId;
	}


	@Column(nullable = true, name = "LOAD_NAME")
	public String getLoadName() {
		return loadName;
	}

	public void setLoadName(String loadName) {
		this.loadName = loadName;
	}


	@Column(nullable = true, name = "LOAD_TYPE")
	public String getLoadType() {
		return loadType;
	}

	
	public void setLoadType(String loadType) {
		this.loadType = loadType;
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
	
	@Column(nullable = true, name = "DEPENDENT_LOAD_IDS")
	public String getDependentLoadIds() {
		return dependentLoadIds;
	}

	public void setDependentLoadIds(String dependentLoadIds) {
		this.dependentLoadIds = dependentLoadIds;
	}
	
	@Column(nullable = true, name = "NOTES")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(nullable = true, name = "FORCE_RUN")
	public String getForceRun() {
		return forceRun;
	}

	public void setForceRun(String forceRun) {
		this.forceRun = forceRun;
	}

	@Override
	public String toString() {
		return "Loads [loadId=" + loadId + ", loadName=" + loadName + ", loadType=" + loadType + ", jobOrder="
				+ jobOrder + ", enabled=" + enabled + ", dependentLoadIds=" + dependentLoadIds + ", notes=" + notes
				+ ", forceRun=" + forceRun + "]";
	}
	
}