package com.norbcorp.hungary.itms.model.dto;

import java.io.Serializable;
import java.util.List;

public class GroupDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	
	private List<UserDTO> users;
	
	public GroupDTO() {
		super();
	}
	public GroupDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public GroupDTO(String name, String description, List<UserDTO> users) {
		super();
		this.name = name;
		this.description = description;
		this.users = users;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
}
