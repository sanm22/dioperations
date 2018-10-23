package com.logitech.operationmart.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Author: MateenSA
 * Organization: Zensar Technologies
 * Date: 03-Oct-2018
 */

@Entity
@Table(name = "BIOPS_MANUAL_RUNS")
public class ManualRuns {
 
 
	private int manualRunId;
	private int biopsUserId;
	private String biopsUsername;
	private String wsCall;
	private String kettleJobId;
	private String kettleJobPath;
	private String kettleJobName;
	private String serverUrl;
	private String serverResult;
	private String serverMessage;
	private String serverWebresultXml; 
	private Date biopsRecordDate;
	
	public ManualRuns() {
		super();
	}

	
	public ManualRuns(int manualRunId, int biopsUserId, String biopsUsername, String wsCall, String kettleJobId,
			String kettleJobPath, String kettleJobName, String serverUrl, String serverResult, String serverMessage,
			String serverWebresultXml, Date biopsRecordDate) {
		super();
		this.manualRunId = manualRunId;
		this.biopsUserId = biopsUserId;
		this.biopsUsername = biopsUsername;
		this.wsCall = wsCall;
		this.kettleJobId = kettleJobId;
		this.kettleJobPath = kettleJobPath;
		this.kettleJobName = kettleJobName;
		this.serverUrl = serverUrl;
		this.serverResult = serverResult;
		this.serverMessage = serverMessage;
		this.serverWebresultXml = serverWebresultXml;
		this.biopsRecordDate  = biopsRecordDate;
	} 


	@Id
	@Column(nullable = false, name = "MANUAL_RUN_ID")
	public int getManualRunId() {
		return manualRunId;
	}


	public void setManualRunId(int manualRunId) {
		this.manualRunId = manualRunId;
	}
	
 
	@Column(nullable = false, name = "BIOPS_USER_ID")
	public int getBiopsUserId() {
		return biopsUserId;
	}


	public void setBiopsUserId(int biopsUserId) {
		this.biopsUserId = biopsUserId;
	}

	@Column(nullable = true, name = "BIOPS_USERNAME")
	public String getBiopsUsername() {
		return biopsUsername;
	}


	public void setBiopsUsername(String biopsUsername) {
		this.biopsUsername = biopsUsername;
	}
	
	@Column(nullable = true, name = "WS_CALL")
	public String getWsCall() {
		return wsCall;
	}
	
	public void setWsCall(String wsCall) {
		this.wsCall = wsCall;
	}
	
	@Column(nullable = true, name = "KETTLE_JOB_ID")
	public String getKettleJobId() {
		return kettleJobId;
	}


	public void setKettleJobId(String kettleJobId) {
		this.kettleJobId = kettleJobId;
	}

	@Column(nullable = true, name = "KETTLE_JOB_PATH")
	public String getKettleJobPath() {
		return kettleJobPath;
	}


	public void setKettleJobPath(String kettleJobPath) {
		this.kettleJobPath = kettleJobPath;
	}

	@Column(nullable = true, name = "KETTLE_JOB_NAME")
	public String getKettleJobName() {
		return kettleJobName;
	}


	public void setKettleJobName(String kettleJobName) {
		this.kettleJobName = kettleJobName;
	}

	@Column(nullable = true, name = "SERVER_URL")
	public String getServerUrl() {
		return serverUrl;
	}


	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	@Column(nullable = true, name = "SERVER_RESULT")
	public String getServerResult() {
		return serverResult;
	}


	public void setServerResult(String serverResult) {
		this.serverResult = serverResult;
	}

	@Column(nullable = true, name = "SERVER_MESSAGE")
	public String getServerMessage() {
		return serverMessage;
	}


	public void setServerMessage(String serverMessage) {
		this.serverMessage = serverMessage;
	}

	@Column(nullable = true, name = "SERVER_WEBRESULT_XML")
	public String getServerWebresultXml() {
		return serverWebresultXml;
	}


	public void setServerWebresultXml(String serverWebresultXml) {
		this.serverWebresultXml = serverWebresultXml;
	}
 
	@Column(nullable = true, name = "RECORD_DATE", columnDefinition="TIMESTAMP")
	public Date getBiopsRecordDate() {
		return biopsRecordDate;
	}
	
	public void setBiopsRecordDate(Date biopsRecordDate) {
		this.biopsRecordDate = biopsRecordDate;
	}
	

	@Override
	public String toString() {
		return "ManualRuns [manualRunId=" + manualRunId + ", biopsUserId=" + biopsUserId + ", biopsUsername="
				+ biopsUsername + ", wsCall=" + wsCall + ", kettleJobId=" + kettleJobId + ", kettleJobPath="
				+ kettleJobPath + ", kettleJobName=" + kettleJobName + ", serverUrl=" + serverUrl + ", serverResult="
				+ serverResult + ", serverMessage=" + serverMessage + ", serverWebresultXml=" + serverWebresultXml
				+ " ]";
	}

 
	
	
	
}