package com.logitech.operationmart.beans;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;



@XmlRootElement(name="webresult")
@XmlAccessorType (XmlAccessType.FIELD)
public class Webresult 
{
    private String result;
    private String message;
    private String id; 
    
    @XmlElement(name = "webresult")
    private List<Webresult> webresults = null;
       
    public Webresult() {
    	super();
    }

	public Webresult(String result, String message, String id) {
		super();
		this.result = result;
		this.message = message;
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "KettleExecuteResponseBean [result=" + result + ", message=" + message + ", id=" + id + "]";
	}

	public List<Webresult> getWebresults() {
		return webresults;
	}

	public void setWebresults(List<Webresult> webresults) {
		this.webresults = webresults;
	}
 
	
    
}
