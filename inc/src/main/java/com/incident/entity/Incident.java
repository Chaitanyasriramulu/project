package com.incident.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "incident")
public class Incident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "ownedBy")
	private String ownedBy;
	
	@Column(name="qaOwner")
	private String qaOwner;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name = "creationDate")
	private Date creationDate;
	
	@Column(name = "createdBy")
	private String createdBy;
	
	@Column(name="dueDate")
	private String dueDate;
	
	@Column(name = "description")
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