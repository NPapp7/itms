package com.norbcorp.hungary.itms.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.UserDTO;
import com.norbcorp.hungary.itms.service.DefaultUserService;

@Named("userBean")
@ViewScoped
public class UserBean implements Serializable{

	@Inject
	private DefaultUserService defaultUserService;
	
	private String userName;
	private String password;
	
	List<UserDTO> users;
	
	@PostConstruct
	public void init(){
		users=defaultUserService.getUsers();
	}
	
	public String login(){
		UserDTO userDTO = defaultUserService.getUserByName(userName);
		if(password.equals(userDTO.getPassword())){
			return "logged";
		}
		return null;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public DefaultUserService getDefaultUserService() {
		return defaultUserService;
	}

	public void setDefaultUserService(DefaultUserService defaultUserService) {
		this.defaultUserService = defaultUserService;
	}
}
