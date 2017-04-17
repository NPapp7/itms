package com.norbcorp.hungary.itms.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.IssueDTO;
import com.norbcorp.hungary.persistence.dao.IssueDAO;

@Named("issueBean")
@ViewScoped
public class IssueBean {

	@Inject
	private IssueDAO issueDAO;;
	
	List<IssueDTO> issues;
	
	@PostConstruct
	public void init(){
		issues=issueDAO.getIssues();
	}

	public List<IssueDTO> getIssues() {
		return issues;
	}

	public void setIssues(List<IssueDTO> issues) {
		this.issues = issues;
	}
}
