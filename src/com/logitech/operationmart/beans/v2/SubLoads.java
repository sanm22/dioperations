package com.logitech.operationmart.beans.v2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 */

@Entity
@Table(name = "BI_SUBLOADS")
public class SubLoads {

	@SuppressWarnings("unused")
	private final long serialVersionId = 2176L;

	private Integer subLoadId;
	private String subLoadName;
	private int jobOrder;
	private String enabled;
	private String dependentLoadIds;
	private String notes;	

	
	private Loads load;
	
	
	public SubLoads() {
		super();
	}
	
	public SubLoads(Loads loads, Integer subLoadId, String subLoadName, int jobOrder, String enabled,
			String dependentLoadIds, String notes) {
		super();
		this.subLoadId = subLoadId;
		this.subLoadName = subLoadName;
		this.jobOrder = jobOrder;
		this.enabled = enabled;
		this.dependentLoadIds = dependentLoadIds;
		this.notes = notes;
		this.load = loads;
	}


	@Id
	@Column(nullable = true, name = "SUBLOAD_ID")
	public Integer getSubLoadId() {
		return subLoadId;
	}

	public void setSubLoadId(Integer subLoadId) {
		this.subLoadId = subLoadId;
	}

	@Column(nullable = true, name = "SUBLOAD_NAME")
	public String getSubLoadName() {
		return subLoadName;
	}

	public void setSubLoadName(String subLoadName) {
		this.subLoadName = subLoadName;
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

	@Column(nullable = true, name = "DEPENDENT_SUBLOAD_IDS")
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
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="LOAD_ID", referencedColumnName = "LOAD_ID")
	public Loads getLoads() {
		return load;
	}
	
	public void setLoads(Loads loads) {
		this.load = loads;
	}

	@Override
	public String toString() {
		return "SubLoads [loads=" + load + ", subLoadId=" + subLoadId + ", subLoadName=" + subLoadName
				+ ", jobOrder=" + jobOrder + ", enabled=" + enabled + ", dependentLoadIds=" + dependentLoadIds
				+ ", notes=" + notes + "]";
	}
	 
	
}