package com.mycompany.templates.camel.services;

import java.util.Date;

public class Document implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String fullPath;
    private Date modifiedDate;
    private String idNumberClient;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getIdNumberClient() {
		return idNumberClient;
	}
	public void setIdNumberClient(String idNumberClient) {
		this.idNumberClient = idNumberClient;
	}   
}