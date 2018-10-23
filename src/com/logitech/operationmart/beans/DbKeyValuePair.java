package com.logitech.operationmart.beans;
import java.util.List;

public class DbKeyValuePair {

	public String tbname;
	public List<String> clnames;
	
	public String getTbname() {
		return tbname;
	}
	public void setTbname(String tbname) {
		this.tbname = tbname;
	}
	public List<String> getClnames() {
		return clnames;
	}
	public void setClnames(List<String> clnames) {
		this.clnames = clnames;
	}
	
	public DbKeyValuePair() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DbKeyValuePair(String tbname, List<String> clnames) {
		super();
		this.tbname = tbname;
		this.clnames = clnames;
	}
	
	
	
	
}
