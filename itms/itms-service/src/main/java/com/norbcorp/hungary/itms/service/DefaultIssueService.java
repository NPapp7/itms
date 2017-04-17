package com.norbcorp.hungary.itms.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.norbcorp.hungary.persistence.dao.IssueDAO;

@Stateless
public class DefaultIssueService {

	@Inject
	private IssueDAO issueDAO;
	
	
}
