package com.norbcorp.hungary.itms.model.dto;

import java.io.Serializable;

public class ProjectDTO implements Serializable{

	private int id;
	private String description;
	private String name;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
