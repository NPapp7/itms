package com.norbcorp.hungary.itms.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.norbcorp.hungary.itms.model.dto.GroupDTO;
import com.norbcorp.hungary.persistence.dao.GroupDAO;

@Stateless
public class DefaultGroupService {

	@Inject
	private GroupDAO groupDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addGroup(GroupDTO groupDTO){
		groupDAO.add(groupDTO);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<GroupDTO> getAllGroups(){
		return groupDAO.getAllGroups();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<GroupDTO> getAllGroupsWithMembers(){
		return groupDAO.getAllGroupsWithUsers();
	}
}
