package com.norbcorp.hungary.itms.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.UserDTO;
import com.norbcorp.hungary.itms.service.DefaultUserService;

@Named("userManagementBean")
@ViewScoped
public class UserManagementBean implements Serializable{
	private List<UserDTO> users;
	
	@Inject
	private DefaultUserService defaultUserService; 
	
	private UserDTO selectedUser;
	
	private UserDTO user;
	
	private String[] roles=new String[]{"Admin","User"};
	

	public List<UserDTO> getUsers() {
		return defaultUserService.getUsers();
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	public void addUser(){
	}

	public UserDTO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserDTO selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	public void deleteUser(){
		
	}
}
