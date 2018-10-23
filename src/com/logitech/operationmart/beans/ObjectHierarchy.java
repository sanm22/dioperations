package com.logitech.operationmart.beans;

public class ObjectHierarchy {

	
	public int id;
	public String dbname;
	public int parent;
	public int size;
	public String style;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public ObjectHierarchy(int id, String dbname, int parent, int size, String style) {
		super();
		this.id = id;
		this.dbname = dbname;
		this.parent = parent;
		this.size = size;
		this.style = style;
	}
	public ObjectHierarchy() {
		super(); 
	}
	 
	
	
	
	
}
