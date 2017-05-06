package com.norbcorp.hungary.itms.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.norbcorp.hungary.itms.model.dto.IssueDTO;
import com.norbcorp.hungary.persistence.dao.IssueDAO;

@Stateless
public class DefaultIssueService implements Serializable{

	@Inject
	private IssueDAO issueDAO;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addIssue(IssueDTO issueDTO){
		issueDAO.add(issueDTO);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<IssueDTO> getIssues(){
		return issueDAO.getIssues();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteById(Integer id){
		issueDAO.deleteById(id);
	}
}
