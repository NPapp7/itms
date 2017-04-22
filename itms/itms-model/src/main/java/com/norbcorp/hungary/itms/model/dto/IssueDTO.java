package com.norbcorp.hungary.itms.model.dto;

import java.io.Serializable;
import java.util.Date;

public class IssueDTO implements Serializable{

	private int id;
	private Date createdDate;
	private String estimatedTime;
	private Date lastModifiedDate;
	private String remainingDate;
	private String title;
	private String workTime;
	private String description;
	
	private StatusDTO statusDTO;
	private TypeDTO typeDTO;
	
	public IssueDTO(){
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getRemainingDate() {
		return remainingDate;
	}

	public void setRemainingDate(String remainingDate) {
		this.remainingDate = remainingDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkTime() {
		return workTime;
	}

	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusDTO getStatusDTO() {
		return statusDTO;
	}

	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}

	public TypeDTO getTypeDTO() {
		return typeDTO;
	}

	public void setTypeDTO(TypeDTO typeDTO) {
		this.typeDTO = typeDTO;
	}
}
