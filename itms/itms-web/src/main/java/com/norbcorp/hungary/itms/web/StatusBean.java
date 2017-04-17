package com.norbcorp.hungary.itms.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.norbcorp.hungary.itms.model.dto.StatusDTO;
import com.norbcorp.hungary.itms.service.DefaultStatusService;

@Named
@ViewScoped
public class StatusBean implements Serializable{

	@Inject
	private DefaultStatusService defaultStatusService;
	
	private StatusDTO newStatus=new StatusDTO();

	public List<StatusDTO> getStatuses() {
		return defaultStatusService.getAllStatuses();
	}
	
	public void addStatus(){
		defaultStatusService.addStatus(newStatus);
	}
	
	public void deleteStatusById(Integer id){
		defaultStatusService.deleteStatusById(id);
	}

	public StatusDTO getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(StatusDTO newStatus) {
		this.newStatus = newStatus;
	}
}
