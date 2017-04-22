package com.norbcorp.hungary.itms.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.IssueDTO;
import com.norbcorp.hungary.persistence.dao.IssueDAO;
import com.norbcorp.hungary.persistence.dao.StatusDAO;
import com.norbcorp.hungary.persistence.dao.TypeDAO;

@Named
@ViewScoped
public class IssueBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IssueDAO issueDAO;
	
	List<IssueDTO> issues;
	
	private IssueDTO issueDTO=new IssueDTO();

	public List<IssueDTO> getIssues() {
		return issueDAO.getIssues();
	}

	public void setIssues(List<IssueDTO> issues) {
		this.issues = issues;
	}

	public IssueDTO getIssueDTO() {
		return issueDTO;
	}

	public void setIssueDTO(IssueDTO issueDTO) {
		this.issueDTO = issueDTO;
	}
	
	public void addIssue(){
		issueDAO.add(issueDTO);
	}
}
