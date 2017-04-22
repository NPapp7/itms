package com.norbcorp.hungary.itms.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.norbcorp.hungary.itms.model.dto.IssueDTO;
import com.norbcorp.hungary.persistence.dao.IssueDAO;
import com.norbcorp.hungary.persistence.dao.StatusDAO;
import com.norbcorp.hungary.persistence.dao.TypeDAO;

@Stateless
public class DefaultIssueService {

	@Inject
	private IssueDAO issueDAO;
	@Inject 
	private TypeDAO typeDAO;
	@Inject
	private StatusDAO statusDAO;
	
	public void addIssue(IssueDTO issueDTO){
		
	}
}
