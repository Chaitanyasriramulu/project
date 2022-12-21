package com.incident.dto;

import java.util.Date;

public class Incident {
	
	private Long id;
	private String summary;
	private String status;
	private String ownedBy;
	private String qaOwner;
	private String priority;
	private Date creationDate;
	private String createdBy;
	private String dueDate;
	private String description;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwnedBy() {
		return ownedBy;
	}
	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}
	public String getQaOwner() {
		return qaOwner;
	}
	public void setQaOwner(String qaOwner) {
		this.qaOwner = qaOwner;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
		

}
