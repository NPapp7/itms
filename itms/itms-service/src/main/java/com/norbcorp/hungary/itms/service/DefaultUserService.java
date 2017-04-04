package com.norbcorp.hungary.itms.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.norbcorp.hungary.itms.model.dto.UserDTO;
import com.norbcorp.hungary.persistence.dao.UserDAO;

@Stateless
public class DefaultUserService {

	@Inject
	private UserDAO userDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public UserDTO getUserByName(String userName){
		return userDAO.getUserByUserName(userName);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public UserDTO getUserById(Integer id){
		return userDAO.getUserById(id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<UserDTO> getUsers(){
		return userDAO.getUsers();
	}
}
