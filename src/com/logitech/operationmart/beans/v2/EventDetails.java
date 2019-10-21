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
@Table(name = "BI_EVENT_DETAILS_VW")
public class EventDetails {

	private final long serialVersionId = 176L;

	private Integer id;
	private String eventType;
	private String loadName;
	private String subLoadName;
	private String eventOrder;
	private String eventMessage;
	private java.util.Date eventTime;
	
	public EventDetails() {
		super();
	}

	public EventDetails(Integer id, String eventType, String loadName, String subLoadName, String eventOrder,
			String eventMessage, Date eventTime) {
		super();
		this.id = id;
		this.eventType = eventType;
		this.loadName = loadName;
		this.subLoadName = subLoadName;
		this.eventOrder = eventOrder;
		this.eventMessage = eventMessage;
		this.eventTime = eventTime;
	}

	@Id
	@Column(nullable = true, name = "ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(nullable = true, name = "EVENT_TYPE")
	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Column(nullable = true, name = "LOAD_NAME")
	public String getLoadName() {
		return loadName;
	}

	public void setLoadName(String loadName) {
		this.loadName = loadName;
	}

	@Column(nullable = true, name = "SUBLOAD_NAME")
	public String getSubLoadName() {
		return subLoadName;
	}

	public void setSubLoadName(String subLoadName) {
		this.subLoadName = subLoadName;
	}

	@Column(nullable = true, name = "EVENT_ORDER")
	public String getEventOrder() {
		return eventOrder;
	}

	public void setEventOrder(String eventOrder) {
		this.eventOrder = eventOrder;
	}

	@Column(nullable = true, name = "EVENT_MESSAGE")
	public String getEventMessage() {
		return eventMessage;
	}

	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}

	@Column(nullable = true, name = "EVENT_TIME")
	public java.util.Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(java.util.Date eventTime) {
		this.eventTime = eventTime;
	}

	@Override
	public String toString() {
		return "EventDetails [id=" + id + ", eventType=" + eventType + ", loadName=" + loadName + ", subLoadName="
				+ subLoadName + ", eventOrder=" + eventOrder + ", eventMessage=" + eventMessage + ", eventTime="
				+ eventTime + "]";
	}
	 
}