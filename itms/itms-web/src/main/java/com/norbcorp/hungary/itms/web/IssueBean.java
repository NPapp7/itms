package com.norbcorp.hungary.itms.web;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.IssueDTO;
import com.norbcorp.hungary.itms.model.dto.StatusDTO;
import com.norbcorp.hungary.itms.model.dto.TypeDTO;
import com.norbcorp.hungary.itms.service.DefaultIssueService;

@Named
@ViewScoped
public class IssueBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(IssueBean.class.getName());

	@Inject
	private DefaultIssueService defaultIssueService;
	
	List<IssueDTO> issues;
	
	private IssueDTO selectedIssueDTO=new IssueDTO();

	public List<IssueDTO> getIssues() {
		return defaultIssueService.getIssues();
	}

	public void setIssues(List<IssueDTO> issues) {
		this.issues = issues;
	}
	
	public IssueDTO getSelectedIssueDTO() {
		return selectedIssueDTO;
	}

	public void setSelectedIssueDTO(IssueDTO selectedIssueDTO) {
		this.selectedIssueDTO = selectedIssueDTO;
	}

	public void addIssue(){
		logger.info("IssueBean is invoked with an issue named "+ selectedIssueDTO.getTitle());
		logger.info(""+selectedIssueDTO.getTypeDTO().getId()+";"+selectedIssueDTO.getTypeDTO().getName());
		logger.info(""+selectedIssueDTO.getStatusDTO().getId()+";"+selectedIssueDTO.getTypeDTO().getName());
		defaultIssueService.addIssue(selectedIssueDTO);
		selectedIssueDTO=new IssueDTO();
	}
}
