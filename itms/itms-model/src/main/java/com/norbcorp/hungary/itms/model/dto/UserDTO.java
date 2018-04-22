package com.norbcorp.hungary.itms.model.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	private String name;
	private String password;
	private Date registeredDate;
	private String role;
	private String status;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public UserDTO(String name, Date registeredDate, String role, String status) {
		super();
		this.name = name;
		this.registeredDate = registeredDate;
		this.role = role;
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
