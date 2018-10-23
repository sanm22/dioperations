package com.logitech.operationmart.beans;

public class RunningLoadsPerDate {

	private String runDate;
	private int nr;
	 
	
	public RunningLoadsPerDate() {
		super();
	}


	public RunningLoadsPerDate(String runDate, int nr) {
		super();
		this.runDate = runDate;
		this.nr = nr;
	}


	public String getRunDate() {
		return runDate;
	}


	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}


	public int getNr() {
		return nr;
	}


	public void setNr(int nr) {
		this.nr = nr;
	}


	@Override
	public String toString() {
		return "RunningLoadsPerDate [runDate=" + runDate + ", nr=" + nr + "]";
	}
	
	
	
	
}
