package com.logitech.operationmart.beans;

public class RunningLoadsPerLoadName {

	private String loadName;
	private int nr;
	 
	
	public RunningLoadsPerLoadName() {
		super();
	}


	public RunningLoadsPerLoadName(String loadName, int nr) {
		super();
		this.loadName = loadName;
		this.nr = nr;
	}

 
	public String getLoadName() {
		return loadName;
	}
	
	public void setLoadName(String loadName) {
		this.loadName = loadName;
	}

	public int getNr() {
		return nr;
	}


	public void setNr(int nr) {
		this.nr = nr;
	}


	@Override
	public String toString() {
		return "RunningLoadsPerDate [runDate=" + loadName + ", nr=" + nr + "]";
	}
	
	
	
	
}
