package com.norbcorp.hungary.itms.web;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.UserDTO;
import com.norbcorp.hungary.itms.service.DefaultUserService;
import com.norbcorp.hungary.itms.web.security.PasswordAuthentication;

@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DefaultUserService defaultUserService;

	private final static String TOKEN = "$31$";
	
	private String userName;
	private String password;
	
	/**
	 * Logged user
	 */
	private UserDTO currentUser;

	public String login() {
		UserDTO userDTO = defaultUserService.getUserByName(userName);
		if (userDTO != null) {
			PasswordAuthentication ps = new PasswordAuthentication();
			if (ps.authenticate(password.toCharArray(), userDTO.getPassword())) {
				currentUser=userDTO;
				return "logged";
			}
			else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong password or username"));
			}
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

	public UserDTO getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserDTO currentUser) {
		this.currentUser = currentUser;
	}
	
	public String logout(){
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		System.out.println(ec.getRequestContextPath());
		ec.invalidateSession();
		return "login";
	}
}
